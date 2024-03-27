package kakao.school.what.repository;

import kakao.school.what.domain.UserDislike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDislikeRepository extends JpaRepository<UserDislike, Long> {
    Long countByContentId(Long contentId);
}