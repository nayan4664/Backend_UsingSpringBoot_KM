FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY . .

# Build
RUN mvn clean package -DskipTests

# Run
CMD ["sh", "-c", "java -jar target/*.jar"]