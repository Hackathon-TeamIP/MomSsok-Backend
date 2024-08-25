package MomSsok.MomSsok.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceDto {
    private Long id; // 상세페이지 ID
    private String name; // 장소 이름
    private String tags1; // 태그1
    private String tags2;// 태그 2
    private String description; // 각 장소 설명 
    private Long reviewCount; // 리뷰 수
    private BigDecimal rating; // 리뷰 평균 
    private List<ImageDto> images; // 이미지
    private Boolean isLiked; // 찜 yes , no
    private Long likeCount; // 찜 개수
    private List<InfoDto> info; // 장소에 대한 주소 , 전화번호 , 운영일자


}
