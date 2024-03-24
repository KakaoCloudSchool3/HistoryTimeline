package kakao.school.what.repository;

import kakao.school.what.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByContent_ContentId(Long contentId); // 'Content' 엔티티 내 'contentId' 필드를 참조
}
