package codeit.repository;

import codeit.entity.Image;

import java.util.Optional;
import java.util.UUID;

public interface ImageRepository {
    void save(Image image);

    Optional<Image> findById(UUID imageId);
}
