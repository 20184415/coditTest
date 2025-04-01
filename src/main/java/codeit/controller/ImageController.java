package codeit.controller;

import codeit.Service.ImageService;
import codeit.dto.ImageResponse;
import codeit.dto.UploadCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

//POST /api/images - 이미지 업로드 (인증 필요)
//GET /api/images/{imageId} - 이미지 조회
@Controller
@RequiredArgsConstructor
public class ImageController {
    ImageService imageService;
    @PostMapping("/images")
    public ResponseEntity<ImageResponse> uploadImage(UploadCreateDto uploadCreateDto) {
        ImageResponse imageResponse=imageService.create(uploadCreateDto);
        return ResponseEntity.ok(imageResponse);
    }

    @GetMapping("/{imageId}")
        public ResponseEntity<ImageResponse> getImage(@PathVariable UUID imageId) {
       return ResponseEntity.ok(imageService.getImage(imageId));
        }
}
