# 📚 FIS BookHub – Gestión de Biblioteca Digital

## Descripción

**FIS BookHub** es un sistema diseñado para modernizar y digitalizar la gestión de una biblioteca universitaria. Este sistema permite a los bibliotecarios registrar libros disponibles, gestionar los préstamos y devoluciones, así como hacer el seguimiento de los usuarios que acceden al servicio. Además, proporciona al administrador de la biblioteca un portal para analizar de manera sencilla los datos del sistema.

## Requerimientos del Sistema

### 📖 Gestión de Libros
Los bibliotecarios pueden registrar libros con los siguientes datos:
- Título
- Autor
- Género
- Año de publicación
- Número de copias disponibles

### 📅 Gestión de Préstamos
Los usuarios (estudiantes y profesores) pueden solicitar el préstamo de libros. Cada préstamo incluye:
- Usuario solicitante: Nombre, Apellido, DNI, Correo, Teléfono, Tipo (Estudiante/Profesor)
- Libro solicitado
- Fecha de préstamo
- Fecha de devolución estimada
- Estado del préstamo (Prestado, Devuelto, Retrasado)

### 🔄 Gestión de Devoluciones
Los bibliotecarios pueden registrar devoluciones y verificar retrasos en las entregas.

### 🛠 Portal de Administrador
Finalmente, el administrador de la biblioteca desea un portal donde pueda analizar de manera sencilla los datos del sistema, incluyendo:

- Cantidad total de libros disponibles
- Cantidad de préstamos activos
- Cantidad de libros devueltos en el último mes
- Lista de usuarios con retrasos en la devolución de libros

## Objetivos del Proyecto

### 1️⃣ Identificar Historias de Usuario
Las historias de usuario permiten identificar los requerimientos del sistema y las funcionalidades clave. Estas historias serán la base para la creación de los "issues" en el proyecto de GitHub.

### 2️⃣ Crear "Issues" de las Historias de Usuario en GitHub
Para cada historia de usuario, se creará un "issue" en el repositorio de GitHub. Cada "issue" debe contener:
- 👤 Persona asignada (Distribución de tareas entre los integrantes del equipo)
- 🏷 Etiqueta
- ⚡ Prioridad
- 📏 Tamaño
- ⏱ Estimación
- 🗓 Sprint
- 🎯 Milestone

### 3️⃣ Implementar la Estructura de Clases del Sistema
El sistema será implementado utilizando una estructura de clases que refleje los objetos clave del sistema como "Libro", "Usuario", "Préstamo", y "Administrador".

### 4️⃣ Uso de Git
- 🧑‍💻 El equipo creará una rama a partir de la rama “Develop” y asignará un nombre relacionado con el equipo.
- 🔄 Cada miembro del equipo desarrollará sus funcionalidades en su propia rama y, una vez completado, realizará un merge a la rama “Develop”.

### 5️⃣ Entrega Final
El equipo entregará un documento detallado que incluya:
- 📂 Gestión de las carpetas del repositorio (Boilerplate)
- 🧩 Gestión de Scrum (Planificación y asignación de tareas)
- 📑 Uso de Git (Flujo de trabajo, ramas, merges)
