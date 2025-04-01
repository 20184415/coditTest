package codeit.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
@NotNull
@Getter
@AllArgsConstructor
@Builder(toBuilder = true)
public class ResponseLoginDto {
 private final  String successMessage;
 private final String token;
}
