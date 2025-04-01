package codeit.Service.serviceimp;

import codeit.Service.ImageService;
import codeit.dto.ImageResponse;
import codeit.dto.ImageSummary;
import codeit.dto.UploadCreateDto;
import codeit.entity.Image;
import codeit.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    @Value("${image.path}")
    private String path;

    private final ImageRepository imageRepository;

    @Override
    public ImageResponse create(UploadCreateDto uploadCreateDto) {
        Image image = new Image(
                path,
                uploadCreateDto.getFile().getSize(),
                uploadCreateDto.getOriginalFileName(),
                uploadCreateDto.getExtension()
        );
        // 저장 후 UUID/경로 반환
        imageRepository.save(image);
        return new ImageResponse("true",
                image.getId(),path );
    }

    @Override
    public ImageSummary getImage(UUID imageId) {
        Image image = imageRepository.findById(imageId)
                .orElseThrow(() -> new NoSuchElementException("찾는 이미지 없음"));
        return new ImageSummary(image.getId().toString(),image.getOriginalName(),image.getExtension(),image.getPath()
        ,image.getSize(),image.getUploadedAt());
    }
}
