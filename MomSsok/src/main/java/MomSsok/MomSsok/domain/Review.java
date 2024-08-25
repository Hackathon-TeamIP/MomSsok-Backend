package MomSsok.MomSsok.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // INT 타입의 기본 키

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    private Place place; // Place 테이블의 외래 키

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // User 테이블의 외래 키

    @Column(name = "rating", nullable = false)
    private Double rating = 0.0; // DECIMAL(2,1) 타입, 기본값 0.0
}