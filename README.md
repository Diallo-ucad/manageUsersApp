# Atos technical test
# manageUsersApp  - Spring Boot API
    In this API we can register a user and displays the details of registered user
# A user is defined by:
     user name
     birthdate
    country of residence
# A user has optional attributes:
    phone number
    gender
    
# Only adult French residents are allowed to create an account!
    When we try to create account for not adult french resident
    we will have http error and personalized error message
# Technical description
    
    This API is Springboot API
    Java version: 11
    Gradle
        
#  How to use the API

       Clone this repository
       Open projet in IDE like (Intellij, Eclipse)
       Build projet :
                        With terminal using this command : .\gradlew bootRun 
                        OR 
                        Using IDE build option  
                        
       Open Postman software
       Import collection request samples 
       Choose request and send it

       Enjoy!!
  

# Request samples
    In the "Postman collection" folder there are some samples queries to test the API (create, get all users, get user by id, ...)
    To do this you need to use the "Postaman" software and import the file then run the query
    
    
