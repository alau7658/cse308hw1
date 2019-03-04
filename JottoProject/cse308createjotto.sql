
CREATE TABLE Account (
	id INTEGER AUTO_INCREMENT,
    username CHAR(255) NOT NULL UNIQUE,
    password CHAR(255) NOT NULL ,
    PRIMARY KEY (ID) );
    
CREATE TABLE Game(
	game_id INTEGER AUTO_INCREMENT,
	username CHAR(255),
    game_state VARCHAR (30) DEFAULT 'INCOMPLETE' NOT NULL,
	user_word CHAR(5) NOT NULL,
    cpu_word CHAR(5) NOT NULL, 
    date_created DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY (game_id),
    FOREIGN KEY (username) REFERENCES Account (username)
		ON DELETE NO ACTION
        ON UPDATE CASCADE);

CREATE TABLE Round (
	round_id INTEGER AUTO_INCREMENT,
    game_id INTEGER,
	round_number INTEGER NOT NULL,
    user_guess CHAR(5) NOT NULL,
    cpu_guess CHAR(5) NOT NULL,
    PRIMARY KEY (round_id),
	FOREIGN KEY (game_id) REFERENCES Game (game_id)
		ON DELETE NO ACTION
        ON UPDATE CASCADE);
	
    
	