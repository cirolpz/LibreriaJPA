# ACTUALMENTE EL BOOTCAMP DEJO DE EXISTIR, PERO ESTE ERA EL CONTENIDO

Carrera EGG Bootcamp

Duración y Contenidos:
- PWDC (Programación Web Desde Cero): 36 días
- Git: 24 días
- HTML/CSS: 24 días
- Javascript I: 23 días
- Javascript II: 48 días
- React I: 24 días
- React II: 55 días
- Intro Java: 62 días
- POO I (Programación Orientada a Objetos I): 12 días
- POO II (Programación Orientada a Objetos II): 24 días
- Java Collection Framework I: 9 días
- Base de Datos MySQL: 40 días
- JDBC (Java Database Connectivity): 35 días
- Spring: 50 días
- JPA (Java Persistence API): 60 pasos

Descripción:
La Carrera EGG fue un bootcamp de programación en el que participé. La plataforma ya no está disponible, pero durante el bootcamp, asistía a sesiones de videollamada de lunes a viernes durante 3 horas cada día. Trabajábamos en grupos de 8 personas, estudiando el contenido proporcionado y resolviendo ejercicios de programación.

# CRUDConSpringBootJDBC

**CRUDConSpringBootJDBC** es un proyecto que implementa operaciones CRUD (Crear, Leer, Actualizar, Eliminar) usando **Spring Boot** y **JDBC**. Este proyecto está diseñado para demostrar cómo interactuar con bases de datos a través de JDBC en una aplicación Spring Boot.

---

## ✨ Características

- **Crear:** Añadir nuevas entradas a la base de datos.
- **Leer:** Obtener datos de la base de datos.
- **Actualizar:** Modificar datos existentes en la base de datos.
- **Eliminar:** Remover datos de la base de datos.

---

## 🛠️ Tecnologías Utilizadas

- **Java:** Lenguaje de programación principal.
- **Spring Boot:** Framework para la creación de aplicaciones Java.
- **JDBC:** API para la conexión y ejecución de consultas en bases de datos.
- **Maven:** Herramienta de gestión de proyectos y dependencias.

---

## 📋 Requisitos Previos

- **JDK 11** o superior.
- **Maven 3.6** o superior.
- Una base de datos compatible con **JDBC** (por ejemplo, MySQL o PostgreSQL).

---

## 🚀 Instalación y Ejecución

### Clonar el repositorio:

git clone https://github.com/cirolpz/CRUDConSpringBootJDBC.git
## Navegar al directorio del proyecto:

``bash
cd CRUDConSpringBootJDBC

## 📖 Uso

### Endpoints

- **GET /items:** Obtener todos los ítems.
- **GET /items/{id}:** Obtener un ítem por ID.
- **POST /items:** Crear un nuevo ítem.
- **PUT /items/{id}:** Actualizar un ítem existente.
- **DELETE /items/{id}:** Eliminar un ítem por ID.

### Ejemplo de Peticiones

#### Crear un nuevo ítem:

```bash
curl -X POST http://localhost:8080/items -H "Content-Type: application/json" -d '{"nombre":"Nuevo Item","precio":100}'

