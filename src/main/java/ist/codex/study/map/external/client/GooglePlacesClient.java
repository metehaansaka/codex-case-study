package ist.codex.study.map.external.client;

import ist.codex.study.map.external.response.NearbySearchResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "google-places-api", url = "https://maps.googleapis.com/maps/api/place")
public interface GooglePlacesClient {

    @GetMapping("/nearbysearch/json")
    NearbySearchResponse nearbySearch(@RequestParam("location") String location,
                                      @RequestParam("radius") int radius,
                                      @RequestParam("key") String apiKey);
}
