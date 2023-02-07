FROM openjdk:17
LABEL maintainer="jean.denis.rafenoarisoa@gmail.com"
COPY siooka.mv.db ./
ADD /target/siret-0.0.1-SNAPSHOT.jar /home/siret-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/home/siret-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod"]