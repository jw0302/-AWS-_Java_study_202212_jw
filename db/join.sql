SELECT
	*
FROM
	`library_mst`;
    
SELECT
	*
FROM
	`author_mst`;
    
SELECT
	`순번`,
    `도서관명`,
    `구분`,
    `도서명`,
    `저작자`,
    (SELECT `author_name` FROM `author_mst` WHERE `author_id` = `저작자`) AS `저작자명`,
    `출판사`,
    (SELECT `publisher_name` FROM `publisher_mst` WHERE `publisher_id` = `출판사`) AS `출판사명`,
    (SELECT `publisher_year` FROM `publisher_mst` WHERE `publisher_id` = `출판사`) AS `출판사설립일`,
    `발행연도`,
    `청구기호`
FROM
	`library_mst`;
    
/*==================================================================================================*/

INSERT INTO `library_mst`
VALUES (0, '테스트도서관', '999(테스트)', '테스트도서명', '9999', '9999', '2023', '999.9-테99ㅌ');

SET PROFILING = 1;
SET PROFILING_HISTORY_SIZE = 30;

SELECT
	`lm`.`순번`,
    `lm`.`도서관명`,
    `lm`.`구분`,
    `lm`.`도서명`,
    `lm`.`출판사`,
    `pm`.`publisher_name`,
    `pm`.`publisher_year`
FROM
	`library_mst` `lm`
    LEFT OUTER JOIN `publisher_mst` `pm` ON(`pm`.`publisher_id` = `lm`.`출판사`)
ORDER BY
	`lm`.`순번` DESC;
    
SHOW PROFILES;
    
    


    
    