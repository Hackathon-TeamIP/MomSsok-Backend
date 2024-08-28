package MomSsok.MomSsok.service;

import MomSsok.MomSsok.domain.Space;
import MomSsok.MomSsok.domain.Review;
import MomSsok.MomSsok.dto.SearchPlaceDto;
import MomSsok.MomSsok.repository.SearchPlaceRepository;
import MomSsok.MomSsok.repository.SearchPlaceReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchPlaceService {

    @Autowired
    private SearchPlaceRepository placeRepository;

    @Autowired
    private SearchPlaceReviewRepository placeReviewRepository;



    public List<Space> searchPlaces(SearchPlaceDto searchDto) {
        String name = searchDto.getName();
        String description = searchDto.getDescription();
        String tag1 = searchDto.getTag1();
        String tag2 = searchDto.getTag2();

        return placeRepository.searchPlaces(name, description, tag1, tag2);

    }

    public List<Review> getReviewsOrderedByRating(SearchPlaceDto searchDto) {

        double rating = searchDto.getRating();

        return placeReviewRepository.findAllReviewsOrderedByRating(rating);
    }


}
