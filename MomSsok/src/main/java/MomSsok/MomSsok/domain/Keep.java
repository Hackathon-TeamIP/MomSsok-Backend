package MomSsok.MomSsok.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "keep")
public class Keep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keep_id")
    private Long keep_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "space_id", nullable = false)
    private Space space;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "is_keep", nullable = false)
    private Boolean keep;
}
