FROM openjdk:17-jdk-slim

WORKDIR /app

# 1. Copia apenas os arquivos necessários para o build
COPY src ./src
COPY pom.xml ./
COPY .mvn ./.mvn
COPY mvnw ./

# 2. Concede permissão de execução ao mvnw
RUN chmod +x mvnw

# 2. Executa o build dentro do container
RUN ./mvnw clean package -DskipTests

# 3. Copia o JAR gerado para um caminho padrão
RUN cp /app/target/*.jar /app/app.jar

# 4. Define o ponto de entrada
ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8080