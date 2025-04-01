package codeit.Service;

import codeit.dto.ImageResponse;
import codeit.dto.ImageSummary;
import codeit.dto.UploadCreateDto;

import java.util.UUID;

public interface ImageService {
    ImageResponse create(UploadCreateDto uploadCreateDto);

    ImageSummary getImage(UUID imageId);
}
