package ist.codex.study.map.web.controller;

import ist.codex.study.map.internal.service.MapInformationService;
import ist.codex.study.map.web.response.MapInformationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MapInformationControllerTest {

    @Mock
    private MapInformationService service;

    @InjectMocks
    private MapInformationController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindNearbyPlaces() {
        double longitude = 41.0082;
        double latitude = 28.9784;
        int radius = 500;
        MapInformationResponse expectedResponse = new MapInformationResponse();
        expectedResponse.setSuccess(true);
        expectedResponse.setResults(Collections.emptyList());

        when(service.findNearbyPlaces(longitude, latitude, radius)).thenReturn(expectedResponse);

        ResponseEntity<MapInformationResponse> responseEntity = controller.findNearbyPlaces(longitude, latitude, radius);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponse, responseEntity.getBody());

        verify(service, times(1)).findNearbyPlaces(longitude, latitude, radius);
    }
}
