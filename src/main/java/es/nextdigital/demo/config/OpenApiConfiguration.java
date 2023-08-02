package es.nextdigital.demo.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI openApiInformation() {
        Server localServer = new Server()
                .url("http://localhost:8080")
                .description("Local Environment");

        Server productionServer = new Server()
                .url("http://localhost:8080")
                .description("Productive Environment");

        Contact contact = new Contact()
                .email("diego.montes@outlook.com")
                .name("DiegoMN");

        Info info = new Info()
                .contact(contact)
                .description("API for bank management")
                .summary("API for bank management")
                .title("Bank API")
                .version("1.0.0")
                .license(new License().name("Apache 2.0").url("http://springdoc.org"));

        return new OpenAPI().info(info).addServersItem(localServer).addServersItem(productionServer);
    }


}