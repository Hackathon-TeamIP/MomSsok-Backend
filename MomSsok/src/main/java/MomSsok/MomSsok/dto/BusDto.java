package MomSsok.MomSsok.dto;

import lombok.*;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusDto {
    private String type;
    private String busNumber;
    private String directions;
}