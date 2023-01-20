/*
	DML
    C: insert / into	데이터추가 
    R: select / from	데이터 조회 
    U: update / set		데이터 수정
    D: delete / from	데이터 삭제 
*/

/*=======================<< insert >>==========================*/

select * from student_mst;

insert into student_mst 
	(student_id, 	student_name, 	mento_id)
values 
	(5, 			'이강용', 		10),
	(6, 			'김준경', 		10),
	(7, 			'이현수', 		10),
	(8, 			'정의현', 		10);
    
/**/

select * from university_mst;

insert into university_mst
	(university_id, university_name)
	values
    (4,'서울대'),
    (5,'경상대'),
    (6,'부산대'),
    (7,'부산대'),
    (8,'부산대');
    
/*========================<< update >>================================*/

select * from student_mst;

update student_mst
set
	student_name = '김재영',
	mento_id = 15
where
	student_id = 5;
    
/* 멘토 아이디가 10인 학생들의 멘토 아이디를 1로 바꿔라 */

UPDATE student_mst
SET
	mento_id = 1
WHERE
	mento_id = 10;
    
SELECT * FROM student_mst;

/*========================<< delete >>================================*/

DELETE
FROM
	student_mst
WHERE
	student_id = 4
AND student_name = '손지호';

DELETE
FROM
	university_mst
WHERE
	university_id = 6;
    
SELECT * FROM university_mst; 



    