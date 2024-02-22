package ist.codex.study.map.external.response;

import ist.codex.study.map.external.dto.ResultDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NearbySearchResponse {
    private List<ResultDTO> results;
}
