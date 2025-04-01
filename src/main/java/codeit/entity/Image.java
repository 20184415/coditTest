package codeit.entity;

import lombok.Getter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.*;
@EntityScan
@Getter
public class Image {
    private final UUID id;
    private final String originalName;
    private final String extension;
    private final String path;
    private final Long size;
    private final Long uploadedAt;
    public Image( String path,Long size,String originalName,String extension)
             {
        this.id = UUID.randomUUID();
        this.originalName = originalName;
        this.extension = extension;
        this.path = path;
        this.size = size;
        this.uploadedAt = System.currentTimeMillis();

    }
}
