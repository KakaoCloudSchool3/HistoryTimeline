package kakao.school.what.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HistoryMainLineDto {
    private String title;
    private int priority;
    private String brief;
    private int year;
    private String imgUrl;
}
