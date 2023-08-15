# "REST API" SpringBoot/Java 
This is a simple User Management with Spring boot and java that have two services: 
* Register adult French residents users
* Displays the details of a registered user

## How to Run

* Clone this repository 
* Make sure you are using Maven 3.x  and SDK 17
* You can Run the project by the main Class : 
```
src.main.java.com.usrmngt.usermanagement.UserManagementApplication
```
* You can Run the project tests by the main Class : 
```
src.test.java.com.usrmngt.usermanagement.UserManagementApplicationTests
```


## About the DataBase

To test the application, i use a H2 DataBase to store data when the API work.  
```
More information about H2 DataBase :
* H2 database relies on system memory for loading and persisting the data. 
* In memory databases are very fast as the data access is done from System memory,
* They are volatile
```

## More informations 
When you launch the API, you will already cross 4 users stored in the database, the fact that makes it easier for us to do the tests afterwards. 

sample code :
```
for (int i=0 ; i<4 ; i++){
            listUser.add(new User("Ahmed"+i, LocalDate.of(1998,3,9),"France","003312345678","Male"));
        }
```

## Utilisations Postman

### Register a User 
```
POST : http://localhost:8080/api/users/register
{
    "username": "Dupond",
    "birthdate": "2000-01-01",
    "country": "France",
    "phonenumber": "003312345678",
    "gender": "Male"
}
RESPONSE: HTTP 201 (CREATED)
```

### Display All users 
```
GET : http://localhost:8080/api/users
```

Using this on postman will show you all users registered in the database

### Display user by ID
```
GET : http://localhost:8080/api/users/1
```
Using this on postman will show you the user with id "1" in the database

### Display user by username
```
GET : http://localhost:8080/api/users?username=Ahmed1
```
Using this on postman will show you the user with username "Ahmed1" in the database

## EXCEPTION

in this API REST, there is 4 kind of exception :

### Not Adult user

```
POST : http://localhost:8080/api/users/register
{
    "username": "Dupond",
    "birthdate": "2022-01-01",
    "country": "france",
    "phonenumber": "003312345678",
    "gender": "Male"
}
RESPONSE: HTTP 400 (BAD_REQUEST)
```
Message d'exception afficher :
```
You need to be an adult to create an account
```

### Not france user
```
POST : http://localhost:8080/api/users/register
{
    "username": "Dupond",
    "birthdate": "2000-01-01",
    "country": "USA",
    "phonenumber": "003312345678",
    "gender": "Male"
}
RESPONSE: HTTP 400 (BAD_REQUEST)
```
Message d'exception afficher :
```
Only french resident are allowed to create an account
```
### User not found in the database
```
GET : http://localhost:8080/api/users/66
RESPONSE: HTTP 404 (NOT_FOUND)
```
Message d'exception afficher :
```
this user is not found in our database
```


### User with username already exist in the database
```
POST : http://localhost:8080/api/users/register
RESPONSE: HTTP 400 (BAD_REQUEST)
```
Message d'exception afficher :
```
UserName already exist
```
