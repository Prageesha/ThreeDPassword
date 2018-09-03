CREATE TABLE text_password (
  user_name VARCHAR(200) NOT NULL PRIMARY KEY,
  password VARCHAR(2000) NOT NULL,
  salt VARCHAR(255) NOT NULL
 );
 
