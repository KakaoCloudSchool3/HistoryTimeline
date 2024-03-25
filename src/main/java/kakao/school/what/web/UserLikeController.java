package kakao.school.what.web;

import kakao.school.what.service.UserLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLikeController {

    private final UserLikeService userLikeService;

    @Autowired
    public UserLikeController(UserLikeService userLikeService) {
        this.userLikeService = userLikeService;
    }

    // UserLikeController 클래스에 추가할 엔드포인트 메서드
    @GetMapping("/likes/count-by-title")
    public Long getContentLikesCountByTitle(@RequestParam String title) {
        return userLikeService.getContentLikesCountByTitle(title);
    }
}
