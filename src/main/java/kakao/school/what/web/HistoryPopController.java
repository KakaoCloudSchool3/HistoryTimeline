package kakao.school.what.web;

import kakao.school.what.dto.HistoryPopDTO;
import kakao.school.what.service.HistoryPopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/historyPop")
public class HistoryPopController {
    private final HistoryPopService historyPopService;

    @Autowired
    public HistoryPopController(HistoryPopService historyPopService) {
        this.historyPopService = historyPopService;
    }

    @GetMapping("/{historyId}")
    public ResponseEntity<HistoryPopDTO> getHistoryPop(@PathVariable Long historyId) {
        HistoryPopDTO historyPopDTO = historyPopService.getHistoryPopDTO(historyId);
        if (historyPopDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(historyPopDTO, HttpStatus.OK);
    }
}
