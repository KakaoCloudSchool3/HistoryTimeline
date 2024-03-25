package kakao.school.what.web;

import kakao.school.what.service.UserDislikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/dislikes/add")
    public ResponseEntity<?> addDislikeByTitle(@RequestParam String title, @RequestParam Long userId) {
        userDislikeService.addDislikeByTitleAndUserId(title, userId);
        return ResponseEntity.ok().build();
    }
}
