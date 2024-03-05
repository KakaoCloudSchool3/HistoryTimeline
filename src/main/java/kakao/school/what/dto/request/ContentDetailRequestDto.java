package kakao.school.what.dto.request;

import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@ToString
public class ContentDetailRequestDto {
    private Long contentId;
    private int likeNum;
    private int dislikeNum;
    private String info;
}
