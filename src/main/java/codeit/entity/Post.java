package codeit.entity;

import lombok.Getter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.*;
@Getter
@EntityScan
public class Post {
    private final UUID id;
    private String title;
    private String content;
    private final String authorId;
    private final List<String> tags;
    private final Long createdAt;
    private Long updatedAt;
    public Post(String title, String content, String authorId, List<String> tags) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.tags = tags;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
    }

}
