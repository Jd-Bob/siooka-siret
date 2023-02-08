environnement:
- java 17
- mvn 3.6

framework: spring boot, spring cloud config server,
           spring cloud eureka server,
           spring cloud admin server,
           spring cloud configuration server
           spring cloud gateway router
           
architecture: microservice + multi-couches

base de donnees: H2 avec JPA


Chaque microservice peut etre lancer soit
   - soit via jenkins avec la configuration indique dans le capture Screenshot from 2023-02-07 22-36-59.png
   - soit via docker :
         - docker build -t nom-image .
         - docker run -p port-extern:port-intern nom-image
   - soit via java:
         - mvn clean install
         - java -jar target/nom-microservice.0.0.1.SHNAPSHOT.jar --spring.profiles.active=prod
   - soit via mvn spring:run 


veiller respecter l'ordre de lancement des microservices:

1) admin : pour administration des microservices

2) eureka : registre des microservices

3) gateway : proxy pour les microservices. Les requetes sont rediriger vers le microservice adequate avec les headers necessaires et aussi pour raison de securite des microservices.

3) config-server : externaliser les configurations pour que les microservices n'aurons plus besoin de se redemarrer pour chaque modification 	des config.
Les fichiers de configuration se trouve dans github.com:Jd-Bob/siooka-config-data.
A chaque modification, on commit/push et on appel l'api curl http://localhost:8081/actuator/refresh -d {} -H "Content-Type: application/json"

4) siret : api de gestion des sirets.
Testable via http://localhost:8081/api/siret/31302979500017 pour un seul siret depuis server externe
Et via http://localhost:8081/sirets pour les listes dans la base de donnees
http://localhost:8081/h2-ui pour l'apercu de la base de donnee H2 (l'url de la base de donnee est : jdbc:h2:mem:siooka)

