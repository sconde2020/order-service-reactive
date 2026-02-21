# Order Service Reactive (WebFlux + MongoDB + Kafka)

Démo d’un service réactif basé sur **Spring WebFlux** avec **MongoDB** et **Kafka**, incluant **Swagger/OpenAPI**, **Actuator** et **DevTools**.

## Stack
- Java 21
- Spring 4
- Spring WebFlux
- MongoDB (réactif)
- Kafka (réactif)
- Swagger / OpenAPI
- Spring Boot Actuator
- Spring Boot DevTools

## Fonctionnalités
- API REST réactive (WebFlux)
- Persistance réactive avec MongoDB
- Publication/consommation d’événements via Kafka
- Documentation API via Swagger/OpenAPI
- Monitoring via Actuator
- Reload rapide en dev via DevTools

## Démarrage rapide
1. Démarrer MongoDB et Kafka.
2. Lancer l’application : `./mvnw spring-boot:run`
3. Vérifier que l’API et les endpoints sont exposés.

## Swagger / OpenAPI
- UI Swagger disponible via l’endpoint OpenAPI/Swagger configuré dans le projet.
- Permet d’explorer et tester les endpoints réactifs.
- URL Swagger UI : <http://localhost:8080/swagger-ui/index.html>
- URL OpenAPI JSON : <http://localhost:8080/v3/api-docs>

## Actuator
- Endpoints de santé et métriques accessibles via les endpoints Actuator.
- Utiliser pour vérifier l’état du service et la connectivité (MongoDB/Kafka).
- URL Actuator : <http://localhost:8080/actuator>
- URL Health : <http://localhost:8080/actuator/health>

## DevTools
- Active le redémarrage rapide et le rechargement des ressources en développement.
- À utiliser uniquement en environnement local.

## Notes
- Ce projet illustre un flux réactif complet : HTTP → MongoDB → Kafka.
- Adapter la configuration (URI MongoDB, brokers Kafka, ports) selon votre environnement.
