package kakao.school.what.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
// Timeline 페이지에 보여줄 History Dto
// 모든 항목을 입력받아서 생성되도록 함.
public class HistoryResponseTimelineDto {
    private Long historyId;
    private String title;
    private Integer priority;
    private Long countryId;
    private String brief;
    private Integer year;
    private Integer month;
    private Integer day;
    private String imgUrl;
}
