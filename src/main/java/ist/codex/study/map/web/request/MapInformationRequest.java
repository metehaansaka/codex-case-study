package ist.codex.study.map.web.request;

import ist.codex.study.map.internal.dto.MapInformationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MapInformationRequest {
    private MapInformationDTO mapInformationDTO;
}
