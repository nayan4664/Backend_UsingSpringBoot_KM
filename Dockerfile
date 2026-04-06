FROM maven:3.9-eclipse-temurin-17
WORKDIR /app
COPY . .

# Build
RUN mvn clean package -DskipTests

# Run
CMD ["sh", "-c", "java -jar target/*.jar"]