package kakao.school.what.web;

import kakao.school.what.domain.Content;
import kakao.school.what.dto.HistoryDetailPopDTO;
import kakao.school.what.dto.HistoryPopContentDTO;
import kakao.school.what.dto.HistoryPopDTO;
import kakao.school.what.service.HistoryPopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/content/{countryId}/{year}")
    public ResponseEntity<List<HistoryPopContentDTO>> getContentByCountryAndYear(@PathVariable Long countryId, @PathVariable Integer year) {
        List<Content> contents = historyPopService.getContentByCountryAndYear(countryId, year);
        if (contents.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Content를 HistoryPopContentDTO로 변환하여 반환
        List<HistoryPopContentDTO> contentDTOs = contents.stream()
                .map(content -> {
                    HistoryPopContentDTO dto = new HistoryPopContentDTO();
                    dto.setTitle(content.getTitle());
                    dto.setCountryId(content.getCountryId());
                    dto.setTag(content.getTag());
                    return dto;
                })
                .collect(Collectors.toList());

        return new ResponseEntity<>(contentDTOs, HttpStatus.OK);
    }
}
