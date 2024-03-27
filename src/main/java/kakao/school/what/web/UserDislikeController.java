package kakao.school.what.web;

import kakao.school.what.domain.UserDislike;
import kakao.school.what.service.UserDislikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDislikeController {

    private final UserDislikeService userDislikeService;

    @Autowired
    public UserDislikeController(UserDislikeService userDislikeService) {
        this.userDislikeService = userDislikeService;
    }

    @PostMapping("/dislikes")
    public UserDislike saveUserDislike(@RequestParam Long userId, @RequestParam Long contentId) {
        return userDislikeService.saveUserDislike(userId, contentId);
    }
    @GetMapping("/dislikes/count")
    public ResponseEntity<Long> getDislikeCount(@RequestParam Long contentId) {
        Long count = userDislikeService.countByContentId(contentId);
        return ResponseEntity.ok(count);
    }
}
