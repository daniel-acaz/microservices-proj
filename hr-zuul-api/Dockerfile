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
EXPOSE 8765
COPY --from=build /app/target/hr-zuul-api.jar /usr/local/lib/hr-zuul-api.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/hr-zuul-api.jar"]