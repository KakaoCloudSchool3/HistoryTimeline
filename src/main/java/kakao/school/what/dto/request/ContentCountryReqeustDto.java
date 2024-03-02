package kakao.school.what.dto.request;

import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@ToString
public class ContentCountryReqeustDto {
    private Long serial;
    private Long contentId;
    private Long countryId;
    private LocalDateTime created_At;
    private LocalDateTime updated_At;

}
