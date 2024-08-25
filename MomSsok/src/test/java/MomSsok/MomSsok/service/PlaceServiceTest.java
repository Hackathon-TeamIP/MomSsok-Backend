package MomSsok.MomSsok.service;

import MomSsok.MomSsok.dto.PlaceDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringJUnitConfig
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PlaceServiceTest {


    private PlaceService placeService;

    //@Test
//    @Transactional
//    public void testGetPlaceById() {
//        Long id = 13L; // 데이터베이스에 존재하는 ID
//
//        // 서비스 메서드 호출
//        // 서비스 메서드 호출
//        PlaceDto placeDto = placeService.getPlaceDetails(id);
//
//        // 결과를 로그로 출력
//        log.info("Retrieved PlaceDetailDto: {}", placeDto);
//
//    }
}