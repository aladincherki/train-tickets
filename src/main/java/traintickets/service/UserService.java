package traintickets.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import traintickets.AppException;
import traintickets.dto.SignUpDto;
import traintickets.dto.UserDto;
import traintickets.model.User;
import traintickets.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.CharBuffer;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    //@Autowired(required = false)
    private final UserRepository userRepository;

/*    @Autowired(required = false)
    private  UserMapper userMapper;*/
    //@Autowired(required = false)
    private final PasswordEncoder passwordEncoder;

    public User signUp(SignUpDto userDto) {
        Optional<User> optionalUSer = userRepository.findByLogin(userDto.getLogin());

        if(!optionalUSer.isEmpty()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setLogin(userDto.getLogin());
       // userMapper.signUpTOUser(userDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())));
        User savedUser = userRepository.save(user);
        log.info("Creating new user {}", userDto.getLogin());

        return savedUser;
    }
}
