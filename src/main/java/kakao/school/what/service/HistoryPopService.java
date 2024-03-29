package kakao.school.what.service;

import kakao.school.what.domain.Content;
import kakao.school.what.domain.History;
import kakao.school.what.domain.HistoryDetail;
import kakao.school.what.dto.HistoryDetailPopDTO;
import kakao.school.what.dto.HistoryPopContentDTO;
import kakao.school.what.dto.HistoryPopDTO;
import kakao.school.what.repository.ContentRepository;
import kakao.school.what.repository.HistoryDetailRepository;
import kakao.school.what.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryPopService {
    private final HistoryRepository historyRepository;
    private final HistoryDetailRepository historyDetailRepository;
    private final ContentRepository contentRepository;

    @Autowired
    public HistoryPopService(HistoryRepository historyRepository, HistoryDetailRepository historyDetailRepository, ContentRepository contentRepository) {
        this.historyRepository = historyRepository;
        this.historyDetailRepository = historyDetailRepository;
        this.contentRepository = contentRepository;
    }

    public HistoryPopDTO getHistoryPopDTO(Long historyId) {
        History history = historyRepository.findById(historyId).orElse(null);
        List<HistoryDetail> historyDetails = historyDetailRepository.findByHistoryId(historyId);

        // HistoryPopDTO에 detail 정보 추가
        List<String> details = historyDetails.stream().map(HistoryDetail::getDetail).collect(Collectors.toList());

        return new HistoryPopDTO(
                history.getTitle(),
                history.getYear(),
                history.getMonth(),
                history.getDay(),
                history.getBrief(),
                history.getImgUrl()
        );
    }

    public List<String> getHistoryDetail(Long historyId) {
        List<HistoryDetail> historyDetails = historyDetailRepository.findByHistoryId(historyId);
        return historyDetails.stream()
                .map(HistoryDetail::getDetail)
                .collect(Collectors.toList());
    }

    public HistoryDetailPopDTO getHistoryDetailPopDTO(Long historyDetailId) {
        HistoryDetail historyDetail = historyDetailRepository.findById(historyDetailId).orElse(null);

        if (historyDetail == null) {
            return null;
        }
        return new HistoryDetailPopDTO(
                historyDetail.getDetail()
        );
    }

    public List<Content> getContentByCountryAndYear(Long countryId, Integer year) {
        // year 값의 앞 두 자리를 추출하여 태그 결정
        Integer tag = year / 100;

        // 국가와 태그에 해당하는 콘텐츠를 조회하여 반환
        return contentRepository.findByCountryIdAndTag(countryId, tag);
    }

    public List<String> getMovieTitlesByCountryAndYear(Long countryId, Integer year) {
        List<Content> contents = contentRepository.findByCountryIdAndTag(countryId, year / 100);
        return contents.stream()
                .map(Content::getTitle)
                .collect(Collectors.toList());
    }
}
