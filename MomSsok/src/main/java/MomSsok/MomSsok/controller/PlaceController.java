package MomSsok.MomSsok.controller;



import MomSsok.MomSsok.dto.PlaceDto;
import MomSsok.MomSsok.service.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 상세페이지 컨틀톨러
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/places")
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping("/{id}") // 경로 수정
    public PlaceDto getPlace(@PathVariable Long id) {
        return placeService.getPlaceDetails(id);
    }
    




}
