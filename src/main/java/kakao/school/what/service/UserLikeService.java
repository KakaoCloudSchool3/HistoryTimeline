package kakao.school.what.service;

import kakao.school.what.domain.UserLike;
import kakao.school.what.repository.UserLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLikeService {

    private final UserLikeRepository userLikeRepository;

    @Autowired
    public UserLikeService(UserLikeRepository userLikeRepository) {
        this.userLikeRepository = userLikeRepository;
    }

    public UserLike saveUserLike(Long userId, Long contentId) {
        UserLike userLike = new UserLike();
        userLike.setUserId(userId);
        userLike.setContentId(contentId);
        return userLikeRepository.save(userLike);
    }

    public Long countLikesByContentId(Long contentId) {
        return userLikeRepository.countByContentId(contentId);
    }
}
