package carlos.marcos.cursos.configurations;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "cursos",
                        email = "cursos@gmail.com",
                        url = "https://cursos.com"

                ),
                title="Curso Ejemplos - Documentación",
                description ="OpenAPI documentation para RESTful API",
                version = "1.0",
                termsOfService = "Uso restringido a pruebas del proyecto de cursos"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://127.0.0.1:8080"
                )
        }
)
public class OpenApiConfig {
}
