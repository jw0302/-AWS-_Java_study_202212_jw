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