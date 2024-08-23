package MomSsok.MomSsok.controller;

import MomSsok.MomSsok.domain.Place;
import MomSsok.MomSsok.service.SearchPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/places")
public class SearchPlaceController {

    private final SearchPlaceService searchPlaceService;

    @Autowired
    public SearchPlaceController(SearchPlaceService searchPlaceService) {
        this.searchPlaceService = searchPlaceService;
    }

    @GetMapping
    public List<Place> getAllPlaces() {
        return searchPlaceService.findAllPlaces();
    }

    @GetMapping("/{id}")
    public Place getPlaceById(@PathVariable Integer id) {
        return searchPlaceService.findPlaceById(id);
    }

    @GetMapping("/search")
    public List<Place> getPlacesByName(@RequestParam String name) {
        return searchPlaceService.findPlacesByName(name);
    }

    @GetMapping("/user/{userId}")
    public List<Place> getPlacesByUserId(@PathVariable int userId) {
        return searchPlaceService.findPlacesByUserId(userId);
    }

    @PostMapping
    public Place createPlace(@RequestBody Place place) {
        return searchPlaceService.savePlace(place);
    }

    @DeleteMapping("/{id}")
    public void deletePlace(@PathVariable Integer id) {
        searchPlaceService.deletePlace(id);
    }
}
