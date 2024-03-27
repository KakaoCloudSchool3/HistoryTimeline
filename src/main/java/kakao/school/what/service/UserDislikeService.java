package kakao.school.what.service;

import kakao.school.what.domain.UserDislike;
import kakao.school.what.repository.UserDislikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDislikeService {

    private final UserDislikeRepository userDislikeRepository;

    @Autowired
    public UserDislikeService(UserDislikeRepository userDislikeRepository) {
        this.userDislikeRepository = userDislikeRepository;
    }

    public UserDislike saveUserDislike(Long userId, Long contentId) {
        UserDislike userDislike = new UserDislike();
        userDislike.setUserId(userId);
        userDislike.setContentId(contentId);
        return userDislikeRepository.save(userDislike);
    }

    public Long countByContentId(Long contentId) {
        return userDislikeRepository.countByContentId(contentId);
    }
}
