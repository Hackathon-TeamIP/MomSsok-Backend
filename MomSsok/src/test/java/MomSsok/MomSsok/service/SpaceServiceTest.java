package MomSsok.MomSsok.service;

import MomSsok.MomSsok.dto.SpaceDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 실제 DB를 사용하려는 경우

public class SpaceServiceTest {

    @Autowired
    private SpaceService spaceService;

    @Test
    @Transactional
    public void testGetSpaceById() {
        Long id = 1L; // 데이터베이스에 존재하는 ID

        // 서비스 메서드 호출
        SpaceDto spaceDto = spaceService.getSpaceDetail(id);
        // 서비스 메서드 호출
        // 성공 함
        log.info(spaceDto.toString());

    }
}
