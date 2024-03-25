package kakao.school.what.domain;

import jakarta.persistence.*;
import kakao.school.what.util.OAuthProvider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "age_type")
    private Integer ageType;

    private String email;

//    private OAuthProvider oAuthProvider;
    public User(String name) {
        this.email = email;
        this.name = name;

    }

    public User(String email, String nickname, OAuthProvider oAuthProvider) {
        this.email = email;
        this.name = name;
        this.oAuthProvider = oAuthProvider;
    }
}
