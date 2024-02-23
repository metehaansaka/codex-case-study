package ist.codex.study.map.model;

import ist.codex.study.map.dao.model.Geometry;
import ist.codex.study.map.dao.model.Location;
import ist.codex.study.map.dao.model.MapInformation;
import ist.codex.study.map.dao.model.Result;
import ist.codex.study.map.external.dto.GeometryDTO;
import ist.codex.study.map.external.dto.LocationDTO;
import ist.codex.study.map.external.dto.ResultDTO;
import ist.codex.study.map.external.response.NearbySearchResponse;
import ist.codex.study.map.internal.dto.MapInformationDTO;
import ist.codex.study.map.util.GenericModelTester;
import ist.codex.study.map.web.request.MapInformationRequest;
import ist.codex.study.map.web.response.MapInformationResponse;
import org.junit.jupiter.api.Test;


public class ModelTest {
    @Test
    public void testModels() {
        GenericModelTester.testEntityOrDto(Geometry.class);
        GenericModelTester.testEntityOrDto(Location.class);
        GenericModelTester.testEntityOrDto(MapInformation.class);
        GenericModelTester.testEntityOrDto(Result.class);
        GenericModelTester.testEntityOrDto(GeometryDTO.class);
        GenericModelTester.testEntityOrDto(LocationDTO.class);
        GenericModelTester.testEntityOrDto(ResultDTO.class);
        GenericModelTester.testEntityOrDto(NearbySearchResponse.class);
        GenericModelTester.testEntityOrDto(MapInformationDTO.class);
        GenericModelTester.testEntityOrDto(MapInformationRequest.class);
        GenericModelTester.testEntityOrDto(MapInformationResponse.class);
    }
}
