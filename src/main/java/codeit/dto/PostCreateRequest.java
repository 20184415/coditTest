package codeit.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
@NotNull
public class PostCreateRequest {
        @NotBlank
        private String title;
        @NotBlank
        @Size(min = 2, max = 1000)
        private String content;
        private List<@Pattern(regexp = "^[A-Za-z]+$") String> tags;

    }