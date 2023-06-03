package traintickets.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import traintickets.dto.CredentialsDto;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UserAuthenticationFilter implements Filter {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static final Logger LOGGER = LogManager.getLogger(JwtAuthFilter.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // nothing to do
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;
        SecurityContext securityContext = SecurityContextHolder.getContext();

        if ("/v1/signIn".equals(httpReq.getServletPath())
                && HttpMethod.POST.matches(httpReq.getMethod())) {
            CredentialsDto credentialsDto = MAPPER.readValue(httpReq.getInputStream(), CredentialsDto.class);

            securityContext.setAuthentication(
                    new UsernamePasswordAuthenticationToken(
                            credentialsDto.getLogin(), credentialsDto.getPassword()));
            LOGGER.debug("if");
        } else {
            String header = httpReq.getHeader(HttpHeaders.AUTHORIZATION);

            if (header != null) {
                String[] authElements = header.split(" ");

                if (authElements.length == 2
                        && "Bearer".equals(authElements[0])) {
                    securityContext.setAuthentication(new PreAuthenticatedAuthenticationToken(authElements[1], null));
                }
            }
            LOGGER.debug("else");
        }

        LOGGER.debug("outsid");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        // nothing to do
    }
}
