package ist.codex.study.map.web.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    private boolean isSuccess;
    private String errorMessage;
}
