package MomSsok.MomSsok.repository;

import MomSsok.MomSsok.domain.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SpaceRepository extends JpaRepository<Space, Long> {
    /**
     *  상세 페이지 접근성정보
     */
    @Query("SELECT s FROM Space s " +
            "LEFT JOIN FETCH s.acInfo a " +
            "WHERE s.spaceId = :spaceId")
    Optional<Space> findDetailedSpaceById(@Param("spaceId") Long spaceId);
    /**
     * 상세 페이지 리뷰 수 , 리뷰 평점
     *
     */
    @Query("SELECT s, COUNT(r) AS reviews, COALESCE(AVG(r.rating), 0) AS averageRating " +
            "FROM Space s " +
            "LEFT JOIN s.reviews r " +
            "WHERE s.spaceId = :spaceId " +
            "GROUP BY s")
    Optional<Object[]> findSpaceWithReviewStats(@Param("spaceId") Long spaceId);
}

