package MomSsok.MomSsok.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@Entity
@Table(name = "Place")
public class Place {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // INT 타입의 기본 키

    @Column(name = "name", nullable = false)
    private String name; // VARCHAR(100) 타입

    @Column(name = "description", nullable = false)
    private String description; // TEXT 타입

    @Column(name = "image", nullable = false)
    private String image; // VARCHAR(255) 타입

    @Column(name = "tag1")
    private String tag1; // VARCHAR(50) 타입

    @Column(name = "tag2")
    private String tag2; // VARCHAR(50) 타입

    @Column(name = "phone", nullable = false)
    private String phone; // VARCHAR(15) 타입

    @Column(name = "data", nullable = false)
    private String data; // VARCHAR(100) 타입

}
