package kakao.school.what.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HistoryReportResponseListDto {
    private Long historyReportId;
    private String report;
    private String createdDate;
}
