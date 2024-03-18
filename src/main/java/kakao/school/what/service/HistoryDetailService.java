package kakao.school.what.service;

import kakao.school.what.domain.HistoryDetail;
import kakao.school.what.dto.HistoryDetailPopDTO;
import kakao.school.what.repository.HistoryDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryDetailService {
    @Autowired
    private HistoryDetailRepository historyDetailRepository;

    public List<HistoryDetail> getHistoryDetail(Long historyId){
        return historyDetailRepository.findByHistoryId(historyId);
    };
    public HistoryDetailService(HistoryDetailRepository historyDetailRepository) {
        this.historyDetailRepository = historyDetailRepository;
    }


    public HistoryDetailPopDTO getHistoryDetailPopDTO(Long historyDetailId) {
        HistoryDetail historyd = historyDetailRepository.findById(historyDetailId).orElse(null);

        if (historyd == null) {
            return null;
        }
        return new HistoryDetailPopDTO(
                historyd.getDetail()
        );
    }
}
