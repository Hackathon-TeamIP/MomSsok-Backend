package MomSsok.MomSsok;

import MomSsok.MomSsok.domain.Place;
import MomSsok.MomSsok.domain.User;
import MomSsok.MomSsok.repository.SearchPlaceRepository;
import MomSsok.MomSsok.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@Transactional // 테스트 후 데이터베이스 롤백
public class MomSsokApplicationTests {

	@Autowired
	private SearchPlaceRepository searchPlaceRepository;

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
		System.out.println("Application context loaded successfully.");
	}

	@Test
	void testSaveAndFindPlace() {
		User user = new User();
		user.setUsername("testUser3");
		user.setEmail("testuser3@example.com"); // 이메일 설정 추가
		user.setPassword("dd3");
		userRepository.save(user);

		Place place = new Place();
		place.setUser(user);
		place.setName("Test Place2");
		place.setDescription("This is a test place");
		place.setUrl("http://testplace.com");
		searchPlaceRepository.save(place);

		// When
		List<Place> foundPlaces = searchPlaceRepository.findByName("Test Place");

		// Then
		assertThat(foundPlaces).hasSize(1);
		assertThat(foundPlaces.get(0).getName()).isEqualTo("Test Place");
		assertThat(foundPlaces.get(0).getDescription()).isEqualTo("This is a test place");
		assertThat(foundPlaces.get(0).getUser().getUsername()).isEqualTo("testUser");
	}

	@Test
	void testFindByUserId() {
		// Given
		User user = new User();
		user.setUsername("user4");
		user.setEmail("user4@example.com"); // 이메일 설정 추가
		user.setPassword("dd4");
		userRepository.save(user);

		Place place1 = new Place();
		place1.setUser(user);
		place1.setName("Place 4");
		searchPlaceRepository.save(place1);

		Place place2 = new Place();
		place2.setUser(user);
		place2.setName("Place 5");
		searchPlaceRepository.save(place2);

		// When
		List<Place> foundPlaces = searchPlaceRepository.findByUserId(user.getId());

	}
}


