#FROM docker.io/maven:3.6.3-jdk-11 as stage1
FROM registry.access.redhat.com/ubi8/openjdk-11 as stage1
COPY . .
RUN mvn package
RUN ls -l
RUN pwd

FROM registry.access.redhat.com/ubi8/openjdk-11
COPY --from=stage1 /home/jboss/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.jar" ]
