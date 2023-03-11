DROP DATABASE IF EXISTS my_personal_record;
CREATE DATABASE my_personal_record;
USE my_personal_record;

DROP TABLE IF EXISTS record;
CREATE TABLE record(
	id INT PRIMARY KEY AUTO_INCREMENT,
    exercise_name varchar(55) DEFAULT NULL,
    weights INT DEFAULT NULL,
    sets INT DEFAULT NULL,
    reps INT DEFAULT NULL,
    volume INT DEFAULT NULL,
    training_date DATE
);

INSERT INTO record(exercise_name, weights, sets, reps, volume, training_date)
value
	("squat", 120, 3, 8, 120*3*8, "2023-02-25"),
	("brench press", 80, 4, 9, 80*4*9, "2023-02-26"),
    ("deadlift", 140, 4, 8, 140*4*8,  "2023-02-27");

-- delete from record where id =1;
select * from record;