package MomSsok.MomSsok.domain;

import MomSsok.MomSsok.repository.DetailPlaceRepository;
import org.aspectj.lang.annotation.After;
import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DetailPlaceTepository {

    @Autowired
    private DetailPlaceRepository detailPlaceRepository;



    @Test
    public void 게시글불러오기(){
        //given
        String name = "이름";
        String description = "네용";
        String image = "이미지";
        int phone = 123;

        detailPlaceRepository.save(Place.builder()
                .name(name)
                .description(description)
                .image(image)
                .phone(phone)
                .build());

        //when
        List<Place> placeList = detailPlaceRepository.findAll();
        //then
        Place place = placeList.get(0);
        assertThat(place.getName()).isEqualTo(name);
        assertThat(place.getDescription()).isEqualTo(description);
        assertThat(place.getImage()).isEqualTo(image);
        assertThat(place.getPhone()).isEqualTo(phone);


    }



}
