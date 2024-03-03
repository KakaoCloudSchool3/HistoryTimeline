package kakao.school.what.repository;

import kakao.school.what.domain.History;
import kakao.school.what.domain.HistoryDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryDetailPopRepository extends JpaRepository<HistoryDetail,Long> {

}
