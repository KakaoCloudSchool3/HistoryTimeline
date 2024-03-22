package kakao.school.what.repository;

import kakao.school.what.domain.HistoryReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryReportRepository extends JpaRepository<HistoryReport, Long> {

    // 제보들을 페이지로 불러오는 메소드
    Page<HistoryReport> findAll(Pageable pageable);
}
