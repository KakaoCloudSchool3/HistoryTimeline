package kakao.school.what.repository;

import kakao.school.what.domain.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    // 국가 id에 따라 history를 page로 불러옴
    // 예시용이므로 추후 삭제하겠습니다.
    Page<History> findAllByCountryId(Long countryId, Pageable pageable);

    List<History> findByCountryIdAndPriority(Long countryId, Integer priority, Pageable pageable);

    // year 이후 한국 History를 Page로 불러옴
    Page<History> findAllByCountryIdAndYearGreaterThanEqual(Long countryId, Integer year, Pageable pageable);

    // year 이후 한국과 해당 나라 History를 Page로 불러옴
    Page<History> findAllByCountryIdInAndYearGreaterThanEqual(List<Long> countryIds, Integer year, Pageable pageable);
}
