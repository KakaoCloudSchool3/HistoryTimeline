package kakao.school.what.dto.oauth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import kakao.school.what.util.OAuthProvider;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class NaverInfoResponse implements OAuthInfoResponse {

    @JsonProperty("response")
    private Response response;

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Response {
        private String email;
        private String nickname;
        private String gender;
        private String age;
    }

    @Override
    public String getEmail() {
        return response.email;
    }

    @Override
    public String getNickname() {
        return response.nickname;
    }

    @Override
    public String getGender() {return response.gender;}

    @Override
    public String getAge() {return response.age;}

    @Override
    public OAuthProvider getOAuthProvider() {
        return OAuthProvider.NAVER;
    }
}