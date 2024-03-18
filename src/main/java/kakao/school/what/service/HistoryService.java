package kakao.school.what.service;

import kakao.school.what.domain.History;
import kakao.school.what.dto.HistoryResponseTimelineDto;
import kakao.school.what.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    // 한국 역사만 History Response Timeline Dto로 반환하는 메소드
    public Page<HistoryResponseTimelineDto> listKoreaHistoryDtoByYear(Integer year, Pageable pageable) {
        return historyEntityToTimelineDto(historyRepository.findAllByCountryIdAndYearGreaterThanEqual(410L, year, pageable));
    }

    // 한국 역사와 해당 나라의 역사를 같이 가져와 History Response Timeline Dto로 반환하는 메소드
    public Page<HistoryResponseTimelineDto> listHistoryDtoByYearAndCountryId(Integer year, Long countryId, Pageable pageable) {
        List<Long> countryIds = new ArrayList<>();
        countryIds.add(410L); // Korea Id
        countryIds.add(countryId);
        return historyEntityToTimelineDto(historyRepository.findAllByCountryIdInAndYearGreaterThanEqual(countryIds, year, pageable));
    }

    // 역사 리스트를 불러와 History Response Timeline Dto로 반환하는 메소드
    public Page<HistoryResponseTimelineDto> listHistoryDto(Pageable pageable) {
        return historyEntityToTimelineDto(historyRepository.findAll(pageable));
    }

    // History Entity Page를 History Response Timeline Dto로 변경하는 메소드
    private Page<HistoryResponseTimelineDto> historyEntityToTimelineDto(Page<History> entityPage) {
        Page<HistoryResponseTimelineDto> dtoPage = entityPage
                .map(entity ->
                        new HistoryResponseTimelineDto(
                                entity.getHistoryId(),
                                entity.getTitle(),
                                entity.getPriority(),
                                entity.getCountryId(),
                                entity.getBrief(),
                                entity.getYear(),
                                entity.getMonth(),
                                entity.getDay(),
                                entity.getImgUrl()
                        ));
        return dtoPage;
    }
}
