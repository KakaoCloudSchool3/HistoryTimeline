package kakao.school.what.repository;

import kakao.school.what.domain.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContentRepository extends JpaRepository<Content, Long> {
    // JpaRepository에서 제공하는 findById 메서드를 사용합니다.
    Optional<Content> findByTitle(String title);

}
