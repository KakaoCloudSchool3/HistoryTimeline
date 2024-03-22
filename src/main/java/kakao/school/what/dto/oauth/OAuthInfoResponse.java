package kakao.school.what.dto.oauth;

import kakao.school.what.util.OAuthProvider;

public interface OAuthInfoResponse {
    String getEmail();
    String getNickname();
    OAuthProvider getOAuthProvider();
}