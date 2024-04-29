FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/Online-Food-Ordering-0.0.1-SNAPSHOT.jar Online-Food-Ordering.jar
EXPOSE 5454
ENTRYPOINT [ "java","-jar","Online-Food-Ordering.jar" ]