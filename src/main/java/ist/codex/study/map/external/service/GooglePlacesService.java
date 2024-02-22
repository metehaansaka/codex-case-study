package ist.codex.study.map.external.service;

import ist.codex.study.map.external.response.NearbySearchResponse;
import org.springframework.web.bind.annotation.RequestParam;

public interface GooglePlacesService {
    NearbySearchResponse nearbySearch(double longitude, double latitude, int radius);
}
