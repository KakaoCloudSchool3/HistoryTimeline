package kakao.school.what.dto.request;

import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@ToString
public class ContentDetailRequestDto {
    private Long serial;
    private Long contentId;
    private int likeNum;
    private int dislikeNum;
    private String info;
    private LocalDateTime created_At;
    private LocalDateTime updated_At;
}
