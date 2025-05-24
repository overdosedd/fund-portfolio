# fund-portfolio

1. The frontend-nextjs contains the front end code using Next Js
2. mutualFundPortfolio contains the backend code using Springboot
3. to set up the db, get the sript from tables.sql run the script to generate the tables in local db

 ##1. Requirements
Java 17+

Maven

Spring Boot 3.x

MariaDB / MySQL

(Optional) Docker

##SpringBoot

 2. Setup Database
 SQL Schema Example (MariaDB/MySQL)
sql
Copy
Edit
CREATE TABLE users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100)
);

CREATE TABLE mutual_funds (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  currency VARCHAR(3)
);

CREATE TABLE fund_positions (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  user_id BIGINT,
  fund_id BIGINT,
  units DECIMAL(18,6),
  cash_amount DECIMAL(18,2),
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (fund_id) REFERENCES mutual_funds(id)
);
3. Configure application.properties
4. insert a login data into the User table. run the generate passwordHashgenerator.java to generate hashpasword. insert data with the hash password to db.
5. Run the Application
./mvnw spring-boot:run

GET http://localhost:8080/api/portfolio/{userId}

##Next js

1. run npm install to install all packages.
2. run npm run dev to start the localhost:3000
3. to login, prior you need to have the logindata set up.
4. login to application you will see the portfolio


Things to improve due to time constraint
1. bug fix for some of the api
2. deploy to AWS through AWS Beanstalk.
3. set up CICD pipeline to aws
   



