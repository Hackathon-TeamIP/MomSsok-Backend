package MomSsok.MomSsok.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class SpaceDto {
    private Long spaceId; // 고유 아이디
    private String name; // 상세페이지 이름
    private String description; // 그 장소에 대한 설명
    private List<ImageDto> images; // 이미지
    private List<InfoDto> basicInfo; // 주소, 번호 , 운영일자
    private String tag; //  각 태그
    private List<SubwayDto> subway; // 지하철
    private List<BusDto> bus; //    버스
    private List<AccessInfoDto> accessInfo; // 접근 정보
    private String locationType; //실내 실외?ㄴ
    private int reviews; // 리뷰 수
    private BigDecimal averageRating; // 리뷰 평균


}
