# trainAPI

### Prerequisite

1. JDK 1.8 and above

2. PostgreSQL Database

3. Maven

### Configuration

We are configuring some data into demo/src/main/resources/application.properties

1. Database URL for PostgreSQL (spring.datasource.url = <URL_OF_DATABASE>)

2. UserName for Database (spring.datasource.username  <USERNAME_OF_DATABASE>)

3. Password for Database (spring.datasource.password = <PASSWORD_OF_DATABASE>)

4. Application Properties
    app.jwtSecret= <MY_SECRET_KEY_FOR_JWT>
    app.jwtExpirationMs = <EXPIRY_TIME_OF_TOKEN_IN_MS>
    
### Import data to PostgreSQL

We have added import.sql file in demo/src/main/resources/application.properties, it will add those data in your database

### REST APIs

We have 3 endpoints for this application

#### 1. Signup (http://localhost:8080/auth/signup) (POST method)

It will register the user in user table and add the role in user_role table.

Body part Raw JSON
```
{
    "username":"TestUserName",
    "password":"TestPassword",
    "email":"testemail@gmail.con",
    "role":["ADMIN"]
}
```

#### 2. Signin (http://localhost:8080/auth/signin) (POST method)

It will authorized the user with valid credentials. If user gives valid userName and password, this API will return one JWT Bearer token that can be used to hit other APIs

BODY part raw JSON

```
{
    "username": "TestUserName",
    "password": "TestPassword"
}
```

#### 3. Trains (http://localhost:8080/api/trains) (GET method)

This endpoint will give the data of trains based on request. You have to give valid Bearer token to expose this API. If token is not correct or expired, it will give unauthorized response. 

We have some paraeters defined to get the data. Sort, Page, Size. You can sort the data on three columns that is Id, Name and Max-speed. You can also mentioned which page you want from pagination. You can also specify page size. If you are not giving any parameters, It will take default one that is

#### Sort = Id,desc

#### Page = 0

#### size = 3

### Security

For Security, we are converting password to BCrypt Password Encoder. 

