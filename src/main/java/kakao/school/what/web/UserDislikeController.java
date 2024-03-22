package kakao.school.what.web;

import kakao.school.what.service.UserDislikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDislikeController {

    private final UserDislikeService userDislikeService;

    @Autowired
    public UserDislikeController(UserDislikeService userDislikeService) {
        this.userDislikeService = userDislikeService;
    }

    // 특정 contentId에 대한 비추천 개수를 조회하는 엔드포인트
    @GetMapping("/dislikes/count/{contentId}")
    public Long getContentDislikesCount(@PathVariable Long contentId) {
        return userDislikeService.getContentDislikesCount(contentId);
    }
}
