package kakao.school.what.repository;

import kakao.school.what.domain.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserLikeRepository extends JpaRepository<UserLike, Long> {

    @Query(value = "SELECT COUNT(*) FROM `like` WHERE content_id = :contentId", nativeQuery = true)
    Long countByContentId(Long contentId);
}