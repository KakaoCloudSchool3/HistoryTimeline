package kakao.school.what.repository;

import kakao.school.what.domain.HistoryReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryReportRepository extends JpaRepository<HistoryReport, Long> {
}
