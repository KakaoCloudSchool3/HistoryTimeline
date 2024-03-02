package kakao.school.what.dto.request;

import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@ToString
public class ContentRequestDto {
    private Long contentId;
    private String title;
    private int contentType;
    private String imgUrl;
    private LocalDateTime created_At;
    private LocalDateTime updated_At;
    private ContentDetailRequestDto contentDetailRequestDto;
    private ContentCountryReqeustDto contentCountryReqeustDto;
    private ContentPlatformRequestDto contentPlatformRequestDto;
    private ContentTagRequestDto contentTagRequestDto;
}
