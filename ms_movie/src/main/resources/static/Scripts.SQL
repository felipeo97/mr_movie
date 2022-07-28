CREATE TABLE TUsers (
                        id SERIAL ,
                        name VARCHAR(100) NOT NULL ,
                        lastName VARCHAR(100) NOT NULL ,
                        PRIMARY KEY (id));

CREATE TABLE TMovies(
                        id SERIAL ,
                        title VARCHAR(100) NOT NULL ,
                        director VARCHAR(100) NOT NULL ,
                        rating INT NOT NULL ,
                        PRIMARY KEY (id));

CREATE TABLE TShowTimes (
                            id SERIAL ,
                            date DATE NOT NULL ,
                            PRIMARY KEY (id)) ;

CREATE TABLE TBookings (
                           id SERIAL ,
                           userId INT NOT NULL ,
                           showTimeId INT NOT NULL ,
                           PRIMARY KEY (id)) ;