package codeit.dto;

import jakarta.validation.constraints.NotNull;

public record ResponseUserDto(
        @NotNull
        String successMessage,
        @NotNull
        String message

) {
}
