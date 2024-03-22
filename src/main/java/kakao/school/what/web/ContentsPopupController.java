package kakao.school.what.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Contents 관련 도메인 클래스와 서비스 클래스를 import
import kakao.school.what.domain.Content;
import kakao.school.what.service.ContentService;

@RestController
public class ContentsPopupController {

    @Autowired
    private ContentService contentService; // ContentService를 주입

    // /ContentsPopup 경로로 GET 요청을 받습니다. contentId만 입력으로 받기
    @GetMapping("/ContentsPopup")
    public Content getContentById(@RequestParam(value = "contentId") Long contentId) {
        // contentId에 해당하는 Content 객체를 반환하기
        return contentService.getContentById(contentId);
    }
}
