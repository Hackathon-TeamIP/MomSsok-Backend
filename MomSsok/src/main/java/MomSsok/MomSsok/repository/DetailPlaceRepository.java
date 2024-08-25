package MomSsok.MomSsok.repository;

import MomSsok.MomSsok.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetailPlaceRepository extends JpaRepository<Place , Long> {
    /**
     * 해당 상세페이지 찜 수 불러오기
     * @param placeId
     * @return
     */
    @Query("SELECT COUNT(l) FROM Likes l WHERE l.place.id = :placeId")
    Long countLikesByPlaceId(@Param("placeId") Long placeId);

    /**
     * 해당 상세페이지 리뷰의 수와 리뷰 평균을 불러오기
     * @param placeId
     * @return
     */
    @Query("SELECT COUNT(r), ROUND(AVG(r.rating), 1) " +
            "FROM Review r " +
            "WHERE r.place.id = :placeId")
    List<Object[]> findReviewCountAndAverageRatingByPlaceId(@Param("placeId") Long placeId);
}

