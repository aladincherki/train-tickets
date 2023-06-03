package traintickets.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/trains/")
public class TrainsController {

    //@Autowired(required = false)
   // private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity getTrains() {
        //Optional<String> test = Optional.of(this.userMapper.test("test")) ;
        return ResponseEntity.ok("trains retrieved succesufuly ");
    }
}
