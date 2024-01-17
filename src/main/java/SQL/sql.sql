
CREATE TABLE member(
                       id INT(11) NOT NULL auto_increment,
                       name VARCHAR(255),
                       email VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       create_time datetime DEFAULT current_timestamp(),
                       PRIMARY KEY (id));