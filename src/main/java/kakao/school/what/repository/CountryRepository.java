package kakao.school.what.repository;

import kakao.school.what.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    // 모든 나라 리스트를 이름순으로 가져오기
    List<Country> findAllByOrderByName();
}
