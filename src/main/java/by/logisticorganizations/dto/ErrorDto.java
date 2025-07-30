package by.logisticorganizations.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class ErrorDto {
    private HttpStatus status;
    private int code;
    private String message;
    private Instant timestamp;
    private String path;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<SubErrorDto> subErrors;
}
