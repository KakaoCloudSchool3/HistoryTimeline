package kakao.school.what.service;

import kakao.school.what.repository.UserLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kakao.school.what.repository.ContentRepository;

@Service
public class UserLikeService {

    private final UserLikeRepository userLikeRepository;

    @Autowired
    public UserLikeService(UserLikeRepository userLikeRepository) {
        this.userLikeRepository = userLikeRepository;
    }

    @Autowired
    private ContentRepository contentRepository;

    public Long getContentLikesCountByTitle(String title) {
        return contentRepository.findByTitle(title)
                .map(content -> userLikeRepository.countByContentId(content.getContentId()))
                .orElse(0L); // 제목에 해당하는 컨텐츠가 없으면 좋아요 개수를 0으로 반환
    }


}
