FROM maven:3.9.6-eclipse-temurin-22-alpine as build


COPY src /app/src
COPY pom.xml /app


RUN mvn -f /app/pom.xml clean package -DskipTests --batch-mode
RUN mkdir -p /app/target/dependency && (cd /app/target/dependency; jar -xf ../*.jar)


FROM eclipse-temurin:22-jre-alpine


ENV SPRING_DATASOURCE_URL=jdbc:mysql://mysql-container:3306/userservicedatabase
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update
ENV SPRING_JPA_PlATFORM=mysql


COPY --from=build /app/target/dependency/BOOT-INF/lib /app/lib
COPY --from=build /app/target/dependency/META-INF /app/META-INF
COPY --from=build /app/target/dependency/BOOT-INF/classes /app


ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.example.UserServiceAjCh.UserServiceAjChApplication"]