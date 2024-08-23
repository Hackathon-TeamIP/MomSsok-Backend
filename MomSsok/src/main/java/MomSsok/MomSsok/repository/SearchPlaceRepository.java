package MomSsok.MomSsok.repository;

import MomSsok.MomSsok.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchPlaceRepository extends JpaRepository<Place, Integer> {

    // name으로 Place 검색
    List<Place> findByName(String name);

    // user_id로 Place 검색
    List<Place> findByUserId(int userId);
}