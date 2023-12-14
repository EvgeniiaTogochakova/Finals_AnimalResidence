DROP DATABASE IF EXISTS human_friends;
CREATE DATABASE IF NOT EXISTS human_friends;
USE human_friends;

DROP TABLE IF EXISTS categories_of_animals;
CREATE TABLE categories_of_animals(
  id_category SERIAL PRIMARY KEY,
  category VARCHAR(30) COMMENT 'Категория животного'
) COMMENT = 'Таблица категорий животных';

INSERT INTO categories_of_animals(category) 
VALUES ('pet'), ('pack_animal');

SELECT * FROM categories_of_animals;

DROP TABLE IF EXISTS types_of_animals;
CREATE TABLE types_of_animals(
  id_type SERIAL PRIMARY KEY,
  `type` VARCHAR(30) COMMENT 'Вид животного',
  category_id BIGINT UNSIGNED,
  FOREIGN KEY(category_id) REFERENCES categories_of_animals(id_category)
  ON DELETE CASCADE ON UPDATE CASCADE
) COMMENT = 'Таблица видов животных';

INSERT INTO types_of_animals(`type`, category_id) 
VALUES ('dog', 1), ('cat', 1), ('hamster', 1), ('horse', 2), ('camel', 2), ('donkey', 2);

SELECT * FROM types_of_animals;

DROP TABLE IF EXISTS pets;

CREATE TABLE pets (
  id_pet SERIAL PRIMARY KEY,
  `name` VARCHAR(30) NOT NULL,
  `type` BIGINT UNSIGNED NOT NULL,
  birthDate DATE NOT NULL,
  command_1 VARCHAR(30),
  command_2 VARCHAR(30),
  command_3 VARCHAR(30),
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY(`type`) REFERENCES types_of_animals(id_type)
  ON DELETE CASCADE ON UPDATE CASCADE
) COMMENT = 'Домашние животные в питомнике';  
  
INSERT INTO pets(`name`, `type`, birthDate, command_1, command_2, command_3)
VALUES 
  ('Fido', 1, '2020-01-01', 'Sit', 'Stay', 'Fetch'),
  ('Whiskers', 2, '2019-05-15', 'Sit', 'Pounce', NULL),
  ('Hammy', 3, '2021-03-10', 'Roll', 'Hide', NULL),
  ('Buddy', 1, '2018-12-10', 'Sit', 'Paw', 'Bark'),
  ('Smudge', 2, '2020-02-20', 'Sit', 'Pounce', 'Scratch'),
  ('Peanut', 3, '2021-08-01', 'Roll', 'Spin', NULL),
  ('Bella', 1, '2019-11-11', 'Sit', 'Stay', 'Roll'),
  ('Oliver', 2, '2020-06-30', 'Meow', 'Scratch', 'Jump');

SELECT * FROM pets;


DROP TABLE IF EXISTS pack_animals;
CREATE TABLE pack_animals (
  id_pack_animal SERIAL PRIMARY KEY,
  `name` VARCHAR(30) NOT NULL,
  `type` BIGINT UNSIGNED NOT NULL,
  birthDate DATE NOT NULL,
  command_1 VARCHAR(30),
  command_2 VARCHAR(30),
  command_3 VARCHAR(30),
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY(`type`) REFERENCES types_of_animals(id_type)
  ON DELETE CASCADE ON UPDATE CASCADE
) COMMENT = 'Вьючные животные в питомнике';  
  
INSERT INTO pack_animals(`name`, `type`, birthDate, command_1, command_2, command_3)
VALUES 
  ('Thunder', 4, '2015-07-21', 'Trot', 'Canter', 'Gallop'),
  ('Sandy', 5, '2016-11-03', 'Walk', 'Carry Load', NULL),
  ('Eeyore', 6, '2017-09-18', 'Walk', 'Carry Load', 'Bray'),
  ('Storm', 4, '2014-05-05', 'Trot', 'Canter', NULL),
  ('Dune', 5, '2018-12-12', 'Walk', 'Sit', NULL), 
  ('Burro', 6, '2019-01-23', 'Walk', 'Bray', 'Kick'),
  ('Blaze', 4, '2016-02-29', 'Trot', 'Jump', 'Gallop'),
  ('Sahara', 5, '2015-08-14', 'Walk', 'Run', NULL);

SELECT * FROM pack_animals;

SELECT * FROM pack_animals
WHERE type=5;

DELETE FROM pack_animals
WHERE type=5;

SELECT * FROM pack_animals;

SELECT `name`, types_of_animals.`type` AS ВИД,
categories_of_animals.category AS КАТЕГОРИЯ, 
birthDate AS Дата_рождения,
ROUND(DATEDIFF(CURRENT_DATE(), birthDate)/365,2) AS ВОЗРАСТ, 
command_1, command_2, command_3
FROM pets
JOIN types_of_animals ON pets.`type` = types_of_animals.id_type
JOIN categories_of_animals ON types_of_animals.category_id = id_category
WHERE DATEDIFF(CURRENT_DATE(), birthDate) < 1095 AND 
DATEDIFF(CURRENT_DATE(), birthDate) > 365
UNION ALL
SELECT `name`, types_of_animals.`type` AS ВИД,
categories_of_animals.category AS КАТЕГОРИЯ,
birthDate AS Дата_рождения, 
ROUND(DATEDIFF(CURRENT_DATE(), birthDate)/365,2) AS ВОЗРАСТ, 
command_1, command_2, command_3
FROM pack_animals
JOIN types_of_animals ON pack_animals.`type` = types_of_animals.id_type
JOIN categories_of_animals ON types_of_animals.category_id = id_category
WHERE DATEDIFF(CURRENT_DATE(), birthDate) < 1095 AND
DATEDIFF(CURRENT_DATE(), birthDate) > 365;

SELECT `name`, types_of_animals.`type` AS ВИД,
categories_of_animals.category AS КАТЕГОРИЯ, 
birthDate AS Дата_рождения,
command_1, command_2, command_3
FROM pets
JOIN types_of_animals ON pets.`type` = types_of_animals.id_type
JOIN categories_of_animals ON types_of_animals.category_id = id_category
UNION ALL
SELECT `name`, types_of_animals.`type` AS ВИД,
categories_of_animals.category AS КАТЕГОРИЯ,
birthDate AS Дата_рождения, 
command_1, command_2, command_3
FROM pack_animals
JOIN types_of_animals ON pack_animals.`type` = types_of_animals.id_type
JOIN categories_of_animals ON types_of_animals.category_id = id_category;


 
