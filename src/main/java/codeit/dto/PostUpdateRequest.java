package codeit.Service;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.*;
public record PostUpdateRequest(
        String title,
        @Size(min = 2, max = 1000)
        String content,
        List<@Pattern(regexp = "^[A-Za-z]+$")String>tags

) {
}
