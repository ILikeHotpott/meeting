package self.live.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import self.live.constant.GlobalConstant;


@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(GlobalConstant.ALLOWED_ORIGINS)
                .allowedMethods(GlobalConstant.ALLOWED_METHODS)
                .allowedHeaders("*")
                .exposedHeaders(HttpHeaders.ACCEPT)
                .allowCredentials(true)
                .maxAge(1800);
    }
}
