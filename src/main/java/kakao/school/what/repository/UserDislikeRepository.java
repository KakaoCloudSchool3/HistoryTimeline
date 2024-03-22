package kakao.school.what.repository;

import kakao.school.what.domain.UserDislike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDislikeRepository extends JpaRepository<UserDislike, Long> {

    @Query(value = "SELECT COUNT(*) FROM dislike WHERE content_id = :contentId", nativeQuery = true)
    Long countByContentId(Long contentId);
}
