package codeit.entity;

import lombok.Getter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.*;
@Getter
@EntityScan
public class PostImage {
    private final UUID id;
    private final UUID postId;
    private final UUID imageId;
    public PostImage( UUID postId, UUID imageId) {
        this.id = UUID.randomUUID();
        this.postId = postId;
        this.imageId = imageId;
    }
}
