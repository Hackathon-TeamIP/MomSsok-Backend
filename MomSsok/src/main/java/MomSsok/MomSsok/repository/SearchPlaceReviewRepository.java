package MomSsok.MomSsok.repository;

import MomSsok.MomSsok.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchPlaceReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT r FROM Review r ORDER BY r.rating DESC")
    List<Review> findAllReviewsOrderedByRating(double rating);


}
