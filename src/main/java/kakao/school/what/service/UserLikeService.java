package kakao.school.what.service;

import kakao.school.what.domain.UserLike;
import kakao.school.what.repository.UserLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kakao.school.what.repository.ContentRepository;

import java.time.LocalDateTime;

@Service
public class UserLikeService {

    private final UserLikeRepository userLikeRepository;
    private final ContentRepository contentRepository;


    @Autowired
    public UserLikeService(UserLikeRepository userLikeRepository, ContentRepository contentRepository) {
        this.userLikeRepository = userLikeRepository;
        this.contentRepository = contentRepository;
    }


    public Long getContentLikesCountByTitle(String title) {
        return contentRepository.findByTitle(title)
                .map(content -> userLikeRepository.countByContentId(content.getContentId()))
                .orElse(0L); // 제목에 해당하는 컨텐츠가 없으면 좋아요 개수를 0으로 반환
    }

    public void addLikeByTitleAndUserId(String title, Long userId) {
        contentRepository.findByTitle(title).ifPresent(content -> {
            UserLike userLike = new UserLike();
            userLike.setContentId(content.getContentId());
            userLike.setUserId(userId);
            userLike.setCreatedAt(LocalDateTime.now());
            userLikeRepository.save(userLike);
        });
    }
}
