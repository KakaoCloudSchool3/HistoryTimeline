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
@RequestMapping("/historyDeatilPop")
public class HistoryDetailController {
    @Autowired
    private HistoryDetailService historyDetailService;

//    public HistoryDetailPopController(HistoryDetialPopService historyDetialPopService) {
//        this.historyDetialPopService = historyDetialPopService;
//    }

    @GetMapping("/one")
    public List<HistoryDetail> getHistoryDetail(@RequestParam(value = "historyId", required = false) Long historyId) {
        return historyDetailService.getHistoryDetail(historyId);
    }

    @GetMapping("/{historyDetailId}")
    public ResponseEntity<HistoryDetailPopDTO> getHistoryDetailPopDTO(@PathVariable Long historyDetailId) {
        HistoryDetailPopDTO historyDetailPopDTO = historyDetailService.getHistoryDetailPopDTO(historyDetailId);
        if (historyDetailPopDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(historyDetailPopDTO, HttpStatus.OK);
    }
}
