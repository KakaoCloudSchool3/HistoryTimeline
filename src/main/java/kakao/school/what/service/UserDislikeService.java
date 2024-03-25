package kakao.school.what.service;

import kakao.school.what.domain.Content;
import kakao.school.what.domain.UserDislike;
import kakao.school.what.repository.UserDislikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kakao.school.what.repository.ContentRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserDislikeService {

    private final UserDislikeRepository userDislikeRepository;
    private final ContentRepository contentRepository; // ContentRepository 의존성 주입

    @Autowired
    public UserDislikeService(UserDislikeRepository userDislikeRepository, ContentRepository contentRepository) {
        this.userDislikeRepository = userDislikeRepository;
        this.contentRepository = contentRepository; // 생성자를 통해 주입
    }

    public Long getContentDislikesCountByTitle(String title) {
        return contentRepository.findByTitle(title)
                .map(content -> userDislikeRepository.countByContentId(content.getContentId()))
                .orElse(0L); // 제목에 해당하는 컨텐츠가 없으면 안좋아요 개수를 0으로 반환
    }

    public void addDislikeByTitleAndUserId(String title, Long userId) {
        Optional<Content> contentOptional = contentRepository.findByTitle(title);
        contentOptional.ifPresent(content -> {
            UserDislike userDislike = new UserDislike();
            userDislike.setContentId(content.getContentId());
            userDislike.setUserId(userId);
            userDislike.setCreatedAt(LocalDateTime.now());
            userDislikeRepository.save(userDislike);
        });
    }
}
