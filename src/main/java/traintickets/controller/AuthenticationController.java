package traintickets.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import traintickets.config.UserAuthenticationProvider;
import traintickets.dto.SignUpDto;
import traintickets.dto.UserDto;
import traintickets.model.User;
import traintickets.service.UserService;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class AuthenticationController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping("/signIn")
    public ResponseEntity<UserDto> signIn(@RequestBody UserDto user) {
        user.setToken(userAuthenticationProvider.createToken(user.getLogin()));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/signIn")
    public String signInGet(@RequestBody UserDto user) {
        // user.setToken(userAuthenticationProvider.createToken(user.getLogin()));
        return "ResponseEntity.ok(user)";
    }


    @PostMapping("/signUp")
    public ResponseEntity<User> signUp(@RequestBody @Valid SignUpDto user) {
        User createdUser = userService.signUp(user);
        //return ResponseEntity.created(URI.create("/users/" + "createdUser.getId()" + "/profile")).body(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("createdUser");
    }

}
