package kakao.school.what.web;

import kakao.school.what.domain.UserLike;
import kakao.school.what.service.UserLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLikeController {

    private final UserLikeService userLikeService;

    @Autowired
    public UserLikeController(UserLikeService userLikeService) {
        this.userLikeService = userLikeService;
    }

    @PostMapping("/likes")
    public UserLike saveUserLike(@RequestParam Long userId, @RequestParam Long contentId) {
        return userLikeService.saveUserLike(userId, contentId);
    }

    @GetMapping("/likes/count")
    public ResponseEntity<Long> getLikesCount(@RequestParam Long contentId) {
        Long count = userLikeService.countLikesByContentId(contentId);
        return ResponseEntity.ok(count);
    }
}
