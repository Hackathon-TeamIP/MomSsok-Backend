package MomSsok.MomSsok.service;

import MomSsok.MomSsok.domain.Space;
import MomSsok.MomSsok.dto.SearchPlaceDto;
import MomSsok.MomSsok.repository.SearchPlaceRepository;
import MomSsok.MomSsok.repository.SearchPlaceReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class SearchPlaceServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SearchPlaceService searchPlaceService;

    @Autowired
    private SearchPlaceRepository placeRepository;

    @Autowired
    private SearchPlaceReviewRepository placeReviewRepository;

    @BeforeEach
    public void setup() {
       placeRepository.deleteAll();

         //테스트용 장소 데이터 추가
//        Space place1 = new Space();
//        place1.setName("Coffee Shop3");
//        place1.setDescription("A nice coffee shop");
//        place1.setImage_url("image1.jpg");
//        place1.setTag1("Cafe");
//        place1.setTag2("Drinks");
//        place1.setPhone("01012345678");
//        place1.setData("Some data");
//        place1.setAddress("seoul");
//        placeRepository.save(place1);
//
//        Space place2 = new Space();
//        place2.setName("Book Store3");
//        place2.setDescription("A cozy book store");
//        place2.setImage_url("image2.jpg");
//        place2.setTag1("Books");
//        place2.setTag2("Stationery");
//        place2.setPhone("01098765432");
//        place2.setData("Some data");
//        place2.setAddress("seoul");
//        placeRepository.save(place2);
//
//         리뷰 데이터 추가
//        Review review1 = new Review();
//        review1.setPlace(place1);
////        review1.setId(place1.getId());
//        review1.setRating(4.5);
//        placeReviewRepository.save(review1);
//
//        Review review2 = new Review();
//        review2.setPlace(place2);
////        review2.setId(place1.getId());
//        review2.setRating(5.0);
//        placeReviewRepository.save(review2);
    }

   @Test
    public void testSearchPlaceService() {
        // 검색 DTO 생성
        SearchPlaceDto searchDto = new SearchPlaceDto();
        searchDto.setName("Coffee");
        searchDto.setDescription("A nice coffee shop");
        searchDto.setTag1("Cafe");
        searchDto.setTag2("Drinks"); // 태그 이름 수정

        // 서비스에서 장소 검색
        List<Space> results = searchPlaceService.searchPlaces(searchDto);

        // 검색 결과 검증
        assertThat(results).isNotEmpty();
        assertThat(results.get(0).getName()).isEqualTo("Coffee Shop");
    }

    @Test
    public void testSearchPlaceController() throws Exception {
        // MockMvc를 사용하여 REST API 호출을 통한 검색
        mockMvc.perform(get("/places/search")
                        .param("name", "Book")
                        .param("description", "A cozy book store")
                        .param("tag1", "Books") // tag1로 수정
                        .param("tag2", "Stationery") // tag2 추가
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Book Store"));
    }

    @Test
    public void testSearchPlaceByRating() throws Exception {
        // MockMvc를 사용하여 리뷰 평점 기준으로 장소 검색
        mockMvc.perform(get("/places/high-rating")
                        .param("rating", "4.5") // 평점 기준으로 검색
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Coffee Shop"));
    }



}
