package kakao.school.what.web;

import io.swagger.v3.oas.annotations.tags.Tag;
import kakao.school.what.dto.request.HistoryReportRequestDto;
import kakao.school.what.service.HistoryReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
