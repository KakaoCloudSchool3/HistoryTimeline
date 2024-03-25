package kakao.school.what.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@Entity
@Table(name = "likes") // 실제 데이터베이스에 생성될 테이블 이름을 지정
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class UserLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serial")
    private Long serial;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "content_id")
    private Long contentId;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;
}
