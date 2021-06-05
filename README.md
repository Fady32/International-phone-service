# Solution About

Developing a REST microservice that list and categorize country phone numbers

The response data include fields:
- State
- Country Name


# Used Technologies:
- Spring Boot Framework
- Sqlite DB  
- Java 11
- MapStruct  
- Angular JS

# Run: 

- use command : mvn spring-boot:run 
- open browser with url http:localhost:8080/ 
  it will redirect to Index page that list all stored phones with validated state.
  
- OR run the docker file using the DockerFile: 
 1- docker build --tag=docker-phone-service:latest
 2- docker run -p 8080:8080 docker-phone-service:latest
  
# UI: 

- By default, the Phone Numbers are grouped by Country Name.
- Filter and sorting are allowed for each Field in the Grid. 
  
  
