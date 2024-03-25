package kakao.school.what.service;

import kakao.school.what.domain.User;
import kakao.school.what.dto.oauth.OAuthInfoResponse;
import kakao.school.what.repository.MemberRepository;
import kakao.school.what.util.OAuthLoginParams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuthLoginService {
    private final MemberRepository memberRepository;
//    private final AuthTokensGenerator authTokensGenerator;
    private final RequestOAuthInfoService requestOAuthInfoService;

    public OAuthInfoResponse login(OAuthLoginParams params) {
        OAuthInfoResponse oAuthInfoResponse = requestOAuthInfoService.request(params);
        System.out.println("oAuthInfoResponse = " + oAuthInfoResponse.getEmail());
        Long UserId = findOrCreateUser(oAuthInfoResponse);
        return oAuthInfoResponse;
    }

    private Long findOrCreateUser(OAuthInfoResponse oAuthInfoResponse) {
        return memberRepository.findByEmail(oAuthInfoResponse.getEmail())
                .map(User::getUserId)
                .orElseGet(() -> createUser(oAuthInfoResponse));
    }

    private Long createUser(OAuthInfoResponse oAuthInfoResponse) {
        User User = new User(oAuthInfoResponse.getEmail(),
                oAuthInfoResponse.getNickname(),
                oAuthInfoResponse.getOAuthProvider());
        return memberRepository.save(User).getUserId();
    }
}