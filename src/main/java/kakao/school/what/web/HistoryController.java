package kakao.school.what.web;

import io.swagger.v3.oas.annotations.tags.Tag;
import kakao.school.what.domain.History;
import kakao.school.what.domain.HistoryDetail;
import kakao.school.what.dto.HistoryResponseTimelineDto;
import kakao.school.what.dto.request.HistoryRequestDto;
import kakao.school.what.dto.response.HistoryMainLineDto;
import kakao.school.what.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "HistoryController", description = "History 관련 Controller")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    // 국가 id, 페이지 번호, 페이지 당 개수를 입력으로 받아 history를 반환합니다.
    // 예시 용, 추후에 삭제하도록 하겠습니다.
    @GetMapping("/history")
    public Page<History> getHistoryListByCountryId(
            @RequestParam(value = "countryId", required = false) Long countryId,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, "createdAt"));
        return historyService.listHistoryByCountryId(countryId, pageable);
    }

    @GetMapping("/history/one")
    public List<History> getHistory(@RequestParam(value = "historyId", required = false) Long historyId) {
        return historyService.getHistory(historyId);
    }

    @GetMapping("/timeline/korea")
    @ResponseBody
    // 년도를 입력받아 이후 한국 역사를 날짜순으로 반환
    public Page<HistoryResponseTimelineDto> getKoreaHistoryResponseByYear(
            @RequestParam(value = "year") int year,
            @RequestParam(value = "page") int page
    ) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.ASC, "year", "month", "day", "createdAt"));
        return historyService.listKoreaHistoryDtoByYear(year, pageable);
    }

    // 우선순위가 1인 한국 데이터 불러옴. 최근 날짜 순
    @GetMapping("/priority/korea")
    public List<HistoryMainLineDto> getPriorityOneInKorea() {
        return historyService.getPriorityOneInKorea();
    }

    @GetMapping("/timeline/compareKorea")
    @ResponseBody
    // 년도, 비교 나라 id를 입력받아 둘의 역사를 날짜 순으로 반환
    public Page<HistoryResponseTimelineDto> getHistoryResponseByYearAndCountryId(
            @RequestParam(value = "year") int year,
            @RequestParam(value = "countryId") long countryId,
            @RequestParam(value = "page") int page
    ) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "year", "month", "day", "createdAt"));
        return historyService.listHistoryDtoByYearAndCountryId(year, countryId, pageable);
    }

    @PostMapping("/saveHistory")
    public  void saveHistory(@RequestBody HistoryRequestDto requestDto){
        historyService.saveHistory(requestDto);
    }

}
