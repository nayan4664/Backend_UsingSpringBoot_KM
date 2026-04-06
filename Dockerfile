FROM eclipse-temurin:21-jdk
WORKDIR /app

# Install Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

COPY pom.xml .
COPY src ./src

# Build
RUN mvn clean package -DskipTests

# Run
CMD ["sh", "-c", "java -jar target/*.jar"]