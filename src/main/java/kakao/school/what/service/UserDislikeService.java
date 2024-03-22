package kakao.school.what.service;

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

    public Long getContentDislikesCount(Long contentId) {
        return userDislikeRepository.countByContentId(contentId);
    }
}
