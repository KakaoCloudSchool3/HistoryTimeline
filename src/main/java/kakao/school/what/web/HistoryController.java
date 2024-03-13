package kakao.school.what.web;

import io.swagger.v3.oas.annotations.tags.Tag;
import kakao.school.what.domain.History;
import kakao.school.what.dto.HistoryResponseTimelineDto;
import kakao.school.what.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "HistoryController", description = "History 관련 Controller")
public class HistoryController {
    @Autowired
    private HistoryService historyService;
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

    @GetMapping("/timeline/compareKorea")
    @ResponseBody
    // 년도, 비교 나라 id를 입력받아 둘의 역사를 날짜 순으로 반환
    public Page<HistoryResponseTimelineDto> getHistoryResponseByYearAndCountryId(
            @RequestParam(value = "year") int year,
            @RequestParam(value = "countryId") long countryId,
            @RequestParam(value = "page") int page
    ) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.ASC, "year", "month", "day", "createdAt"));
        return historyService.listHistoryDtoByYearAndCountryId(year, countryId, pageable);
    }

}
