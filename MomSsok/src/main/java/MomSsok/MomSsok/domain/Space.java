package MomSsok.MomSsok.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Entity
@Table(name = "SPACE")
public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spaces_id")
    private Long spaceId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image_url", nullable = false, length = 255)
    private String image_url;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "contact", nullable = false, length = 20)
    private String contact;

    @Column(name = "operationdays", nullable = false, length = 50)
    private String operationDays;

    @Column(name = "subway_station_name", nullable = false, length = 100)
    private String subwayStation;

    @Column(name = "subway_station_exit", nullable = false)
    private Integer subwayExit;

    @Column(name = "subway_station_desc", nullable = false)
    private String subwayDescription;

    @Column(name = "bus_type", length = 50)
    private String type;

    @Column(name = "bus_number", length = 100)
    private String busNumber;

    @Column(name = "directions")
    private String directions;

    @Column(name = "tag", length = 50)
    private String tag;

    @Column(name = "location_Type", nullable = false, length = 20)
    private String locationType;

    @OneToMany(mappedBy = "space", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Accessifon> acInfo; // 접근성 정보

    @OneToMany(mappedBy = "space", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    @Transient
    private BigDecimal averageRating; // 리뷰 평균

}
