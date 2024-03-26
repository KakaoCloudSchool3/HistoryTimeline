package kakao.school.what.web;

import kakao.school.what.dto.oauth.OAuthInfoResponse;
import kakao.school.what.service.OAuthLoginService;
import kakao.school.what.util.KakaoLoginParams;
import kakao.school.what.util.NaverLoginParams;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.result.view.RedirectView;

import java.util.NavigableSet;

@RestController
@RequestMapping("/app/login")
@RequiredArgsConstructor
public class OauthController {
    private final OAuthLoginService oAuthLoginService;

    @GetMapping("/kakao")
    public ResponseEntity<OAuthInfoResponse> loginKakao(@RequestParam KakaoLoginParams params) {
        System.out.println("Kakao");
        return ResponseEntity.ok(oAuthLoginService.login(params));
    }

    @GetMapping("/naver")
    public ResponseEntity<String> loginNaver(@RequestParam("code") String code,
                                                        @RequestParam("code") String state) {
        NaverLoginParams params = new NaverLoginParams();
        params.setCode(code);
        params.setState(state);
        oAuthLoginService.login(params);

        String externalUrl = "http://localhost:3000/map";

        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", externalUrl)
                .body("Redirecting to external URL: " + externalUrl);
    }
}
