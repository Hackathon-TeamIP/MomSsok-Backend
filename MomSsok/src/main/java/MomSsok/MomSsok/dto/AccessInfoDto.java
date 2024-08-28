package MomSsok.MomSsok.dto;

import lombok.*;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccessInfoDto {
    private Long acInfoId;
    private String assessinfo;
    private String assessinfoIcon;
}
