package codeit.Service.serviceimp;

import codeit.Service.UserService;
import codeit.dto.CreateUserDto;
import codeit.dto.LoginUserDto;
import codeit.entity.User;
import codeit.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import codeit.jwt.*;
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImp implements UserService {
    private  final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Override
    public void create(CreateUserDto userDto){
            if (userRepository.findById(userDto.getId()).isPresent()){
                throw new IllegalArgumentException("User already exists");
            }
            String hashedPassword = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
            User user = new User(userDto.getId(),userDto.getEmail(),hashedPassword,userDto.getEmail());

            userRepository.save(user);
        }
        @Override
        public String login(LoginUserDto loginUserDto) {
            User user = userRepository.findById(loginUserDto.getId())
                    .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

            // 비밀번호 검증
            if (!BCrypt.checkpw(loginUserDto.getPassword(), user.getPassword())) {
                throw new RuntimeException("비밀번호가 일치하지 않습니다.");
            }

            // JWT 토큰 생성 및 반환
            return jwtUtil.generateToken(user.getId());
        }

        public boolean existsById(String userId) {
            return userRepository.findById(userId).isPresent();
        }


    }
