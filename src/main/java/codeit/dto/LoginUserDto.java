package codeit.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class LoginUserDto {
    @NotNull
    private final String id;
    @NotNull
    private final String password;


}
