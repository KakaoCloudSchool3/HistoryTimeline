package kakao.school.what.service;

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

    public Long getContentLikesCount(Long contentId) {
        return userLikeRepository.countByContentId(contentId);
    }
}
