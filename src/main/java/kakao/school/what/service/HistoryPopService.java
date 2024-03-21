package kakao.school.what.service;

import kakao.school.what.domain.History;
import kakao.school.what.domain.HistoryDetail;
import kakao.school.what.dto.HistoryDetailPopDTO;
import kakao.school.what.dto.HistoryPopDTO;
import kakao.school.what.repository.HistoryDetailRepository;
import kakao.school.what.repository.HistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryPopService {
    private final HistoryRepository historyRepository;
    private final HistoryDetailRepository historyDetailRepository;

    public HistoryPopService(HistoryRepository historyRepository, HistoryDetailRepository historyDetailRepository) {
        this.historyRepository = historyRepository;
        this.historyDetailRepository = historyDetailRepository;
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
}
