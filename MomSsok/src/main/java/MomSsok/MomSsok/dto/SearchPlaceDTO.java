package MomSsok.MomSsok.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchPlaceDTO {

    private String name;        // 장소 이름으로 검색
    private String description; // 설명으로 검색
    private String url;        // URL로 검색
    private Integer userId;    // 사용자 ID로 검색

    // 필요에 따라 생성자, getter, setter 등을 추가할 수 있습니다.
}
