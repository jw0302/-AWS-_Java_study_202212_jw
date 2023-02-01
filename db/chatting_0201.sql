INSERT INTO `user_mst`
VALUES (0, 'test', '1234', 'test', 'test@gamil.com');

DELETE
FROM
	`user_mst`
WHERE
	`username` = 'test';
    
CALL `show_all_user_mst`('안녕하세요');