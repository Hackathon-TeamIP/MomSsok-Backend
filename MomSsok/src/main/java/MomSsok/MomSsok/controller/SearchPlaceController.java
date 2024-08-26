package MomSsok.MomSsok.controller;

import MomSsok.MomSsok.domain.Place;
import MomSsok.MomSsok.domain.Review;
import MomSsok.MomSsok.dto.SearchPlaceDto;
import MomSsok.MomSsok.service.SearchPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/places")
public class SearchPlaceController {

    @Autowired
    private SearchPlaceService searchPlaceService;

    @GetMapping("/search")
    public List<Place> searchPlaces(@RequestParam(required = false) String name,
                                    @RequestParam(required = false) String description,
                                    @RequestParam(required = false) String tag1,
                                    @RequestParam(required = false) String tag2) {
        SearchPlaceDto searchDto = new SearchPlaceDto();

        searchDto.setName(name);
        searchDto.setDescription(description);
        searchDto.setTag1(tag1);
        searchDto.setTag2(tag2);
        return searchPlaceService.searchPlaces(searchDto);
    }

    @GetMapping("/high-rating")
    public List<Review> getReviewsOrderedByRating(@RequestParam(required = false) double rating) {
        SearchPlaceDto searchDto = new SearchPlaceDto();
        searchDto.setRating(rating);

        return searchPlaceService.getReviewsOrderedByRating(searchDto);
    }


}
