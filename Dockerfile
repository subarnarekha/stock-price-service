FROM openjdk:11-jdk
COPY ./target/stockprice-service-0.0.1-SNAPSHOT.jar stockprice-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=dev", "stockprice-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8743