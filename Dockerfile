# Popular image build-worthy for JDK
FROM eclipse-temurin:17-jdk

# Set images working directory
WORKDIR /app

# Add jar file that contains our build
ADD target/ps-demo-0.0.1-SNAPSHOT.jar ps-demo-0.0.1-SNAPSHOT.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "ps-demo-0.0.1-SNAPSHOT.jar"]

# Run on specific port
EXPOSE 8888