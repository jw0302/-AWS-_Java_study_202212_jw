INSERT INTO `user_mst`
VALUES (0, 'aaab', '1234', '장진원', 'aaab@gmail.com');

SELECT * FROM `user_mst`;

SELECT
	`um`.`user_id`,
	`um`.`username`,
	`um`.`password`,
	`um`.`name`,
    `um`.`email`,
	`rd`.`role_id`,
	`rm`.`role_name`
FROM
	`user_mst` `um`
    LEFT OUTER JOIN `role_dtl` `rd` ON(`rd`.`user_id` = `um`.`user_id`)
    LEFT OUTER JOIN `role_mst` `rm` ON(`rm`.`role_id` = `rd`.`role_dtl_id`);
    
SELECT 
	um.user_id,
    um.username,
    um.password,
    um.name,
    um.email,
    rd.role_dtl_id,
    rd.role_id,
    rd.user_id,
    rm.role_id,
    rm.role_name
FROM
	user_mst um
    LEFT OUTER JOIN role_dtl rd ON(rd.user_id = um.user_id)
    LEFT OUTER JOIN role_mst rm ON(rm.role_id = rd.role_id);
    
SELECT
	*
FROM
	`user_mst` `um`
    LEFT OUTER JOIN `role_dtl` `rd` ON(`rd`.`user_id` = `um`.`user_id`);
	
    
    
    
    