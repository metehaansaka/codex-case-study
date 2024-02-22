package ist.codex.study.map.internal.service;

import ist.codex.study.map.dao.model.MapInformation;
import ist.codex.study.map.dao.model.Result;
import ist.codex.study.map.dao.repository.MapInformationRepository;
import ist.codex.study.map.external.dto.ResultDTO;
import ist.codex.study.map.external.response.NearbySearchResponse;
import ist.codex.study.map.external.service.GooglePlacesService;
import ist.codex.study.map.internal.dto.MapInformationDTO;
import ist.codex.study.map.web.response.MapInformationResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MapInformationServiceImpl implements MapInformationService {
    private final MapInformationRepository repository;
    private final GooglePlacesService googlePlacesService;
    private final ModelMapper modelMapper;

    @Override
    public MapInformationResponse findNearbyPlaces(double longitude, double latitude, int radius) {
        Optional<MapInformation> mapInformationOptional = repository.findByLatitudeAndLongitudeAndRadius(latitude,longitude,radius);
        MapInformationResponse response = new MapInformationResponse();
        response.setSuccess(true);
        if (mapInformationOptional.isPresent()) {
            MapInformationDTO mapInformationDTO = modelMapper.map(mapInformationOptional.get(),MapInformationDTO.class);
            response.setResults(mapInformationDTO.getResults());
            return response;
        }
        try {
            NearbySearchResponse nearbySearchResponse = googlePlacesService.nearbySearch(longitude,latitude,radius);
            MapInformationDTO mapInformationDTO = new MapInformationDTO(longitude, latitude, radius, nearbySearchResponse.getResults());
            MapInformation mapInformation = modelMapper.map(mapInformationDTO, MapInformation.class);
            mapInformation.getResults().forEach(e -> e.setMapInformation(mapInformation));
            repository.save(mapInformation);
            response.setResults(nearbySearchResponse.getResults());
        }catch (Exception e){
            response.setSuccess(false);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

}
