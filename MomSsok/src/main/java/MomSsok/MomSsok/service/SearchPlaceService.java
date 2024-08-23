package MomSsok.MomSsok.service;

import MomSsok.MomSsok.domain.Place;
import MomSsok.MomSsok.repository.SearchPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchPlaceService {

    private final SearchPlaceRepository searchPlaceRepository;

    @Autowired
    public SearchPlaceService(SearchPlaceRepository searchPlaceRepository) {
        this.searchPlaceRepository = searchPlaceRepository;
    }

    public List<Place> findAllPlaces() {
        return searchPlaceRepository.findAll();
    }

    public Place findPlaceById(Integer id) {
        return searchPlaceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid place ID: " + id));
    }

    public List<Place> findPlacesByName(String name) {
        return searchPlaceRepository.findByName(name);
    }

    public List<Place> findPlacesByUserId(int userId) {
        return searchPlaceRepository.findByUserId(userId);
    }

    public Place savePlace(Place place) {
        return searchPlaceRepository.save(place);
    }

    public void deletePlace(Integer id) {
        searchPlaceRepository.deleteById(id);
    }
}
