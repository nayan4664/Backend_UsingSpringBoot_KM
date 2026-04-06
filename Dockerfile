FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY . .

# ✅ ADD THIS LINE (IMPORTANT FIX)
RUN chmod +x mvnw

# Build
RUN ./mvnw clean package -DskipTests

# Run
CMD ["sh", "-c", "java -jar target/*.jar"]