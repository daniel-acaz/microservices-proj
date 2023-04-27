FROM openjdk:11 as build
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ./mvnw -f pom.xml clean package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:11
VOLUME /tmp
COPY --from=build /app/target/hr-worker.jar /usr/local/lib/hr-worker.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/hr-worker.jar"]
