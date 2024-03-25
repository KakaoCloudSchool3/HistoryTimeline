package kakao.school.what.repository;

import kakao.school.what.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 이메일로 User 찾아서 반환
    User findByEmail(String Email);
}
