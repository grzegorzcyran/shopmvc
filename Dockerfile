#1. zaciągnięcie obrazu bazowego
FROM openjdk:11

#2. wkopiowanie własnego pliku jar
COPY /target/shopmvc*.jar shopmvc.jar

#3. wskazanie punktu startu aplikacji
ENTRYPOINT ["java","-jar","shopmvc.jar"]
