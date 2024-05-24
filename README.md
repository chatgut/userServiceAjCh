# userServiceAjCh
User Service 

This is a micro service built for Chatgut, a ITHS project.
The user service is built with Springboot and using MySQL.
Runs on port 8087 and the MySQL database runs on port 3306.

This user service allows you to:
Get all users 
Get user by id
Update an user
Delete an user

How to get started:
Clone the repository: 
https://github.com/chatgut/userServiceAjCh.git
 
Run the command:
docker compose up
 
Endpoints:
 
The following endpoints are available:
Get requests:
Get all users 
GET http://localhost:8087/users
 
Get user by id
GET http://localhost:8087/user/{id}
 
Post requests:
Create a user based on JSON.
POST http://localhost:8087/user
 
Example JSON:
{
"userName": "JaneDoe", "imageUrl" : "123.cat"
}
 
Put requests:
Update a user by id, in JSON format.

PUT http://localhost:8087/user/{id}
 
Example JSON:
{
"userName": "JaneDoe", "imageUrl" : "123.cat"
}
 
 
Delete request
Delete a user by id.
 
Delete http://localhost:8087/user/{id}
