package ist.codex.study.map.external.service;

import ist.codex.study.map.external.client.GooglePlacesClient;
import ist.codex.study.map.external.response.NearbySearchResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GooglePlacesServiceTest {

    @Mock
    private GooglePlacesClient placesClient;

    @Value("${google.api.key}")
    private String apiKey;

    @InjectMocks
    private GooglePlacesServiceImpl googlePlacesService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testNearbySearch() {
        double longitude = 41.0082;
        double latitude = 28.9784;
        int radius = 500;
        String location = latitude + "," + longitude;
        NearbySearchResponse expectedResponse = new NearbySearchResponse();
        when(placesClient.nearbySearch(location, radius, apiKey)).thenReturn(expectedResponse);
        NearbySearchResponse actualResponse = googlePlacesService.nearbySearch(longitude, latitude, radius);
        assertEquals(expectedResponse, actualResponse, "Response does not match");
        verify(placesClient, times(1)).nearbySearch(location, radius, apiKey);
    }
}
