# Small portfolio

For this back-end portfolio I will present a small inventory project made with spring boot.

## A little presentation

Hi, I'm Byron Bravo, Software Developer, almost 4 years ago. I have managed to acquire a lot of experience from various companies, for example the banking sector with languages ​​such as Java, Golang, cloud platforms, mobile developments etc ... what else can I tell ... I really like learning new things and being able to capture that knowledge.let's continue with my portfolio

PD:I am from Chile, my native language is Spanish and I decided to do all my projects in English, since now my apologies if you find any inconsistency with my English, I am working to improve it

## Technological stack

    * Java 11
    * Maven 3.6 ^
    * Swagger
    * Spring Boot 2.5.4
    * JPA(Named Parameters,Native Query)
    * Docker(For DB and JAR)
    * Postgrest

## Step by Step

### DB

For the database we use a postgres server orchestrated by docker.
I leave the link here -> [https://hub.docker.com/_/postgres]

* Once the container has been deployed and configured (watch out for the key) ... First create a database called commander and within it a schema name it inventory.

* Second, run the table creation script located [./commander-micro-inventory/docs/scripts].

### The server

* Put the password that you created for the db in the application.properties file just in the configuration of **commander.datasource.password**
* Compile project from folder **commander-micro-inventory** with the following command ***mvn  clean install***
* Run the service from folder **commander-micro-inventory** with the command ***mvn clean spring-boot:run***
* At this point, if everything is ok, you can see the swagger of the service at *localhost:8080*
* Play with the service

