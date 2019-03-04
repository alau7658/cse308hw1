/*--------------------------------ACCOUNTS-----------------------*/
/*User 1*/
INSERT INTO account
VALUES('0', 'user1', 'password1');
/*User 2*/
INSERT INTO account
VALUES('0', 'user2', 'password2');
/*User 3*/
INSERT INTO account
VALUES('0', 'user3', 'password3');
/*User 4*/
INSERT INTO account
VALUES('0', 'user4', 'password4');
/*User 5*/
INSERT INTO account
VALUES('0', 'user5', 'password5');
/*User 6*/
INSERT INTO account
VALUES('0', 'newUser', 'newPass');
/*User 7*/
INSERT INTO account
VALUES('0', 'newUser2', 'newPass2');

/*--------------------------------GAMES-----------------------*/
/*GAME 1*/
INSERT INTO game
VALUES('0', 'user1', 'WIN', 'abort', 'plead', curDate());
/*GAME 2*/
INSERT INTO game
VALUES('0', 'user1', DEFAULT, 'adieu', 'pride', DEFAULT);
/*GAME 3*/
INSERT INTO game
VALUES('0', 'user2', DEFAULT, 'hoped', 'rapid', DEFAULT);
/*GAME 4*/
INSERT INTO game
VALUES('0', 'user3', 'LOSE', 'horse', 'quiet', DEFAULT);
/*GAME 5*/
INSERT INTO game
VALUES('0', 'user3', DEFAULT, 'lemon', 'acids', DEFAULT);
/*GAME 6*/
INSERT INTO game
VALUES('0', 'user4', 'WIN', 'words', 'human', DEFAULT);
/*GAME 7*/
INSERT INTO game
VALUES('0', 'user4', 'WIN', 'music', 'front', DEFAULT);
/*GAME 8*/
INSERT INTO game
VALUES('0', 'user4', DEFAULT, 'backs', 'piano', DEFAULT);
/*GAME 9*/
INSERT INTO game
VALUES('0', 'user5', 'WIN', 'crazy', 'tiles', DEFAULT);
/*GAME 10*/
INSERT INTO game
VALUES('0', 'user5', 'LOSE', 'lance', 'baked', DEFAULT);
/*GAME 11*/
INSERT INTO game
VALUES('0', 'user5', DEFAULT, 'spear', 'smile', DEFAULT);
/*GAME 12*/
INSERT INTO game
VALUES('0', 'newUser2', DEFAULT, 'laser', 'drank', DEFAULT);

/* -----------------------------------ROUNDS------------------------------------*/

/*INSERT INTO game
VALUES('0', '1', 'WIN', 'abort', 'plead', curDate()); GAME 1
*/
INSERT INTO round
VALUES ('0', '1' , '1', 'adore', 'price');

INSERT INTO round
VALUES ('0', '1' , '2', 'abore', 'plate');

INSERT INTO round
VALUES ('0', '1' , '3', 'abort', 'plane');

/*INSERT INTO game
VALUES('0', '1', DEFAULT, 'adieu', 'pride', DEFAULT); GAME 2
*/

INSERT INTO round
VALUES ('0', '2' , '1', 'rakes', 'cakes');

/*INSERT INTO game
VALUES('0', '2', DEFAULT, 'hoped', 'rapid', DEFAULT); GAME 3
*/

INSERT INTO round
VALUES ('0', '3' , '1', 'abort', 'plate');

INSERT INTO round
VALUES ('0', '3' , '2', 'happy', 'poppy');

/*INSERT INTO game
VALUES('0', '3', 'LOSE', 'horse', 'quiet', DEFAULT); GAME 4
*/

INSERT INTO round
VALUES ('0', '4' , '1', 'human', 'lakes');

INSERT INTO round
VALUES ('0', '4' , '2', 'haunt', 'quick');

INSERT INTO round
VALUES ('0', '4' , '3', 'store', 'quest');

INSERT INTO round
VALUES ('0', '4' , '4', 'shore', 'quiet');

/*
INSERT INTO game
VALUES('0', '3', DEFAULT, 'lemon', 'acids', DEFAULT); GAME 5
*/

INSERT INTO round
VALUES ('0', '5' , '1', 'pipes', 'lakes');

/*INSERT INTO game
VALUES('0', '4', 'WIN', 'words', 'human', DEFAULT); GAME 6
*/

INSERT INTO round
VALUES ('0', '6' , '1', 'wives', 'hares');

INSERT INTO round
VALUES ('0', '6' , '2', 'words', 'shape');

/*INSERT INTO game
VALUES('0', '4', 'WIN', 'music', 'front', DEFAULT); GAME 7
*/

INSERT INTO round
VALUES ('0', '7' , '1', 'lisps', 'shape');

INSERT INTO round
VALUES ('0', '7' , '2', 'ships', 'drift');

INSERT INTO round
VALUES ('0', '7' , '3', 'mains', 'delta');

INSERT INTO round
VALUES ('0', '7' , '4', 'manic', 'freed');

INSERT INTO round
VALUES ('0', '7' , '5', 'musky', 'freak');

INSERT INTO round
VALUES ('0', '7' , '6', 'music', 'froze');

/*INSERT INTO game
VALUES('0', '4', DEFAULT, 'backs', 'piano', DEFAULT); GAME 8
*/
INSERT INTO round
VALUES ('0', '8' , '1', 'brats', 'loved');

INSERT INTO round
VALUES ('0', '8' , '2', 'bears', 'ready');

INSERT INTO round
VALUES ('0', '8' , '3', 'beaks', 'prize');
/*
INSERT INTO game
VALUES('0', '5', 'WIN', 'crazy', 'tiles', DEFAULT); GAME 9
*/
INSERT INTO round
VALUES ('0', '9' , '1', 'crazy', 'masks');
/*
INSERT INTO game
VALUES('0', '5', 'LOSE', 'lance', 'baked', DEFAULT); GAME 10
*/

INSERT INTO round
VALUES ('0', '10' , '1', 'break', 'lived');

INSERT INTO round
VALUES ('0', '10' , '2', 'leaps','bread');

INSERT INTO round
VALUES ('0', '10' , '3', 'beaks', 'bleed');

INSERT INTO round
VALUES ('0', '10' , '4', 'dance', 'baked');

/*
INSERT INTO game
VALUES('0', '5', 'DEFAULT', 'spear', 'smile', DEFAULT); GAME 11
*/
INSERT INTO round
VALUES ('0', '11' , '1', 'mails', 'pesto');
INSERT INTO round
VALUES ('0', '11' , '2', 'rails', 'lasso');

/*INSERT INTO game
VALUES('0', '7', 'DEFAULT', 'laser', 'drank', DEFAULT); GAME 12
*/

INSERT INTO round
VALUES ('0', '12' , '1', 'music', 'trims');
INSERT INTO round
VALUES ('0', '12' , '2', 'anvil', 'prize');
INSERT INTO round
VALUES ('0', '12' , '3', 'lairs', 'press');
INSERT INTO round
VALUES ('0', '12' , '4', 'lease', 'dress');

