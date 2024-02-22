package ist.codex.study.map.web.response;

import ist.codex.study.map.external.dto.ResultDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MapInformationResponse extends BaseResponse{
    private List<ResultDTO> results;
}
