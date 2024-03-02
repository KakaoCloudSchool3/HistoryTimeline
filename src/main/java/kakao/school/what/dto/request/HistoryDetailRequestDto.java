package kakao.school.what.dto.request;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class HistoryDetailRequestDto {
    private Long historyDetailId;
    private Long historyId;
    private String detail;
}
