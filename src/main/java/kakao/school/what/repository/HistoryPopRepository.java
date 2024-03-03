package kakao.school.what.repository;

import kakao.school.what.domain.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryPopRepository extends JpaRepository<History, Long> {

}
