package kakao.school.what.repository;

import kakao.school.what.domain.HistoryDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryDetailRepository extends JpaRepository<HistoryDetail,Long> {
    List<HistoryDetail> findByHistoryId(Long historyId);
}
