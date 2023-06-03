package traintickets.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.http.HttpHeaders;

public class JwtAuthFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LogManager.getLogger(JwtAuthFilter.class);

    private final UserAuthenticationProvider userAuthenticationProvider;
    public JwtAuthFilter(UserAuthenticationProvider userAuthenticationProvider) {
        this.userAuthenticationProvider = userAuthenticationProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(header != null) {
            String[] authElement = header.split(" ");

            if (authElement.length == 2 && "Bearer".equals(authElement[0])) {
                try {
                    Authentication authentication = userAuthenticationProvider.validateToken(authElement[1]);
                    SecurityContextHolder.getContext().setAuthentication(
                            userAuthenticationProvider.validateToken(authElement[1])

                    );

                    LOGGER.debug("Debug level log message if");
                } catch (RuntimeException e) {
                    SecurityContextHolder.clearContext();
                    throw e;
                }
            }


            LOGGER.debug("Debug level log message if");
        }

        LOGGER.debug("Debug level log message if");
        filterChain.doFilter(request, response);
    }
}
