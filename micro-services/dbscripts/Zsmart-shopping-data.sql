USE `smart_shopping` ;

select * from user;

insert into user(us_id,us_first_name,us_last_name,us_age,us_gender,us_contact_number,us_user_id,us_password,us_user_type,us_status,us_secret_question_1,us_secret_answer_1,us_secret_question_2,us_secret_answer_2,us_secret_question_3,us_secret_answer_3,us_reward_points)
 values('1', 'Admin', 'Admin', '30', 'Male', '1111111111', 'admin', '$2a$10$iRI4oISXx8APJNlj7i9/JO5oaGtKNztI3cuXOvtSs7jhHOJ/nlSOS', 'O', 'A', 'What is your favorite book', 'Robotics', 'What is your lucky item', 'Cake', 'What is your favorite movie', 'kingkong','0');

insert into user(us_id,us_first_name,us_last_name,us_age,us_gender,us_contact_number,us_user_id,us_password,us_user_type,us_status,us_secret_question_1,us_secret_answer_1,us_secret_question_2,us_secret_answer_2,us_secret_question_3,us_secret_answer_3,us_reward_points)
 values('2', 'customer', 'customer', '30', 'Male', '1111111112', 'c1', '$2a$10$iRI4oISXx8APJNlj7i9/JO5oaGtKNztI3cuXOvtSs7jhHOJ/nlSOS', 'U', 'A', 'What is your favorite book', 'Robotics', 'What is your lucky item', 'Cake', 'What is your favorite movie', 'kingkong','0');


insert into user(us_id,us_first_name,us_last_name,us_age,us_gender,us_contact_number,us_user_id,us_password,us_user_type,us_status,us_secret_question_1,us_secret_answer_1,us_secret_question_2,us_secret_answer_2,us_secret_question_3,us_secret_answer_3,us_reward_points)
 values('3', 'shop', 'manager', '30', 'Male', '1111111113', 'a1', '$2a$10$iRI4oISXx8APJNlj7i9/JO5oaGtKNztI3cuXOvtSs7jhHOJ/nlSOS', 'A', 'P', 'What is your favorite book', 'Robotics', 'What is your lucky item', 'Cake', 'What is your favorite movie', 'kingkong','0');

insert into user(us_id,us_first_name,us_last_name,us_age,us_gender,us_contact_number,us_user_id,us_password,us_user_type,us_status,us_secret_question_1,us_secret_answer_1,us_secret_question_2,us_secret_answer_2,us_secret_question_3,us_secret_answer_3,us_reward_points)
 values('4', 'shop', 'manager', '30', 'Male', '1121111113', 'a2', '$2a$10$iRI4oISXx8APJNlj7i9/JO5oaGtKNztI3cuXOvtSs7jhHOJ/nlSOS', 'A', 'A', 'What is your favorite book', 'Robotics', 'What is your lucky item', 'Cake', 'What is your favorite movie', 'kingkong','0');


INSERT into `smart_shopping`.`product` values (1,'Spoon',1,'Milton','1','15','50','2019-03-15','1','1','2017-05-24','2020-4-9','https://images.unsplash.com/photo-1567807951157-76af61943dfe?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (2,'Plate',1,'Milton','1','150','50','2019-03-15','1','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1499028203764-8669cfd05719?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (3,'Bottle',1,'Milton','1','50','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1544003484-3cd181d17917?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (4,'Tumbler',1,'Milton','1','70','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1549124785-1c1c62a24388?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (5,'Pressure Cooker',1,'Milton','1','1000','50','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1544233726-9f1d2b27be8b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (6,'Garlic Bread',2,'Bakers Fresh','1','70','20','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1573140401552-3fab0b24306f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (7,'Fruit Jam',2,'Bakers Fresh','1','50','30','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1471943311424-646960669fbc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (8,'Cupcakes',2,'Bakers Fresh','1','25','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1465254596705-1ef61f93878c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (9,'Cookies',2,'Bakers Fresh','1','30','50','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1558961363-fa8fdf82db35?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (10,'Homemade chocolate',2,'Bakers Fresh','1','70','10','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1551529674-48920e9b835b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (11,'Orange',3,'Farm Fresh','1','150','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1547514701-42782101795e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (12,'Apple',3,'Farm Fresh','1','150','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1560806887-1e4cd0b6cbd6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (13,'Potato',3,'Farm Fresh','1','150','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1518977676601-b53f82aba655?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (14,'Dragon Fruit',3,'Farm Fresh','1','150','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1527325678964-54921661f888?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (15,'Papaya',3,'Farm Fresh','1','150','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1526318472351-c75fcf070305?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (16,'Popcorn',4,'ActII','1','150','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1572177191856-3cde618dee1f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (17,'Lays',4,'ActII','1','150','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1566478989037-eec170784d0b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (18,'Doritos',4,'Doritos','1','150','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1567838080002-b388fbd228ae?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (19,'Nabati',4,'Nabati','1','150','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1542843137-144e10cc010b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (20,'Oreo',4,'Cadbury','1','150','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1531257243018-c547a2e35767?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');





select * from product;

-- select * from user where us_status='P';

-- select * from bill ;

-- insert into bill values (1,'2019-03-15',123,1,2);

-- select * from bill_details;


-- insert into bill_details values (1,1,1,3);


-- SELECT bill.* FROM bill INNER JOIN user on (bill.user_us_id = user.us_id) WHERE user.us_user_id = 'c1' ;


-- DROP DATABASE `smart_shopping`;
