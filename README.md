# CijferSchrijver

This is a portfolio project to demonstrate knowledge of PostgreSQL, Java 8, Jakarta Persistence (JPA), and ReactJS.

In order to start the web application, which is at the moment split into backend and frontend code: follow the instructions below.


# Preparing the database
	createuser -P portfolio_cs
	createdb -O portfolio_cs portfolio_cs


# Preparing the application
After creating a user and a database, change ```src/main/resources/application.properties``` so that it contains these lines:

	spring.datasource.url=jdbc:postgresql://localhost:5432/portfolio_cs
	spring.datasource.username=portfolio_cs
	spring.datasource.password=portfolio_cs
	


# Running the ReactJS application
	cd src/main/frontend/
	npm install
	npm run

# Running the Spring application
In the top level directory, run:
	mvn spring-boot:run

The web application should now be reachable at http://localhost:3000/
