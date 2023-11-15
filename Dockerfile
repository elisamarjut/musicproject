#
# Mvn Build
#
FROM maven:3.8.6-eclipse-temurin-17-focal AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Jar Package
#
FROM eclipse-temurin:17-jre-focal
# StudentListSecureDB-0.0.1-SNAPSHOT.jar  = <artifactId>-<version>.jar (pom.xml)
COPY --from=build /home/app/target/music-0.0.1-SNAPSHOT.jar /usr/local/lib/music.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/music.jar"]