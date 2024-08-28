package MomSsok.MomSsok.domain;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Entity
@Table(name = "accessinfo")
public class Accessifon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acinfo_id")
    private Long acInfoId;

    @ManyToOne
    @JoinColumn(name = "spaces_id", nullable = false)
    private Space space;

    @Column(name = "assessinfo", nullable = false)
    private String assessinfo;

    @Column(name = "assessinfo_icon", nullable = false)
    private String assessinfoIcon;
}
