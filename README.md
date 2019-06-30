# Reactive-pizza-rest
Spring Boot - Reactive rest project + MongoDB.
Use the address bellow to test Spring MVC
http://localhost:8090/

to add new pizza document on MongoDB
Method: POST
URL: http://localhost:8090/pizza
JSON Example
{
	"id": "1",
	"nome": "Pizza 1",
	"description": "Pizza 1 Description"
}

to list all:
Method: GET
URL: http://localhost:8090/pizzas

find by id:
Method: GET
URL: http://localhost:8090/pizza/{id}

find by id:
Method: DELETE
URL: http://localhost:8090/pizza/{id}