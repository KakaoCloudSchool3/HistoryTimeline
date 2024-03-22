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

    // historyid에 해당하는 detail 반환
    public List<HistoryDetail> getHistoryDetail(Long historyId){
        return historyDetailRepository.findByHistoryId(historyId);
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
