FROM openjdk:16
ADD build/libs/grade-0.0.1-SNAPSHOT.jar faketunes.jar
ENTRYPOINT ["java", "-jar", "/faketunes.jar"]