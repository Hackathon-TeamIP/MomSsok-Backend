package MomSsok.MomSsok.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchPlaceDto {

    private String name;
    private String description;
    private Double rating;
    private String image_url;
    private Boolean isLiked;
    private String tag1;
    private String tag2;
    private String address;
}

