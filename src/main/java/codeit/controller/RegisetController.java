package codeit.controller;

import codeit.Service.UserService;
import codeit.dto.CreateUserDto;
import codeit.dto.ResponseUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("/users")
public class RegisetController {

    private final UserService userService;

    public RegisetController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseUserDto> register(@RequestBody CreateUserDto createUserDtoDto) {
        userService.create(createUserDtoDto);
        return ResponseEntity.ok(new ResponseUserDto("success", "로그인 성공"));
    }
}

