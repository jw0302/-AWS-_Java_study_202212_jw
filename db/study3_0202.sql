/*library_mst 수업내용*/
SELECT
	`순번`,
    `도서관명`,
    `구분`,
    `도서명`,
    `저작자`,
    `출판사`,
    `발행연도`,
    CASE
		WHEN `발행연도` IS NULL THEN '2050'
        WHEN `발행연도` = '' THEN '2090'
        ELSE `발행연도`
	END AS `발행연도1`,
    
    IF(ifnull(`발행연도`, '') = '', '2023', `발행연도`) AS `발행연도2`,
    nullif(`발행연도`, '') AS `발행연도3`,
    IF(`청구기호` = '', '기호없음', `청구기호`) AS `청구기호`
FROM
	`library_mst`
WHERE
	-- `발행연도` LIKE '1_';
    -- `발행연도` IS NULL;
    -- `발행연도` IS NOT NULL;
    -- `발행연도` != '';
    NOT `발행연도` = '';
    
UPDATE `library_mst`
SET
	`발행연도` = ''
WHERE
	`발행연도` = '2009';
    
/*product_mst 수업내용*/

SELECT * FROM db_study3.product_mst;

CREATE INDEX product_id ON product_mst(product_code);

SHOW INDEX FROM product_mst;

ALTER TABLE product_mst
ADD UNIQUE product_name(product_name);

ALTER TABLE product_mst
DROP INDEX product_id1;

-- SELECT 
-- 	`library_mst`.`도서명`,
--     `book_mst`.`book_id`
-- FROM 
-- 	`library_mst`
-- JOIN `book_mst` ON `library_mst`.`도서명` = `book_mst`.`book_name`;

/*book_id값으로 들어가 있던 도서명을 book_name값으로 바꾸고 싶을때*/ 
UPDATE library_mst										-- 이 명령문은 library_mst 테이블을 업데이트 하겠다는 의미입니다. 
SET 도서명 = (											-- 이 명령문은 library_mst 테이블의 도서명 열을 지정하겠다는 의미입니다. 
	SELECT book_name 									-- 이 명령문은 book_mst 테이블에서 book_name 을 선택하겠다는 의미입니다.
	FROM book_mst									 	-- 이 명령문은 book_mst 테이블에서 데이터를 가져올 것이라는 의미입니다.
	WHERE book_mst.book_id = library_mst.도서명);			-- 이 명령문은 book_mst의 book_id열이 library_mst의 도서명 열과 같은 행만을 선택하겠다는 의미입니다.