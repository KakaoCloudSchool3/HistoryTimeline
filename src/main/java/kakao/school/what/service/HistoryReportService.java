package kakao.school.what.service;

import kakao.school.what.domain.HistoryReport;
import kakao.school.what.dto.request.HistoryReportRequestDto;
import kakao.school.what.repository.HistoryReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
