package kakao.school.what.service;

import kakao.school.what.domain.HistoryReport;
import kakao.school.what.dto.request.HistoryReportRequestDto;
import kakao.school.what.dto.response.HistoryReportResponseListDto;
import kakao.school.what.repository.HistoryReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class HistoryReportService {

    @Autowired
    private HistoryReportRepository historyReportRepository;

    // HistoryReport DB 저장 메소드
    public void saveHistoryReport(HistoryReportRequestDto dto) {
        HistoryReport report = new HistoryReport();
        report.setReport(dto.getReport());
        report.setUserId(dto.getUserId());
        historyReportRepository.save(report);
    }

    // HistoryReport Page 불러오는 메소드
    public Page<HistoryReportResponseListDto> listHistoryReportDto(Pageable pageable) {
        return HistoryReportEntityToListDto(historyReportRepository.findAll(pageable));
    }

    // HistoryReport를 HistoryReportResponseListDto로 변형
    public Page<HistoryReportResponseListDto> HistoryReportEntityToListDto(Page<HistoryReport> page) {
        return page.map(entity ->
            new HistoryReportResponseListDto(
                    entity.getHistoryReportId(),
                    entity.getReport(),
                    entity.getCreatedAt().format(DateTimeFormatter.ISO_DATE)
            )
        );
    }
}
