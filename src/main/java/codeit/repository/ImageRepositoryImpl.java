package codeit.repository;

import codeit.entity.Image;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;
@Repository
public class ImageRepositoryImpl implements ImageRepository {
    private final HashMap<UUID, Image> images = new HashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String FILE_PATH = "images.json";

    public ImageRepositoryImpl() {
        loadImages();
    }

    private void loadImages() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                images.putAll(objectMapper.readValue(file, HashMap.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveImages() {
        try {
            objectMapper.writeValue(new File(FILE_PATH), images);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Image image) {
        images.put(image.getId(), image);
        saveImages();
    }

    @Override
    public Optional<Image> findById(UUID imageId) {
        return Optional.ofNullable(images.get(imageId));
    }
}
