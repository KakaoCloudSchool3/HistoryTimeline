package kakao.school.what.repository;

import kakao.school.what.domain.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserLikeRepository extends JpaRepository<UserLike, Long> {

    // contentId를 기반으로 좋아요 개수를 조회하는 쿼리
    @Query("SELECT COUNT(u) FROM UserLike u WHERE u.contentId = :contentId")
    Long countByContentId(Long contentId);
}
