package ist.codex.study.map.internal.service;

import ist.codex.study.map.web.response.MapInformationResponse;

public interface MapInformationService {
    public MapInformationResponse findNearbyPlaces(double longitude, double latitude, int radius);
}
