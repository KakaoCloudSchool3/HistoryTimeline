package kakao.school.what.dto.request;

import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@ToString
public class ContentTagRequestDto {
    private Long serial;
    private Long tagId;
    private Long contentId;
    private LocalDateTime created_At;
}
