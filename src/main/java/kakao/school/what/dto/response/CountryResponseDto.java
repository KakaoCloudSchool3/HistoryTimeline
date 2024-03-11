package kakao.school.what.dto.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CountryResponseDto {
    private Long countryId;
    private String name;
}
