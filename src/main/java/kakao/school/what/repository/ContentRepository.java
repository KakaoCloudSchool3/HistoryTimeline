package kakao.school.what.repository;

import kakao.school.what.domain.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ContentRepository extends JpaRepository<Content, Long> {
    // contentId와 title을 기반으로 Content 객체를 찾는 메서드를 정의
    Optional<Content> findByContentIdAndTitle(Long contentId, String title);
}
