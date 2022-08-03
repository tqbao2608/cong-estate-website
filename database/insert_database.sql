use springbootweb;

insert into role(code,name) values('ADMIN','Quản trị hệ thống');
insert into role(code,name) values('USER','người dùng');

insert into users(username,password,fullname,status)
values('admin','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','admin',1);
insert into users(username,password,fullname,status)
values('nguyenvana','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyen van a',1);
insert into users(username,password,fullname,status)
values('nguyenvanb','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyễn văn b',1);
insert into users(username,password,fullname,status)
values('nguyenvanc','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyễn văn c',1);

INSERT INTO user_role(user_id,role_id) VALUES (1,1);
INSERT INTO user_role(user_id,role_id) VALUES (2,2);
INSERT INTO user_role(user_id,role_id) VALUES (3,2);
INSERT INTO user_role(user_id,role_id) VALUES (4,2);

INSERT INTO `springbootweb122021`.`building` (`district`, `floorarea`, `name`, `numberofbasement`, `rentprice`,
`rentpricedescription`, `street`, `type`, `ward`) VALUES ('QUAN_1', '500', 'Nam Gia BuildingTower', '2', '15',
'15 triệu/m2', '59 Phan Xích Long', 'TANG_TRET, NGUYEN_CAN', 'Phường 2');

INSERT INTO `springbootweb122021`.`building`
(`district`, `floorarea`, `name`, `numberofbasement`, `rentprice`,
 `rentpricedescription`, `street`, `type`, `ward`)
VALUES ('QUAN_2', '650', 'ACM Tower', '2', '18',
        '18 triệu/m2', '96 Cao Thắng', 'NGUYEN_CAN', 'Phường 4');

INSERT INTO `springbootweb122021`.`building`
(`district`, `floorarea`, `name`, `numberofbasement`, `rentprice`,
 `rentpricedescription`, `street`, `type`, `ward`)
VALUES ('QUAN_1', '200', 'Alpha 2 Building Tower', '1', '20',
        '20 triệu/m2', '153 Nguyễn Đình Chiểu', 'NOI_THAT', 'Phường 6');

INSERT INTO `springbootweb122021`.`building`
(`district`, `floorarea`, `name`, `numberofbasement`, `rentprice`,
 `rentpricedescription`, `street`, `type`, `ward`)
VALUES ('QUAN_4', '200', 'IDD 1 Building', '1', '12',
        '12 triệu/m2', '111 Lý Chính Thắng', 'TANG_TRET, NGUYEN_CAN, NOI_THAT', 'Phường 7');

INSERT INTO `springbootweb122021`.`assignmentbuilding` (`building_id`, `staff_id`) VALUES ('1', '2');
INSERT INTO `springbootweb122021`.`assignmentbuilding` (`building_id`, `staff_id`) VALUES ('1', '3');
INSERT INTO `springbootweb122021`.`assignmentbuilding` (`building_id`, `staff_id`) VALUES ('3', '2');
INSERT INTO `springbootweb122021`.`assignmentbuilding` (`building_id`, `staff_id`) VALUES ('4', '3');







