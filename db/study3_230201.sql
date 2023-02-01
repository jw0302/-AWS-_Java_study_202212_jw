CALL `insert_product`('아이패드 프로');

SELECT
	*
FROM
	`library_view`;
    
CREATE VIEW `library_view` AS
SELECT
	ROW_NUMBER() OVER(PARTITION BY `도서관명` ORDER BY `도서관명`) AS `도서관순번`,
	`도서관명`
FROM
	`library_mst`
GROUP BY
	`도서관명`;