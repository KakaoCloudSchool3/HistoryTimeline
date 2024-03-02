package kakao.school.what.dto.request;

import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@ToString
public class ContentPlatformRequestDto {
    private Long serial;
    private Long contentId;
    private Long platformId;
    private LocalDateTime created_At;
    private LocalDateTime updated_At;
}
