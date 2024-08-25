package MomSsok.MomSsok.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comments;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "place")
@SequenceGenerator(name="place_SEQ_GEN" , sequenceName = "place_SEQ" , allocationSize = 1)
public class Place {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "place_SEQ_GEN")
    private Long id; // INT 타입의 기본 키

    @Column(name = "name", nullable = false)
    private String name; // VARCHAR(100) 타입

    @Column(name = "description", nullable = false)
    private String description; // TEXT 타입

    @Column(name = "image_url", nullable = false)
    private String image_url; // VARCHAR(255) 타입

    @Column(name = "tag1")
    private String tag1; // VARCHAR(50) 타입

    @Column(name = "tag2")
    private String tag2; // VARCHAR(50) 타입

    @Column(name="address" , nullable = false)
    private String address;

    @Column(name = "phone", nullable = false)
    private int phone; // VARCHAR(15) 타입

    @Column(name = "data", nullable = false)
    private String data; // VARCHAR(100) 타입

    @Column(name = "address", nullable = false)
    private String address; // VARCHAR(100) 타입

    @OneToMany(mappedBy = "place")
    private List<Likes> likes;

    @OneToMany(mappedBy = "place")
    private List<Review> reviews;

    @Transient
    private long likeCount;

    @Transient
    private BigDecimal averageRating;

}
