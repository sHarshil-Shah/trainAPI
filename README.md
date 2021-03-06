# trainAPI

### Check out online
http://65.1.105.69:8081/swagger-ui/

### Public docker image
https://hub.docker.com/r/harshil99/train

### Get it up and running on local device
#### Run following command on terminal
1. sudo yum install docker -y
2. sudo service docker start
3. sudo chmod 666 /var/run/docker.sock
4. docker pull harshil99/train
5. docker run -d -p 8081:8080 harshil99/train



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

Initial data will be loaded via import.sql and init method in DemoApplication

### REST APIs
| Request  | Endpoint | Usability | Purpose |
| ------------- | ------------- | ------------- | ------------- |
| GET  | /api/test/all  | PUBLIC | testing public API |
| GET  | /api/test/user  | ADMIN | check auth |
| POST | /auth/signup | PUBLIC | signup new user|
| POST | /auth/signin | PUBLIC | signin existing user|
| GET | api/trains | ADMIN | get trains list according to params |

Following is description of the main API endpoints for this application

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

It will authorize the user with valid credentials. If user gives valid userName and password, this API will return one JWT Bearer token that can be used to hit other APIs

BODY part raw JSON

```
{
    "username": "TestUserName",
    "password": "TestPassword"
}
```

#### 3. Trains (http://localhost:8080/api/trains) (GET method)

This endpoint will give the data of trains based on request. You have to give valid Bearer token to expose this API. If token is not correct or expired, it will give unauthorized response. 

We have some parameters defined to get the data. Sort, Page, Size. You can sort the data on three columns that is Id, Name and Max-speed. You can also mentioned which page you want from pagination. You can also specify page size. If you are not giving any parameters, It will take default one that is

#### Sort = Id,desc

#### Page = 0

#### size = 3

### Security

For Security, we are converting password to BCrypt Password Encoder. 

### NOTE: Usage of this API can be found in trainAPI.postman_collection.json


# Steps to run the project

1. Unzip trainAPI.zip
2. Open IntelIJ
3. Import Existing Project
4. For the Import project from external model value, select Maven and click Finish.
5. Click on pom.xml and click build
6. Go to <path>\trainAPI\demo\src\main\java\com\train\demo\DemoApplication.java
7. Click on run button next to DemoApplication class (Check screenshot in attched .pdf file)
8. check API connectivity via calling localhost:8080/api/test/all
9. It should return "Public Content."
