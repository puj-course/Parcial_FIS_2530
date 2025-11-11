# Etapa 1: compilar y correr tests
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /src
COPY . .
RUN mvn -B -DskipTests=false clean verify

# Etapa 2: imagen ligera de demostración
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /src/target /app/target
CMD ["bash", "-c", "echo 'Imagen generada. Artefactos en /app/target' && ls -la /app/target"]
