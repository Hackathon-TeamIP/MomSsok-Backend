package MomSsok.MomSsok.service;

import MomSsok.MomSsok.domain.Place;
import MomSsok.MomSsok.dto.ImageDto;
import MomSsok.MomSsok.dto.InfoDto;
import MomSsok.MomSsok.dto.PlaceDto;
import MomSsok.MomSsok.repository.DetailPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final DetailPlaceRepository detailPlaceRepository;

    @Transactional(readOnly = true)
    public PlaceDto getPlaceDetails(Long id) {
        Place place = detailPlaceRepository.findById(id).orElseThrow();

        // 좋아요 수
        Long likeCount = detailPlaceRepository.countLikesByPlaceId(id);

        // 리뷰 수 그리고 리뷰 평점
        List<Object[]> reviewData = detailPlaceRepository.findReviewCountAndAverageRatingByPlaceId(id);
        Long reviewCount = 0L;
        BigDecimal averageRating = BigDecimal.ZERO;
        if (!reviewData.isEmpty()) {
            Object[] data = reviewData.get(0);
            reviewCount = ((Number) data[0]).longValue();
            averageRating = ((Number) data[1]).doubleValue() > 0 ? BigDecimal.valueOf(((Number) data[1]).doubleValue()) : BigDecimal.ZERO;
        }

        ImageDto imageDto = new ImageDto(place.getImage());

        InfoDto infoDto = new InfoDto(
             place.getAddress(),
             place.getPhone(),
             place.getData()
        );
        return new PlaceDto(
                place.getId(),
                place.getName(),
                place.getTag1(),
                place.getTag2(),
                place.getDescription(),
                reviewCount,
                averageRating,
                List.of(imageDto),
                true,
                likeCount,
                List.of(infoDto)
        );

    }
}
