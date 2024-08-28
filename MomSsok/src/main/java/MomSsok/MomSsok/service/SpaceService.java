package MomSsok.MomSsok.service;

import MomSsok.MomSsok.domain.Space;
import MomSsok.MomSsok.dto.*;
import MomSsok.MomSsok.repository.SpaceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SpaceService {

    private final SpaceRepository spaceRepository;

    // 접근성 정보 관련 DTO 생성
    private List<AccessInfoDto> accessInfoDto(Space space) {
        return space.getAcInfo().stream()
                .map(ac -> new AccessInfoDto(ac.getAcInfoId(), ac.getAssessinfo(), ac.getAssessinfoIcon()))
                .collect(Collectors.toList());
    }

    public SpaceDto getSpaceDetail(Long space_id) {
        // 1. Space와 접근성 정보 가져오기
        Optional<Space> spaceOpt = spaceRepository.findDetailedSpaceById(space_id);
        if (!spaceOpt.isPresent()) {
            throw new EntityNotFoundException("Space not found with id: " + space_id);
        }
        Space space = spaceOpt.get();

        // 2. 리뷰 수 및 평균 평점 가져오기
        Optional<Object[]> statsOpt = spaceRepository.findSpaceWithReviewStats(space_id);
        int reviewCount = 0;
        BigDecimal averageRating = BigDecimal.ZERO;
        if (statsOpt.isPresent()) {
            Object[] stats = statsOpt.get();
            if (stats.length > 1) {  // 배열의 길이 체크
                reviewCount = ((Long) stats[1]).intValue() * 10;
            } else {
                reviewCount = 0;  // 기본값 설정
            }

            if (stats.length > 2) {  // 배열의 길이 체크
                averageRating = (BigDecimal) stats[2];
            } else {
                averageRating = BigDecimal.ZERO;  // 기본값 설정
            }
        }
        return new SpaceDto(
                space.getSpaceId(),
                space.getName(),
                space.getDescription(),
                List.of(new ImageDto(space.getImage_url())),
                List.of(new InfoDto(space.getAddress(), space.getContact(), space.getOperationDays())),
                space.getTag(),
                List.of(new SubwayDto(space.getSubwayStation(), space.getSubwayExit() , space.getSubwayDescription())),
                List.of(new BusDto(space.getType(), space.getBusNumber(), space.getDirections())),
                accessInfoDto(space),
                space.getLocationType(),
                reviewCount,
                averageRating
        );
    }
}
