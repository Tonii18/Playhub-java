# 🏀 PlayHub

**PlayHub** es una aplicación de escritorio desarrollada en Java para gestionar la reserva de espacios deportivos. Permite a los usuarios registrarse, visualizar canchas disponibles y realizar reservas de forma ágil e intuitiva.

---

## ⚙️ Tecnologías utilizadas

- Java
- Java Swing + WindowBuilder (interfaz gráfica)
- MySQL Workbench (gestión de base de datos)

---

## 📦 Requisitos del sistema

- Java JDK 8 o superior
- MySQL Server
- MySQL Workbench
- IDE compatible (Eclipse recomendado para usar WindowBuilder)

---

## 🗄️ Base de datos

### 📥 Importar la base de datos

El archivo `playhub.sql` incluido en el proyecto contiene toda la estructura y datos iniciales necesarios para ejecutar la aplicación.

> ⚠️ **No es necesario crear la base de datos manualmente.** El archivo ya contiene la instrucción `CREATE DATABASE playhub;`.

**Pasos para importar:**

1. Abre **MySQL Workbench** y conéctate a tu servidor.
2. Ve al menú `Server > Data Import`.
3. Selecciona **"Import from Self-Contained File"**.
4. Elige el archivo `playhub.sql`.
5. Asegúrate de que esté marcada la opción **"Include Create Schema"**.
6. Haz clic en **"Start Import"**.

Una vez finalizado, se creará la base de datos `playhub` con todas las tablas necesarias.

Desarrollado por **[Antonio Jesús Sánchez Rosales]**  
Correo: [sanchezroant20@salesianos.cadiz.edu]

