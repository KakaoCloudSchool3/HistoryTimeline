package kakao.school.what.web;

import kakao.school.what.service.UserLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLikeController {

    private final UserLikeService userLikeService;

    @Autowired
    public UserLikeController(UserLikeService userLikeService) {
        this.userLikeService = userLikeService;
    }

    // 특정 contentId에 대한 좋아요 개수를 조회하는 엔드포인트
    @GetMapping("/likes/count/{contentId}")
    public Long getContentLikesCount(@PathVariable Long contentId) {
        return userLikeService.getContentLikesCount(contentId);
    }
}
