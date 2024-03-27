package kakao.school.what.web;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kakao.school.what.dto.oauth.OAuthInfoResponse;
import kakao.school.what.service.OAuthLoginService;
import kakao.school.what.util.KakaoLoginParams;
import kakao.school.what.util.NaverLoginParams;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.result.view.RedirectView;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
                                             @RequestParam("code") String state,
                                             HttpServletRequest request, HttpServletResponse response) {
        NaverLoginParams params = new NaverLoginParams();
        params.setCode(code);
        params.setState(state);

        OAuthInfoResponse res = oAuthLoginService.login(params);

        // 이전 페이지의 URL을 가져오기
        String previousUrl = null;
        try {
            previousUrl = getPreviousUrlFromCookie(request);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        // 이전 페이지가 있으면 해당 페이지로 리다이렉트, 없으면 기본 페이지로 리다이렉트
        String redirectUrl = (previousUrl != null && !previousUrl.isEmpty()) ? previousUrl : "http://localhost:3000/map";

        Cookie cookie = new Cookie("email", res.getEmail());
        cookie.setMaxAge(60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);

        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", redirectUrl)
                .body("Redirecting to external URL: " + redirectUrl);
    }

    // 쿠키에서 이전 페이지의 URL을 가져오는 메소드
    private String getPreviousUrlFromCookie(HttpServletRequest request) throws UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("previousUrl")) {
                    return URLDecoder.decode(cookie.getValue(), "UTF-8");
                }
            }
        }
        return null;
    }
}
