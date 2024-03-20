package kakao.school.what.service;

import kakao.school.what.domain.History;
import kakao.school.what.domain.HistoryDetail;
import kakao.school.what.dto.HistoryDetailPopDTO;
import kakao.school.what.dto.HistoryPopDTO;
import kakao.school.what.repository.HistoryDetailRepository;
import kakao.school.what.repository.HistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return new HistoryPopDTO(
                history.getTitle(),
                history.getYear(),
                history.getMonth(),
                history.getDay(),
                history.getBrief(),
                history.getImgUrl()
        );
    }

    public List<HistoryDetail> getHistoryDetail(Long historyId){
        return historyDetailRepository.findByHistoryId(historyId);
    };

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
