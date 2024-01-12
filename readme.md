# Getting Started

# Mi Proyecto Spring Boot con H2

Este es un proyecto de ejemplo que utiliza Spring Boot y H2.

## Requisitos

- Java 8 o superior
- Gradle

## Configuración

El proyecto está configurado para utilizar una base de datos H2 en memoria. La configuración de la base de datos se encuentra en el archivo `src/main/resources/application.properties`.

## Ejecución

Para ejecutar el proyecto, puedes usar el plugin Spring Boot de Gradle.

Con Gradle:

```bash
./gradlew bootRun
```

## Pruebas
El proyecto incluye pruebas unitarias que puedes ejecutar con Gradle.

```bash
./gradlew test
```

## API
El proyecto incluye una API REST con los siguientes endpoints:

POST /api/users/register: Crea un nuevo usuario.

## Licencia
Este proyecto está licenciado bajo los términos de la licencia MIT.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.1/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.1/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)