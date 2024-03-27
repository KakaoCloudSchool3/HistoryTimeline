package kakao.school.what.web;

import kakao.school.what.domain.Content;
import kakao.school.what.dto.HistoryDetailPopDTO;
import kakao.school.what.dto.HistoryPopDTO;
import kakao.school.what.service.HistoryPopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        List<String> details = historyPopService.getHistoryDetail(historyId);
        historyPopDTO.setDetail(details);

        return new ResponseEntity<>(historyPopDTO, HttpStatus.OK);
    }

    @GetMapping("/detail/{historyId}")
    public ResponseEntity<HistoryDetailPopDTO> getHistoryDetail(@PathVariable Long historyId) {
        HistoryDetailPopDTO historyDetailPopDTO = historyPopService.getHistoryDetailPopDTO(historyId);
        if (historyDetailPopDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(historyDetailPopDTO, HttpStatus.OK);
    }

    @GetMapping("/content")
    public ResponseEntity<List<Content>> getContentByCountryAndYear(@RequestParam Long countryId, @RequestParam Integer year) {
        List<Content> contents = historyPopService.getContentByCountryAndYear(countryId, year);
        if (contents.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contents, HttpStatus.OK);
    }


}
