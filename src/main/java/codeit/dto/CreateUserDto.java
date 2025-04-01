package codeit.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
@Builder(toBuilder = true)
@Getter
public class CreateUserDto{
        @NotNull
        @Size(min = 6, max = 30)
        String id;
        @NotNull
        @Size(min = 12, max = 50)
        @Pattern(regexp = "^(?=(.*[a-zA-Z]){2})(?=(.*[0-9]){2})(?=(.*[!@#$%^&*]){2}).{12,50}$")
        String password;
        @NotNull
        @Size(min= 3 ,max = 50)
        String nickName;
        @NotNull
        @Email
        String email;
}
///asdaasdasdasdasdasdasdasddsasdasdasd