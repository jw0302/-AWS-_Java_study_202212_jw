/*========================<< select >>========================*/

SELECT * FROM `db_study2_explain`.`student_mst`;

/* 전체 컬럼 조회 */
SELECT
	*
FROM
	student_mst;
    
/* 지정 컬럼 조회 */
SELECT
	student_id,
    student_name,
    mento_id
FROM
	student_mst;
    
/* 임시 컬럼 추가 */
SELECT
	1 as num,
    '김준일' as name;
    
SELECT
	`student_id`,
    `student_name`,
    '김준일' as `instructor_name`
FROM
	student_mst;
    
/* 컬럼명을 임시로 바꾸는 방법 as(alias) 알리아스 <생략 가능하지만 컬럼에는 쓰는게 좋다> */
SELECT
	`sm`.`student_id` as `studentID`
FROM
	`student_mst` `sm`;
    
/* 조회조건 where */
SELECT
	*
FROM
	`student_mst`
WHERE
	`mento_id` = (SELECT
					`mento_id`
				 FROM
					`mento_mst`
				 WHERE
					`mento_name` = '문자영');
    
SELECT
	`student_id`,
    `student_name`,
    `mento_id`,
    (SELECT 
		`mento_name` 
    FROM 
		`mento_mst` 
	WHERE 
		`mento_id` = `student_mst`.`mento_id`) as `mento_name`
FROM
	`student_mst`;
    
/* 그룹으로 묶어서 조회하기 */
SELECT
	count(`mento_id`),
    min(`student_id`),
    max(`student_id`),
    avg(`student_id`),
    sum(`student_id`),
	`mento_id`
FROM
	`student_mst`
GROUP BY
	`mento_id`;
    
/* 중복 제거 (위에 GROUP BY도 중복제거 할수 있지만 GROUP BY만의 역할이 있기 때문에 중복제거는 이거를 쓴다.) */
SELECT DISTINCT
	`mento_id`
FROM
	`student_mst`;

/* 그룹으로 조회한 결과에 조건주는 방법(HAVING : GROUP BY를 쓰고 나서 쓸수 있다.) */
SELECT
	count(`mento_id`) as `mento_count`,
    min(`student_id`),
    max(`student_id`),
    avg(`student_id`),
    sum(`student_id`),
	`mento_id`
FROM
	`student_mst`
GROUP BY
	`mento_id`
HAVING
	`mento_count` = 5;
    
/* 정렬(기본적으론 오름차순 정렬, DESC 쓰면 내림차순 정렬) */
SELECT
	*
FROM
	`student_mst`
ORDER BY
	`mento_id`,
    `student_id` DESC;
    
/* 전체 조합 실습(순서 : from->where->group by->having->select->order by) */
SELECT
	count(*) as `student_count`,
    `mento_id`
FROM
	`student_mst`
WHERE
	`student_id` > 2
GROUP BY
	`mento_id`
HAVING
	`student_count` = 1
ORDER BY
	`mento_id` DESC;

