# Security Services Management API

API backend para la gestión de servicios de seguridad en alcaldías, clientes, prioridades, categorías y tipos de servicio. Desarrollada con **Spring Boot** y **SQL Server Express**.

## Tecnologías utilizadas

- Spring Boot 3.2.1
- Spring Web
- Spring Data JPA
- Microsoft SQL Server (JDBC driver)
- Hibernate (ORM)
- Swagger / OpenAPI (documentación interactiva)
- Lombok
- Maven

## Requisitos para correr localmente

- Java 17 (o superior)
- Maven (viene incluido con el wrapper `mvnw`)
- SQL Server Express con instancia `SQLEXPRESS01` y usuario `sa` habilitado

## Configuración

1. Clona el repositorio:
   ```bash
   git clone https://github.com/DiegoResendizM/security-services-backend.git
   cd services-management

Configura la conexión a la base de datos en src/main/resources/application.properties:propertiesspring.datasource.url=jdbc:sqlserver://localhost\\SQLEXPRESS01;databaseName=tu_base_de_datos;encrypt=true;trustServerCertificate=true
spring.datasource.username=sa
spring.datasource.password=tu_contraseñaNota: Nunca subas la contraseña real. Usa variables de entorno en producción.
Ejecuta la aplicación:Bashmvnw.cmd clean spring-boot:run(En Linux/Mac: ./mvnw clean spring-boot:run)

La API estará disponible en:
http://localhost:8080
Documentación interactiva (Swagger)
Mientras la aplicación esté corriendo, abre en tu navegador:
http://localhost:8080/swagger-ui.html
Aquí puedes ver y probar todos los endpoints, ver ejemplos de JSON y hacer peticiones directamente.
Endpoints principales (CRUD completo para Services)
MétodoEndpointDescripciónEjemplo de body JSON (POST/PUT)GET/api/servicesLista todos los servicios—GET/api/services/{id}Obtiene un servicio por ID—POST/api/servicesCrea un nuevo servicioVer ejemplo abajoPUT/api/services/{id}Actualiza un servicioVer ejemplo abajoDELETE/api/services/{id}Elimina un servicio—
Ejemplo de JSON para POST / PUT:
JSON{
  "alcaldiaId": 1,
  "clientId": 1,
  "priorityId": 1,
  "scheduledDate": "2026-02-15",
  "serviceCategoryId": 1,
  "serviceTypeId": 1,
  "status": "PENDIENTE"
}
Estructura del proyecto
textservices-management/
├── src/
│   ├── main/
│   │   ├── java/com/security/service/
│   │   │   ├── controller/     → Controladores REST
│   │   │   ├── service/        → Lógica de negocio
│   │   │   ├── repository/     → Interfaces JPA
│   │   │   ├── model/          → Entidades JPA
│   │   │   └── dto/            → DTOs (Request/Response)
│   │   └── resources/
│   │       └── application.properties  → Configuración
│   └── test/                   → Tests
├── pom.xml                     → Dependencias y configuración Maven
└── README.md                   → Esta guía
Próximos pasos / Mejoras pendientes

Agregar autenticación (JWT o Basic Auth)
CRUD completo para entidades relacionadas (Clients, Alcaldías, Priorities, etc.)
Validaciones con @Valid y manejo global de errores
Tests unitarios e integrados
Despliegue en servidor (Render, Railway, Heroku, Azure, etc.)

¡Bienvenidos!
Cualquier duda, abran un Issue en el repositorio o contáctenme directamente.
Desarrollado por: Diego Resendiz M.
Última actualización: Enero 2026

