package ist.codex.study.map.external.dto;

import ist.codex.study.map.internal.dto.MapInformationDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultDTO {
    private String name;
    private String address;
    private String placeId;
    private GeometryDTO geometry;
}
