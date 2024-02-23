package ist.codex.study.map.internal.service;


import ist.codex.study.map.dao.model.MapInformation;
import ist.codex.study.map.dao.repository.MapInformationRepository;
import ist.codex.study.map.external.dto.ResultDTO;
import ist.codex.study.map.external.response.NearbySearchResponse;
import ist.codex.study.map.external.service.GooglePlacesService;
import ist.codex.study.map.internal.dto.MapInformationDTO;
import ist.codex.study.map.web.response.MapInformationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MapInformationServiceTest {

    @Mock
    private MapInformationRepository repository;

    @Mock
    private GooglePlacesService googlePlacesService;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private MapInformationServiceImpl mapInformationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindNearbyPlaces_ExistingInformation() {
        double longitude = 41.0082;
        double latitude = 28.9784;
        int radius = 500;

        MapInformationDTO mapInformationDTO = new MapInformationDTO(longitude, latitude, radius, Collections.emptyList());
        MapInformation mapInformation = new MapInformation();
        mapInformation.setLatitude(latitude);
        mapInformation.setLongitude(longitude);
        mapInformation.setRadius(radius);

        when(repository.findByLatitudeAndLongitudeAndRadius(latitude, longitude, radius)).thenReturn(Optional.of(mapInformation));
        when(modelMapper.map(mapInformation, MapInformationDTO.class)).thenReturn(mapInformationDTO);

        MapInformationResponse response = mapInformationService.findNearbyPlaces(longitude, latitude, radius);

        assertTrue(response.isSuccess());
        assertEquals(Collections.emptyList(), response.getResults());
    }

    @Test
    public void testFindNearbyPlaces_NonExistingInformation() {
        double longitude = 41.0082;
        double latitude = 28.9784;
        int radius = 500;

        NearbySearchResponse nearbySearchResponse = new NearbySearchResponse();
        ResultDTO resultDTO = new ResultDTO();
        nearbySearchResponse.setResults(Collections.singletonList(resultDTO));

        when(repository.findByLatitudeAndLongitudeAndRadius(latitude, longitude, radius)).thenReturn(Optional.empty());
        when(googlePlacesService.nearbySearch(longitude, latitude, radius)).thenReturn(nearbySearchResponse);

        MapInformation mapInformation = new MapInformation();
        mapInformation.setLatitude(latitude);
        mapInformation.setLongitude(longitude);
        mapInformation.setRadius(radius);
        mapInformation.setResults(Collections.emptyList());
        when(modelMapper.map(any(),any())).thenReturn(mapInformation);

        MapInformationResponse response = mapInformationService.findNearbyPlaces(longitude, latitude, radius);

        assertTrue(response.isSuccess());
        assertEquals(Collections.singletonList(resultDTO), response.getResults());
    }

    @Test
    public void testFindNearbyPlaces_Exception() {
        double longitude = 41.0082;
        double latitude = 28.9784;
        int radius = 500;

        String errorMessage = "Error message";
        when(repository.findByLatitudeAndLongitudeAndRadius(latitude, longitude, radius)).thenReturn(Optional.empty());
        when(googlePlacesService.nearbySearch(longitude, latitude, radius)).thenThrow(new RuntimeException(errorMessage));
        MapInformationResponse response = mapInformationService.findNearbyPlaces(longitude, latitude, radius);

        assertFalse(response.isSuccess());
        assertEquals(errorMessage, response.getErrorMessage());
    }
}
