package ist.codex.study.map.internal.dto;

import ist.codex.study.map.dao.model.Result;
import ist.codex.study.map.external.dto.ResultDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MapInformationDTO {
    private double longitude;
    private double latitude;
    private int radius;
    private List<ResultDTO> results;
}
