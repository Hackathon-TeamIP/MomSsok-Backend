package MomSsok.MomSsok.repository;

import MomSsok.MomSsok.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    // 사용자 이름으로 사용자 찾기
    Optional<User> findByUsername(String username);

    // 이메일로 사용자 찾기
    Optional<User> findByEmail(String email);

    // 사용자 ID로 사용자 찾기
    Optional<User> findById(Integer id);
}
