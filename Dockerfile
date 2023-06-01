#1. zaciągnięcie obrazu bazowego
FROM openjdk:1-alpine

#2. wkopiowanie własnego pliku jar
COPY /target/shopmvc*.jar shopmvc.jar

#3. wskazanie punktu startu aplikacji
ENTRYPOINT ["java","-jar","shopmvc.jar"]
