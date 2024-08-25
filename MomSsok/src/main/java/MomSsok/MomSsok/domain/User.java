package MomSsok.MomSsok.domain;

import jakarta.persistence.Table;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    private String userId; // VARCHAR(50) 타입

    @Column(name = "password", nullable = false)
    private String password; // VARCHAR(255) 타입

    @Column(name = "email", unique = true, nullable = false)
    private String email; // VARCHAR(100) 타입

}