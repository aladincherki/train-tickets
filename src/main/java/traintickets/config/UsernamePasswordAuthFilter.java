package traintickets.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import traintickets.dto.CredentialsDto;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UsernamePasswordAuthFilter extends OncePerRequestFilter {

    private static final com.fasterxml.jackson.databind.ObjectMapper MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();


    private final UserAuthenticationProvider userAuthenticateProvider;

    public UsernamePasswordAuthFilter(UserAuthenticationProvider userAuthenticateProvider) {
        this.userAuthenticateProvider = userAuthenticateProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        if("/v1/signIn".equals(request.getServletPath()) && HttpMethod.POST.matches(request.getMethod())) {
            CredentialsDto credentialsDto = MAPPER.readValue(request.getInputStream(), CredentialsDto.class);
            try {
                SecurityContextHolder.getContext().setAuthentication(
                        userAuthenticateProvider.validateCredentials(credentialsDto)
                );
            } catch (RuntimeException e) {
                SecurityContextHolder.clearContext();
                throw e;
            }

            filterChain.doFilter(request, response);
        }

    }
}
