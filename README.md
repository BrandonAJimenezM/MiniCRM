# 🧃 Java Developer Test

**Author:** Brandon J.  
**Email:** [jmbrandon15@gmail.com]  
**Date:** Noviembre 2025
**IDE:** IntelliJ
**Language:** Java 21  
**Build Tool:** Gradle  
**Type:** Mini CRM API

---

## 📋 Descripción

Este proyecto se centra en la creación de la capa de negocio o Backend mediante un API Rest
sus rutas o endpoints han sido configuradas para ofrecer un crud de los servicios Contactos y Empresas.
Para este proyecto, se sugiere usar Postman para validar la estructura Json o Swagger para documentar y hacer pruebas.

---

## 🧩 Implementar características

1. Capa de Modelo de entidades para traer tablas sql a información Orientada a Objectos y viceversa.
2. Capa de Repositorio, permite mantener la persistencia de datos y crear un contrrato con los servicios.
3. Capa de DTO, permite crear plantillas personalizadas de nuestros modelos.
4. Capa de Servicio, permite centrar la logica del negocio para responder las solicitudes del cliente.
5. Capa de Controlador, establecemos nuestros endpoint y controlamos la entrada y salida de las solicitudes y respuestas adecuadamente
6. Swagger documenta el proyecto y permite ver la estructura de los endpoints (Necesita solucion al error 500)
7. Manejo de excepciones de estado.

---

## 🚀 Ejecutar


1. Abrir el proyecto. (Preferible IntelliJ)
2. Click Derecho -> Build (Para construir el backend)

### Swagger
Ejecutar el proyecto y acceder a
```Ruta
http://localhost:8080/swagger-ui/index.html
```

**Nota**: Aun no se soluciona el error 500 es posible que se genere un error
