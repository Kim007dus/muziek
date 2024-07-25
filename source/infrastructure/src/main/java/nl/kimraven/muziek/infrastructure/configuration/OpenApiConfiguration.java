package nl.kimraven.muziek.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;



/**
 * 
 */
@Configuration
public class OpenApiConfiguration {
    
    //
    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    OpenAPI myOpenAPI() {
        return new OpenAPI()
                .info(new Info().title(applicationName).version(getClass().getPackage().getImplementationVersion()));
    }
}
