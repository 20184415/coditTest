package codeit.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@NotNull
@Builder
@AllArgsConstructor
public class PostResponse {
  private final  String success;
   private final String postId;
}
