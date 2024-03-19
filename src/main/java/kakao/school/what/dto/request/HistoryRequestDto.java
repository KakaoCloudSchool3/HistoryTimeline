package kakao.school.what.dto.request;

import lombok.Data;

@Data
public class HistoryRequestDto {
    private String title;
    private int priority;
    private Long countryId;
    private String brief;
    private int year;
    private int month;
    private int day;
    private String imgUrl;

    private HistoryDetailRequestDto historyDetailRequestDto;
}
