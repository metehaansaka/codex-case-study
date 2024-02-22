package ist.codex.study.map.external.service;

import ist.codex.study.map.external.client.GooglePlacesClient;
import ist.codex.study.map.external.response.NearbySearchResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GooglePlacesServiceImpl implements GooglePlacesService{
    private final GooglePlacesClient client;
    private final String apiKey;

    @Autowired
    public GooglePlacesServiceImpl(GooglePlacesClient placesClient, @Value("${google.api.key}") String apiKey) {
        this.client = placesClient;
        this.apiKey = apiKey;
    }
    @Override
    public NearbySearchResponse nearbySearch(double longitude, double latitude, int radius) {
        String location = latitude + "," + longitude;
        return client.nearbySearch(location, radius, apiKey);
    }
}
