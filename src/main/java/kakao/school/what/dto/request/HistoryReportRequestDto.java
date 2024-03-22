package kakao.school.what.dto.request;

import lombok.Data;

@Data
public class HistoryReportRequestDto {
    private Long userId;
    private String report;
}
