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
EXPOSE 8888
ADD ./target/hr-config-server-0.0.1-SNAPSHOT.jar hr-config-server.jar
ENTRYPOINT ["java","-jar","/hr-config-server.jar"]