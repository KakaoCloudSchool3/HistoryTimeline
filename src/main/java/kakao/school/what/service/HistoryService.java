package kakao.school.what.service;

import kakao.school.what.domain.History;
import kakao.school.what.domain.HistoryDetail;
import kakao.school.what.dto.HistoryResponseTimelineDto;
import kakao.school.what.dto.request.HistoryDetailRequestDto;
import kakao.school.what.dto.request.HistoryRequestDto;
import kakao.school.what.dto.response.HistoryMainLineDto;
import kakao.school.what.repository.HistoryDetailRepository;
import kakao.school.what.repository.HistoryRepository;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private HistoryDetailRepository historyDetailRepository;

    public List<History>getHistory(Long historyId){
        return historyRepository.findAllByHistoryId(historyId);
    }

    // 우선순위가 1인 한국 역사 데이터 불러옴. 우선 순위와 나라 변수 값을 바꾸면 다른 나라 데이터 얻어올 수 있음.
    public List<HistoryMainLineDto> getPriorityOneInKorea() {
        Long countryId = 410L;
        Integer priority = 1;
        List<History> histories = historyRepository.findByCountryIdAndPriority(countryId, priority, PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "year")));
        return histories.stream()
                .map(history -> new HistoryMainLineDto(
                        history.getTitle(),
                        history.getPriority(),
                        history.getBrief(),
                        history.getYear(),
                        history.getImgUrl()
                ))
                .collect(Collectors.toList());
    }

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

    // 역사 아이디로 History를 삭제하는 메소드
    @Transactional
    public void deleteHistoryByHistoryId(Long historyId) {
        historyRepository.delete(historyRepository.findByHistoryId(historyId));
    }

    // 나라 아이디로 History가 존재하는지 확인하는 메소드
    public boolean checkExistenceHistoryByCountryId(Long countryId) {
        return historyRepository.existsByCountryId(countryId);
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

    /**
     *
     * history 데이터를 저장함.
     * requestDto = 웹사이트에서 보내진 데이터
     * history, historydetail 각각에 맞게 데이터를 저장한다.
     */
    @Transactional
    public void saveHistory(HistoryRequestDto requestDto){
        History history = dtoToHistoryEntities(requestDto);
        History savedHistory = historyRepository.save(history);
        log.info("^MS^ save history");
        Long savedHistoryId = savedHistory.getHistoryId();

        HistoryDetail historyDetail = dtoToHistoryDetailEntity(requestDto, savedHistoryId);
        historyDetailRepository.save(historyDetail);
    }

    private History dtoToHistoryEntities(HistoryRequestDto requestDto) {
        History history = new History();
        history.setTitle(requestDto.getTitle());
        history.setPriority(requestDto.getPriority());
        history.setCountryId(requestDto.getCountryId());
        history.setBrief(requestDto.getBrief());
        history.setYear(requestDto.getYear());
        history.setMonth(requestDto.getMonth());
        history.setDay(requestDto.getDay());
        history.setImgUrl(requestDto.getImgUrl());
        log.info(history);
        return history;
    }

    private HistoryDetail dtoToHistoryDetailEntity(HistoryRequestDto requestDto, Long historyId) {
        HistoryDetail historyDetail = new HistoryDetail();
        historyDetail.setHistoryId(historyId);
        historyDetail.setDetail(requestDto.getDetail());
        return historyDetail;
    }
}
