package kakao.school.what.repository;

import kakao.school.what.domain.History;
import kakao.school.what.dto.request.HistoryRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

    //
    List<History> findAllByHistoryId(Long historyId);

    // 역사데이터 우선순위에 따라 불러옴
    List<History> findByCountryIdAndPriority(Long countryId, Integer priority, Pageable pageable);

    // year 이후 한국 History를 Page로 불러옴
    Page<History> findAllByCountryIdAndYearGreaterThanEqual(Long countryId, Integer year, Pageable pageable);

    // year 이후 한국과 해당 나라 History를 Page로 불러옴
    Page<History> findAllByCountryIdInAndYearGreaterThanEqual(List<Long> countryIds, Integer year, Pageable pageable);

    // 모든 History를 Page로 불러옴
    Page<History> findAll(Pageable pageable);

    // History Id로 History를 불러옴
    History findByHistoryId(Long HistoryId);
}
