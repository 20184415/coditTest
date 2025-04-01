package codeit.repository;

import codeit.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final HashMap<String, User> users = new HashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String FILE_PATH = "users.json";

    public UserRepositoryImpl() {
        loadUsers();
    }

    private void loadUsers() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                users.putAll(objectMapper.readValue(file, HashMap.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUsers() {
        try {
            objectMapper.writeValue(new File(FILE_PATH), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> findById(String userId) {
        return users.values().stream()
                .filter(user -> user.getId()
                        .equals(userId)).findFirst();
    }

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
        saveUsers();
    }
}
