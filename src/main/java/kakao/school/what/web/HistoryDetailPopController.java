package kakao.school.what.web;

import kakao.school.what.dto.HistoryDetailPopDTO;
import kakao.school.what.dto.HistoryPopDTO;
import kakao.school.what.service.HistoryDetialPopService;
import kakao.school.what.service.HistoryPopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/historyDeatilPop")
public class HistoryDetailPopController {
    private final HistoryDetialPopService historyDetialPopService;

    public HistoryDetailPopController(HistoryDetialPopService historyDetialPopService) {
        this.historyDetialPopService = historyDetialPopService;
    }


    @GetMapping("/{historyDetailId}")
    public ResponseEntity<HistoryDetailPopDTO> getHistoryDetailPopDTO(@PathVariable Long historyDetailId) {
        HistoryDetailPopDTO historyDetailPopDTO = historyDetialPopService.getHistoryDetailPopDTO(historyDetailId);
        if (historyDetailPopDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(historyDetailPopDTO, HttpStatus.OK);
    }
}
