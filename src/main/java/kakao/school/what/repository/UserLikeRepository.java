package kakao.school.what.repository;

import kakao.school.what.domain.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLikeRepository extends JpaRepository<UserLike, Long> {
    Long countByContentId(Long contentId);
}
