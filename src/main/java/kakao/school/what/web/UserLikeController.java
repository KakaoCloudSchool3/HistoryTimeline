package kakao.school.what.web;

import kakao.school.what.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLikeController { // 클래스 이름 변경

    private final UserLikeService userLikeService; // 필드 타입 변경

    @Autowired
    public UserLikeController(UserLikeService userLikeService) { // 생성자 파라미터 타입 변경
        this.userLikeService = userLikeService;
    }

    @GetMapping("/userlikes/count")
    public Long countUserLikesByContentId(@RequestParam(value = "contentId") Long contentId) { // 메서드 이름 변경
        return userLikeService.countLikesByContentId(contentId);
    }
}
