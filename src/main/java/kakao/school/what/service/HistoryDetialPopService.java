package kakao.school.what.service;

import kakao.school.what.domain.History;
import kakao.school.what.domain.HistoryDetail;
import kakao.school.what.dto.HistoryDetailPopDTO;
import kakao.school.what.dto.HistoryPopDTO;
import kakao.school.what.repository.HistoryDetailPopRepository;
import kakao.school.what.repository.HistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class HistoryDetialPopService {
    private final HistoryDetailPopRepository historyDetailPopRepository;

    public HistoryDetialPopService(HistoryDetailPopRepository historyDetailPopRepository) {
        this.historyDetailPopRepository = historyDetailPopRepository;
    }


    public HistoryDetailPopDTO getHistoryDetailPopDTO(Long historyDetailId) {
        HistoryDetail historyd = historyDetailPopRepository.findById(historyDetailId).orElse(null);

        if (historyd == null) {
            return null;
        }
        return new HistoryDetailPopDTO(
                historyd.getDetail()
        );
    }
}
