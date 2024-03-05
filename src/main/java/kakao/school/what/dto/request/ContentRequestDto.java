package kakao.school.what.dto.request;

import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@ToString
public class ContentRequestDto {
    private String title;
    private int contentType;
    private String imgUrl;
    private ContentDetailRequestDto contentDetailRequestDto;
    private ContentPlatformRequestDto contentPlatformRequestDto;
    private ContentTagRequestDto contentTagRequestDto;
}
