package codeit.Service;

import codeit.dto.CreateUserDto;
import codeit.dto.LoginUserDto;

public interface UserService {
    void create(CreateUserDto createUserDto);

    String login(LoginUserDto loginUserDto);

    boolean existsById(String userId);
}
