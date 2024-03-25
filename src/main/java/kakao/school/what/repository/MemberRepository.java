package kakao.school.what.repository;

import kakao.school.what.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(@Param("email") String email);
}
