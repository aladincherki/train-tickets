package traintickets.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import traintickets.AppException;
import traintickets.dto.CredentialsDto;
import traintickets.dto.UserDto;
import traintickets.model.User;
import traintickets.repository.UserRepository;

import javax.transaction.Transactional;
import java.nio.CharBuffer;

@Service
@Slf4j
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public AuthenticationService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Transactional
    public User autthenticate(CredentialsDto credentialsDto) {
        User user = userRepository.findByLogin(credentialsDto.getLogin())
                .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
        if(passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), user.getPassword())) {
            log.debug("User {} authenticated correctly", credentialsDto.getLogin());
            return user;
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public User findByLogin(String login) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("Login not found", HttpStatus.NOT_FOUND));
        return user;
    }
}
