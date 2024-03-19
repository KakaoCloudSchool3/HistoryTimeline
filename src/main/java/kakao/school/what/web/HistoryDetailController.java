package kakao.school.what.web;

import kakao.school.what.domain.HistoryDetail;
import kakao.school.what.dto.HistoryDetailPopDTO;
import kakao.school.what.service.HistoryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historyDeatil")
public class HistoryDetailController {
    @Autowired
    private HistoryDetailService historyDetailService;

    // historyid에 따른 detail 반환
    @GetMapping("/one")
    public List<HistoryDetail> getHistoryDetail(@RequestParam(value = "historyId", required = false) Long historyId) {
        return historyDetailService.getHistoryDetail(historyId);
    }
}
