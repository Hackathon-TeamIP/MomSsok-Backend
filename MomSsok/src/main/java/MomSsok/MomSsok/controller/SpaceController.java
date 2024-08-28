package MomSsok.MomSsok.controller;



import MomSsok.MomSsok.dto.SpaceDto;
import MomSsok.MomSsok.service.SpaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/api/space")
public class SpaceController {

    private final SpaceService spaceService;

    @GetMapping("/{id}") // 경로 수정
    public SpaceDto getPlace(@PathVariable Long id) {
        return spaceService.getSpaceDetail(id);
    }
    




}
