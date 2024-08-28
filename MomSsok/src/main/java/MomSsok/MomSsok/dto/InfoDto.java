package MomSsok.MomSsok.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class InfoDto {
    private String address;
    private String contact;
    private String operationDays;

}