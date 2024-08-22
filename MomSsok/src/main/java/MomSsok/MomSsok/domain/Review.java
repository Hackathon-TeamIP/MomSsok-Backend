package MomSsok.MomSsok.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Review")
public class Review {

    @Id
    private int id; // 리뷰 ID (Primary Key)
    private int placeId; // 장소 ID (Foreign Key)
    private int userId; // 작성자 ID (Foreign Key)
    private BigDecimal rating; // 리뷰 평점 (1.0에서 5.0 사이)
    private LocalDateTime createdAt; // 리뷰 작성 일시
    private LocalDateTime updatedAt; // 리뷰 수정 일시 (리뷰가 수정된 경우)

    // 기본 생성자
    public Review() {
    }

    // 파라미터가 있는 생성자
    public Review(int id, int placeId, int userId, BigDecimal rating, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.placeId = placeId;
        this.userId = userId;
        this.rating = rating;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}