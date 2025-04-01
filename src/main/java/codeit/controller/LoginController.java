package codeit.controller;

import codeit.Service.UserService;
import codeit.dto.LoginUserDto;
import codeit.dto.ResponseLoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseLoginDto> login(@RequestBody LoginUserDto loginUserDto) {
        String token = userService.login(loginUserDto);  // JWT 토큰 생성
        return ResponseEntity.ok(new ResponseLoginDto("success", token));  // 응답에 토큰 포함
    }
}

