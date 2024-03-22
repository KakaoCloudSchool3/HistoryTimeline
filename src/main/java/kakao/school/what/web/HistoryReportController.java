package kakao.school.what.web;

import io.swagger.v3.oas.annotations.tags.Tag;
import kakao.school.what.dto.request.HistoryReportRequestDto;
import kakao.school.what.dto.response.HistoryReportResponseListDto;
import kakao.school.what.service.HistoryReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "HistoryReportController", description = "History Report 관련 Controller")
public class HistoryReportController {
    @Autowired
    private HistoryReportService historyReportService;

    // report 내용과 userId를 받아 DB에 report 저장
    @PostMapping("/report/save")
    public void saveHistoryReport(@RequestBody HistoryReportRequestDto dto) {
        historyReportService.saveHistoryReport(dto);
    }

    // report 리스트 불러오기
    @GetMapping("/report/list")
    public Page<HistoryReportResponseListDto> getHistoryReportResponse(
            @RequestParam("page") int page
    ) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "createdAt"));
        return historyReportService.listHistoryReportDto(pageable);
    }

}
