package ist.codex.study.map.web.controller;

import ist.codex.study.map.internal.service.MapInformationService;
import ist.codex.study.map.web.response.MapInformationResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MapInformationController {
    private final MapInformationService service;
    @GetMapping("/findNearbyPlaces")
    public ResponseEntity<MapInformationResponse> findNearbyPlaces(@RequestParam("longitude") double longitude, @RequestParam("latitude") double latitude, @RequestParam("radius") int radius) {
        MapInformationResponse resposne = service.findNearbyPlaces(longitude, latitude, radius);
        return new ResponseEntity<>(resposne, HttpStatus.OK);
    }
}
