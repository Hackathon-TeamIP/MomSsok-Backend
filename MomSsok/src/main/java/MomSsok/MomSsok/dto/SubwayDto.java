package MomSsok.MomSsok.dto;

import lombok.*;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubwayDto {
    private String subwayStation;
    private int  subwayExit;
    private String subwayDescription;
}
