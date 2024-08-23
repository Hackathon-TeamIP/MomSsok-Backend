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

    @Column(name = "username", length = 255)
    private String username;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "email", length = 255)
    private String email;

    // Other fields and methods...

    @OneToMany(mappedBy = "user")
    private Set<Place> places;

}