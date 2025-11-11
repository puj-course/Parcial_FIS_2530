# Etapa 1: Construcción
FROM maven:3.9-eclipse-temurin-17 AS build

# Establecer directorio de trabajo
WORKDIR /app

# Copiar archivos de configuración de Maven
COPY pom.xml .

# Descargar dependencias (se cachean si pom.xml no cambia)
RUN mvn dependency:go-offline -B

# Copiar el código fuente
COPY src ./src

# Compilar y empaquetar la aplicación
RUN mvn clean package -DskipTests

# Etapa 2: Imagen de ejecución
FROM eclipse-temurin:17-jre-alpine

# Establecer directorio de trabajo
WORKDIR /app

# Copiar el JAR generado desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Copiar archivos de configuración si son necesarios
COPY conf ./conf

# Crear directorio para datos temporales
RUN mkdir -p /app/temp/temp_data

# Variables de entorno opcionales
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Comando para ejecutar la aplicación
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]