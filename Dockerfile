# Usar Eclipse Temurin como imagen base (Java 17)
FROM eclipse-temurin:17-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Instalar Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Build del proyecto
RUN mvn clean install

# Ejecutar la aplicación
CMD ["java", "-jar", "target/your-app.jar"]
