FROM openjdk:11 as build
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ./mvnw package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:11
VOLUME /tmp
EXPOSE 8765
ADD ./target/hr-zuul-api-0.0.1-SNAPSHOT.jar hr-zuul-api.jar
ENTRYPOINT ["java","-jar","/hr-zuul-api.jar"]