package self.live.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import self.live.entity.SelfConfigPropertiesBean;

@Import(SelfConfigPropertiesBean.class)
@EnableConfigurationProperties
@Configuration
public class SelfConfiguration {
    @Bean
    @ConfigurationProperties(
            prefix = "self"
    )
    public SelfConfigPropertiesBean selfConfigPropertiesBean() {
        return new SelfConfigPropertiesBean();
    }
}
