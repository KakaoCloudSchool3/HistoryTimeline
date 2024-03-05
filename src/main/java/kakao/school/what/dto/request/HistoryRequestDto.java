package kakao.school.what.dto.request;

import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@ToString
public class HistoryRequestDto {
    private String title;
    private int priority;
    private int countryId;
    private String brief;
    private int year;
    private int month;
    private int day;
    private String imgUrl;

    private HistoryDetailRequestDto historyDetailRequestDto;
}
