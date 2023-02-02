SHOW VARIABLES LIKE 'AUTOCOMMIT';			
SET `autocommit` = 0;

START TRANSACTION;

SAVEPOINT `sp3`;

INSERT INTO `user_mst`
VALUES (0, 'jjj', '1234', '김준일', 'jjj@gmail.com');

SELECT * FROM `user_mst`;

ROLLBACK TO `sp1`;

COMMIT;
