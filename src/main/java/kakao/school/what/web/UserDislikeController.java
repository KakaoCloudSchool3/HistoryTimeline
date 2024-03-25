package kakao.school.what.web;

import kakao.school.what.service.UserDislikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDislikeController {

    private final UserDislikeService userDislikeService;

    @Autowired
    public UserDislikeController(UserDislikeService userDislikeService) {
        this.userDislikeService = userDislikeService;
    }

    @GetMapping("/dislikes/count-by-title")
    public Long getContentDislikesCountByTitle(@RequestParam String title) {
        return userDislikeService.getContentDislikesCountByTitle(title);
    }
}
