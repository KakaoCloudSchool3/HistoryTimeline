package kakao.school.what.service;

import kakao.school.what.domain.History;
import kakao.school.what.domain.HistoryDetail;
import kakao.school.what.dto.HistoryPopDTO;
import kakao.school.what.repository.HistoryDetailPopRepository;
import kakao.school.what.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryPopService {
    private final HistoryRepository historyRepository;


    public HistoryPopService(HistoryRepository historyRepository, HistoryDetailPopRepository historyDetailPopRepository) {
        this.historyRepository = historyRepository;

    }

    public HistoryPopDTO getHistoryPopDTO(Long historyId) {
        History history = historyRepository.findById(historyId).orElse(null);

        if (history == null) {
            return null;
        }
        return new HistoryPopDTO(
                history.getTitle(),
                history.getYear(),
                history.getMonth(),
                history.getDay(),
                history.getImg_url(),
                history.getBrief()
        );
    }
}
