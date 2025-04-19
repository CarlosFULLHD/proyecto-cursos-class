# 📚 Proyecto de Gestión de Cursos Online con Spring Boot y PostgreSQL

Este proyecto es una aplicación básica para gestionar cursos online, desarrollada con **Spring Boot** y **PostgreSQL**. Permite listar cursos y puede extenderse fácilmente para manejar estudiantes e inscripciones.

## 🚀 Tecnologías usadas

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL (en Docker)
- Swagger (OpenAPI)
- Maven

## ⚙️ Configuración del entorno

### 1. Ejecutar PostgreSQL con Docker

Usa el siguiente comando para iniciar la base de datos:

```bash
docker run --name cursos-db -e POSTGRES_DB=bd_cursos_online -e POSTGRES_USER=usuario_cursos -e POSTGRES_PASSWORD=clave_cursos -p 5433:5432 -d postgres:15
```


###
Swagger url

```
http://localhost:8080/swagger-ui/index.html
```



