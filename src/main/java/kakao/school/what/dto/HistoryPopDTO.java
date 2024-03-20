package kakao.school.what.dto;

import lombok.Getter;
import lombok.ToString;

@Getter

@ToString
public class HistoryPopDTO {
    private String title;
    private Integer year;
    private Integer month;
    private Integer day;
    private String imgUrl;
    private String brief;
   



    public HistoryPopDTO(String title, Integer year, Integer month, Integer day, String brief, String imgUrl) {
        this.title = title;
        this.year = year;
        this.month = month;
        this.day = day;
        this.brief = brief;
        this.imgUrl=imgUrl;



    }
}
