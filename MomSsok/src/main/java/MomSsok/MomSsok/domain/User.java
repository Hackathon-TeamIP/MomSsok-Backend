package MomSsok.MomSsok.domain;

import jakarta.persistence.Table;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "User")
public class User {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Other fields and methods...

    @OneToMany(mappedBy = "user")
    private Set<Place> places;

}