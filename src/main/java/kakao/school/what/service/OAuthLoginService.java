package kakao.school.what.service;

import kakao.school.what.dto.oauth.OAuthInfoResponse;

import kakao.school.what.domain.User;
import kakao.school.what.dto.oauth.OAuthInfoResponse;
import kakao.school.what.repository.UserRepository;
import kakao.school.what.util.OAuthLoginParams;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuthLoginService {
//    private final AuthTokensGenerator authTokensGenerator;
    private final RequestOAuthInfoService requestOAuthInfoService;
    @Autowired
    private UserRepository userRepository;

    // 로그인
    // 없을 경우
    public OAuthInfoResponse login(OAuthLoginParams params) {
        OAuthInfoResponse oAuthInfoResponse = requestOAuthInfoService.request(params);
        System.out.println("oAuthInfoResponse = " + oAuthInfoResponse.getEmail());
//        Long memberId = findOrCreateMember(oAuthInfoResponse);
        Long userId = findOrCreateUser(oAuthInfoResponse);
        return oAuthInfoResponse;
    }

    private Long findOrCreateUser(OAuthInfoResponse oAuthInfoResponse) {
        User user = userRepository.findByEmail(oAuthInfoResponse.getEmail());
        if (user == null) {
            User newUser = new User();
            newUser.setName(oAuthInfoResponse.getNickname());
            newUser.setSex(oAuthInfoResponse.getGender().equals("M") ? 1 : 0);
            newUser.setEmail(oAuthInfoResponse.getEmail());
            newUser.setAgeType(Character.getNumericValue(oAuthInfoResponse.getAge().charAt(0)));

            User savedUser = userRepository.save(newUser);
            return savedUser.getUserId();
        }
        else {
            return user.getUserId();
        }
    }

//    private Long findOrCreateMember(OAuthInfoResponse oAuthInfoResponse) {
//        return memberRepository.findByEmail(oAuthInfoResponse.getEmail())
//                .map(Member::getId)
//                .orElseGet(() -> newMember(oAuthInfoResponse));
//    }
//
//    private Long newMember(OAuthInfoResponse oAuthInfoResponse) {
//        Member member = Member.builder()
//                .email(oAuthInfoResponse.getEmail())
//                .nickname(oAuthInfoResponse.getNickname())
//                .oAuthProvider(oAuthInfoResponse.getOAuthProvider())
//                .build();
//
//        return memberRepository.save(member).getId();
//    }
}