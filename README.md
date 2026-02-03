# 🔐 Backend de Seguridad Electrónica – Spring Boot

Proyecto backend desarrollado en **Java con Spring Boot**, enfocado en simular un sistema básico de **seguridad electrónica**, donde se reciben y registran eventos provenientes de sensores o dispositivos de seguridad.

Este proyecto tiene fines **educativos** y busca demostrar la integración entre **programación backend** y **conceptos de seguridad electrónica**.

---

## 🧠 Escenario simulado

El sistema representa un entorno donde dispositivos de seguridad (por ejemplo):

- Sensores de movimiento (PIR)
- Sensores de apertura de puerta
- Alarmas
- Cámaras (solo eventos, no video)

envían **eventos** a un servidor central para su **registro y análisis**.

Cada evento queda almacenado en una base de datos para:
- Auditoría
- Historial de incidentes
- Monitoreo básico

---

## ⚙️ Tecnologías utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Base de datos H2 (en memoria)
- Maven
- Git / GitHub

---

## 📂 Estructura del proyecto

src/main/java/com/seguridad
├── controller -> Controladores REST
├── model -> Entidades (Eventos)
├── repository -> Acceso a datos
└── SeguridadApplication.java


---

## 🚀 Cómo ejecutar el proyecto

### Requisitos
- Java JDK
- Maven (o usar el wrapper incluido)

### Ejecutar

```bash
./mvnw spring-boot:run

El backend se inicia en:

http://localhost:8080

🗄️ Consola H2

La base de datos H2 se utiliza para pruebas y aprendizaje.

    URL: http://localhost:8080/h2-console

    JDBC URL: jdbc:h2:mem:testdb

    Usuario: sa

    Contraseña: (vacía)

📡 Ejemplo de evento recibido

Ejemplo de evento enviado al sistema:

{
  "tipo": "MOVIMIENTO",
  "ubicacion": "Entrada principal",
  "descripcion": "Movimiento detectado fuera de horario"
}

Este evento queda almacenado en la base de datos para su consulta posterior.
💼 Aplicación en la vida real

En un entorno real, este backend podría integrarse con:

    Paneles de alarma

    Sistemas de control de acceso

    NVR / DVR

    Sistemas SCADA o IoT

Permitiendo centralizar eventos de seguridad en un solo sistema.
📌 Autor

Proyecto desarrollado por Diego Reséndiz
Con fines educativos y de aprendizaje en backend y seguridad electrónica.
