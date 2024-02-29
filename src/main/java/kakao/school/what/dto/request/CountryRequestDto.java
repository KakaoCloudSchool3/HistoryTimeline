package kakao.school.what.dto.request;

import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@ToString
public class CountryRequestDto {
    private Long countryId;
    private String name;
    private LocalDateTime created_At;
    private LocalDateTime updated_At;
}
