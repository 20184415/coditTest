package codeit.dto;

import java.util.UUID;

public record ImageResponse(
        String success, UUID imageId, String path) {
}

