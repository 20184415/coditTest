package codeit.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UploadCreateDto {
    private final MultipartFile file;
    private String originalFileName;
    @Pattern(regexp = "(?i)^(jpg|jpeg|png|gif)$")
    private String extension;

    @AssertTrue()
    public boolean isFileNameValid() {
        if (originalFileName == null) return true;
        int dotIndex = originalFileName.lastIndexOf('.');
        String baseName = (dotIndex > 0) ? originalFileName.substring(0, dotIndex) : originalFileName;
        return baseName.length() <= 32;
    }
}