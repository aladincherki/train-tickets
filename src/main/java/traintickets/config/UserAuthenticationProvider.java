package traintickets.config;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import traintickets.dto.CredentialsDto;
import traintickets.dto.UserDto;
import traintickets.model.User;
import traintickets.service.impl.AuthenticationService;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class UserAuthenticationProvider {

    @Value("${security.jwt.token.secret-key}")
    private String secretKey;
    private final AuthenticationService authenticationService;

    public UserAuthenticationProvider(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String login) {
        Claims claims = Jwts.claims().setSubject(login);
        Date now = new Date();
        Date validity = new Date(now.getTime() + 36000000);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public Authentication validateToken(String token) {
        String login = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        User user = authenticationService.findByLogin(login);

        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());

    }

    public Authentication validateCredentials(CredentialsDto credentialsDto) {
        User user = authenticationService.autthenticate(credentialsDto);

        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());

    }
}
