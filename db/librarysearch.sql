SELECT * FROM db_study3.library_mst;

/* ======================= 저작자 ============================= */

INSERT INTO `author_mst` 
   (`author_name`)
SELECT DISTINCT
   `저작자`
FROM 
   `library_mst`
ORDER BY
   `저작자`;
    
SELECT * FROM `author_mst`;

/* ===================== 출판사 ============================ */

INSERT INTO `publisher_mst`
   (`publisher_name`)
SELECT DISTINCT
   `출판사`
FROM
   `library_mst`
ORDER BY
   `출판사`;
    
SELECT * FROM `publisher_mst`;

SELECT * FROM `library_mst`;

UPDATE `library_mst` , `author_mst` 
SET 
   `저작자` = `author_id`
WHERE 
   `저작자` = `author_name`;
   
UPDATE `library_mst` , `publisher_mst`
SET 
   `출판사` = `publisher_id`
WHERE 
   `출판사` = `publisher_name`;
   
SELECT
	*
FROM
	`library_mst` `lm`
    LEFT OUTER JOIN `book_mst` `bm` ON(`bm`.`book_id` = `lm`.도서명)
    LEFT OUTER JOIN `author_mst` `am` ON(`am`.`author_id` = `lm`.저작자)
    LEFT OUTER JOIN `publisher_mst` `pm` ON(`pm`.`publisher_id` = `lm`.출판사)
ORDER BY
	`am`.`author_id`;
    
INSERT INTO `book_mst`
   (`book_name`)
SELECT DISTINCT
   `도서명` 
FROM
   `library_mst`
ORDER BY
   `도서명`;
   
SELECT * FROM `book_mst`;

UPDATE `library_mst` , `book_mst` 
SET 
   `도서명` = `book_id`
WHERE 
   `도서명` = `book_name`;
   
/*================================================================*/

SELECT * FROM `library_mst`;

SELECT 
	`도서관명`, `book_name`
FROM 
	`library_mst` `lm`
	LEFT OUTER JOIN `book_mst` `bm` ON(`bm`.`book_id`= `lm`.`도서명`)
    LEFT OUTER JOIN `author_mst` `am` ON(`am`.`author_id` = `lm`.`저작자`)
WHERE
	`author_name` LIKE '김주%';
    
    
        
    
SET profiling = 1;
SET profiling_gistory_size = 30;

SELECT
	`도서관명`,
    `도서명`
FROM
	`library_mst`
WHERE
	`저작자` IN (SELECT 
					`author_id` 
			  FROM 
					`author_mst` 
			  WHERE 
					`author_name` LIKE '%김주%'
              OR    `author_name` LIKE '%김민%');
    
SELECT
	`도서관명`,
    `도서명`
FROM
	`library_mst` `lm`
    LEFT OUTER JOIN `author_mst` `am` ON(`am`.`author_id` = `lm`.`저작자`)
WHERE
	`am`.`author_name` LIKE '%김주%';
    
/*    
SELECT
	`도서관명`,
    `도서명`
FROM
	`library_mst`
WHERE
	저작자 > 100
AND 저작자 < 110

UNION ALL
*/    

    


    
