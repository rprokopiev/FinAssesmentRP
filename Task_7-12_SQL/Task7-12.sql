/* ЗАДАНИЕ №7: В подключенном MySQL репозитории создать базу данных “Друзья человека”.

Создание базы данные "Друзья человека"
----------------------------------------*/
CREATE DATABASE humanFriends;
USE humanFriends;

/*ЗАДАНИЕ №8: Создать таблицы с иерархией из диаграммы в БД.*/

/* Создание и заполнение таблицы с родительским классом
-------------------------------------------------------*/
DROP TABLE IF EXISTS baseAnimal;
CREATE TABLE baseAnimal
(
  id INT PRIMARY KEY AUTO_INCREMENT,
  animalType VARCHAR(20)
);

INSERT baseAnimal (animalType)
VALUES
  ("Pets"),
  ("PackAnimals");
SELECT * FROM baseAnimal;

/* Создание и заполнение таблицы с видами домашних животных
---------------------------------------------------------*/
DROP TABLE IF EXISTS pets;
CREATE TABLE pets
(
  pet_id INT PRIMARY KEY AUTO_INCREMENT,
  pet_type_name VARCHAR(20),
  pet_type INT,
  FOREIGN KEY (pet_type) REFERENCES baseAnimal(id)
    ON UPDATE CASCADE
    ON DELETE SET NULL
);

INSERT pets (pet_type_name, pet_type)
VALUES
  ("Cat", "1"),
  ("Dog", "1"),
  ("Hamster", "1");
SELECT * FROM pets;

/* Создание и заполнение таблицы с видами вьючных животных
-------------------------------------------------------*/
DROP TABLE IF EXISTS packAnimals;
CREATE TABLE packAnimals
(
  packAnimals_id INT PRIMARY KEY AUTO_INCREMENT,
  packAnimal_type_name VARCHAR(20),
  packAnimal_type INT,
  FOREIGN KEY (packAnimal_type) REFERENCES baseAnimal(id)
    ON UPDATE CASCADE
    ON DELETE SET NULL
);

INSERT packAnimals (packAnimal_type_name, packAnimal_type)
VALUES
  ("Horse", "2"),
  ("Camel", "2"),
  ("Donkey", "2");
SELECT * FROM packAnimals;

/* ЗАДАНИЕ 9: Заполнить низкоуровневые таблицы именами(животных), 
командами которые они выполняют и датами рождения.

Создание и заполнение таблиц с животными
-------------------------------------------------------*/
DROP TABLE IF EXISTS cats;
CREATE TABLE cats
(
  cat_id INT PRIMARY KEY AUTO_INCREMENT,
  cat_name VARCHAR(45),
  birth_date DATE,
  command VARCHAR(45) DEFAULT null,
  pet_type INT DEFAULT "1",
  FOREIGN KEY (pet_type) REFERENCES pets(pet_id)
    ON UPDATE CASCADE
    ON DELETE SET NULL,
  animal_type VARCHAR(20)
);

INSERT cats(cat_name, birth_date, command, animal_type)
VALUES
  ("Cat1", "2023-01-01", "Say",
    (SELECT pet_type_name FROM pets WHERE pet_id = cats.pet_type)),
  ("Cat2", "2022-01-01", "Say",
    (SELECT pet_type_name FROM pets WHERE pet_id = cats.pet_type)),
  ("Cat3", "2018-01-01", "Say",
    (SELECT pet_type_name FROM pets WHERE pet_id = cats.pet_type));
    
SELECT * FROM cats;
-- ---------------------------

DROP TABLE IF EXISTS dogs;
CREATE TABLE dogs
(
  dog_id INT PRIMARY KEY AUTO_INCREMENT,
  dog_name VARCHAR(45),
  birth_date DATE,
  command VARCHAR(45) DEFAULT null,
  pet_type INT DEFAULT "2",
  FOREIGN KEY (pet_type) REFERENCES pets(pet_id)
    ON UPDATE CASCADE
    ON DELETE SET NULL,
  animal_type VARCHAR(20)
);

INSERT dogs(dog_name, birth_date, command, animal_type)
VALUES
  ("Dog1", "2023-01-01", "Sit",
    (SELECT pet_type_name FROM pets WHERE pet_id = dogs.pet_type)),
  ("Dog2", "2022-01-01", "Run",
    (SELECT pet_type_name FROM pets WHERE pet_id = dogs.pet_type)),
  ("Dog3", "2018-01-01", "Run",
    (SELECT pet_type_name FROM pets WHERE pet_id = dogs.pet_type));
    
SELECT * FROM dogs;
-- ---------------------------

DROP TABLE IF EXISTS hamsters;
CREATE TABLE hamsters
(
  hamster_id INT PRIMARY KEY AUTO_INCREMENT,
  hamster_name VARCHAR(45),
  birth_date DATE,
  command VARCHAR(45) DEFAULT null,
  pet_type INT DEFAULT "3",
  FOREIGN KEY (pet_type) REFERENCES pets(pet_id)
    ON UPDATE CASCADE
    ON DELETE SET NULL,
  animal_type VARCHAR(20)  
);

INSERT hamsters(Hamster_name, birth_date, animal_type)
VALUES
  ("Hamster1", "2023-01-01",
    (SELECT pet_type_name FROM pets WHERE pet_id = hamsters.pet_type)),
  ("Hamster2", "2022-01-01",
    (SELECT pet_type_name FROM pets WHERE pet_id = hamsters.pet_type)),
  ("Hamster3", "2018-01-01",
    (SELECT pet_type_name FROM pets WHERE pet_id = hamsters.pet_type));
    
SELECT * FROM hamsters;
-- ---------------------------

DROP TABLE IF EXISTS horses;
CREATE TABLE horses
(
  horse_id INT PRIMARY KEY AUTO_INCREMENT,
  horse_name VARCHAR(45),
  birth_date DATE,
  command VARCHAR(45) DEFAULT null,
  packAnimal_type INT DEFAULT "1",
  FOREIGN KEY (packAnimal_type) REFERENCES packanimals(packAnimals_id)
    ON UPDATE CASCADE
    ON DELETE SET NULL,
  animal_type VARCHAR(20) 
);

INSERT horses(Horse_name, birth_date, command, animal_type)
VALUES
  ("Horse1", "2023-01-01", "Stay",
    (SELECT packAnimal_type_name FROM packanimals WHERE packAnimals_id = horses.packAnimal_type)),
  ("Horse2", "2022-01-01", "Run",
    (SELECT packAnimal_type_name FROM packanimals WHERE packAnimals_id = horses.packAnimal_type)),
  ("Horse3", "2018-01-01", "Walk",
    (SELECT packAnimal_type_name FROM packanimals WHERE packAnimals_id = horses.packAnimal_type));
    
SELECT * FROM horses;
-- ---------------------------

DROP TABLE IF EXISTS camels;
CREATE TABLE camels
(
  camel_id INT PRIMARY KEY AUTO_INCREMENT,
  camel_name VARCHAR(45),
  birth_date DATE,
  command VARCHAR(45) DEFAULT null,
  packAnimal_type INT DEFAULT "2",
  FOREIGN KEY (packAnimal_type) REFERENCES packanimals(packAnimals_id)
    ON UPDATE CASCADE
    ON DELETE SET NULL,
  animal_type VARCHAR(20)   
);

INSERT camels(camel_name, birth_date, command, animal_type)
VALUES
  ("Camel1", "2023-01-01", "Run",
    (SELECT packAnimal_type_name FROM packanimals WHERE packAnimals_id = camels.packAnimal_type)),
  ("Camel2", "2022-01-01", "Lay",
    (SELECT packAnimal_type_name FROM packanimals WHERE packAnimals_id = camels.packAnimal_type)),
  ("Camel3", "2018-01-01", "Stay",
    (SELECT packAnimal_type_name FROM packanimals WHERE packAnimals_id = camels.packAnimal_type));
    
SELECT * FROM camels;
-- ---------------------------

DROP TABLE IF EXISTS donkeys;
CREATE TABLE donkeys
(
  donkey_id INT PRIMARY KEY AUTO_INCREMENT,
  donkey_name VARCHAR(45),
  birth_date DATE,
  command VARCHAR(45) DEFAULT null,
  packAnimal_type INT DEFAULT "3",
  FOREIGN KEY (packAnimal_type) REFERENCES packanimals(packAnimals_id)
    ON UPDATE CASCADE
    ON DELETE SET NULL,
  animal_type VARCHAR(20)
);

INSERT donkeys(donkey_name, birth_date, command, animal_type)
VALUES
  ("Donkey1", "2023-01-01", NULL,
    (SELECT packAnimal_type_name FROM packanimals WHERE packAnimals_id = donkeys.packAnimal_type)),
  ("Donkey2", "2022-01-01", "Walk",
    (SELECT packAnimal_type_name FROM packanimals WHERE packAnimals_id = donkeys.packAnimal_type)),
  ("Donkey3", "2021-01-01", NULL,
    (SELECT packAnimal_type_name FROM packanimals WHERE packAnimals_id = donkeys.packAnimal_type));
    
SELECT * FROM donkeys;

/*ЗАДАНИЕ 10*/
/* Удаление таблицы с верблюдами
-------------------------------------------------------*/
DROP TABLE camels;

/* Объединить таблицы с лошадьми, и ослами в одну таблицу.
-------------------------------------------------------*/
SELECT * FROM horses
UNION
SELECT * FROM donkeys;

/* ЗАДАНИЕ 11
Создать новую таблицу “молодые животные”, в которую попадут все животные старше 1 года, 
но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице.
-------------------------------------------------------*/

/*Функция для расчёта возраста животного, исходя их текущей даты, даты рождения животного*/
DELIMITER //
DROP FUNCTION IF EXISTS age//

CREATE FUNCTION age (entry DATE)
RETURNS INT
DETERMINISTIC 
BEGIN
  DECLARE result INT;
  DECLARE entry_year INT;
  DECLARE entry_month INT;
    SET entry_year = year(sysdate()) - year(entry);
    SET entry_month = month(sysdate()) - month(entry);
    IF (entry_month >= 0) THEN
      SET result = entry_year;
	ELSE
      SET result = entry_year - 1;
	END IF;
  RETURN result;
END//

/*Функция для вывода возраста животного с точностью до месяца, исходя их текущей даты, даты рождения животного*/
DROP FUNCTION IF EXISTS age_y_m//

CREATE FUNCTION age_y_m (entry DATE)
RETURNS VARCHAR(45)
DETERMINISTIC 
BEGIN
  DECLARE result VARCHAR(45);
  DECLARE entry_year INT;
  DECLARE entry_month INT;
    SET entry_year = year(sysdate()) - year(entry);
    SET entry_month = month(sysdate()) - month(entry);
    IF (entry_month >= 0) THEN
      SET result = CONCAT(entry_year, " year(-s) ", entry_month, " month(-s)");
	ELSE
      SET result = CONCAT((entry_year - 1), " year(-s) ", (12 + entry_month), " month(-s)");
	END IF;
  RETURN result;
END//

DELIMITER ;

/*Создать новую таблицу “молодые животные”, c животными старше 1 года, 
но младше 3 лет, в отдельном столбце с точностью до месяца возраст животных .*/

-- Объединие всех таблиц
DROP TABLE IF EXISTS young_animals;
CREATE TABLE young_animals
(
  SELECT donkey_name AS animal_name, birth_date, command FROM donkeys
    WHERE age(birth_date) >= 1 AND age(birth_date) <= 3
  UNION
  SELECT horse_name, birth_date, command FROM horses
    WHERE age(birth_date) >= 1 AND age(birth_date) <= 3
  UNION
  SELECT cat_name, birth_date, command FROM cats
    WHERE age(birth_date) >= 1 AND age(birth_date) <= 3
  UNION
  SELECT dog_name, birth_date, command FROM dogs
    WHERE age(birth_date) >= 1 AND age(birth_date) <= 3
  UNION
  SELECT hamster_name, birth_date, command FROM hamsters
    WHERE age(birth_date) >= 1 AND age(birth_date) <= 3
);
SELECT * FROM young_animals;

-- добавление столбца с возрастом животного
ALTER TABLE young_animals
ADD COLUMN age VARCHAR(45) AFTER birth_date;

-- заполнение нового столбца данными
UPDATE young_animals
  SET age = age_y_m(birth_date);

SELECT * FROM young_animals;

/*ЗАДАНИЕ 12: Объединить все таблицы в одну, при этом сохраняя поля, 
указывающие на прошлую принадлежность к старым таблицам.*/

-- Объединие всех таблиц
DROP TABLE IF EXISTS all_animals;
CREATE TABLE all_animals
(
  SELECT donkey_name AS animal_name, donkeys.animal_type, birth_date, command FROM donkeys
  UNION
  SELECT horse_name, horses.animal_type, birth_date, command FROM horses
  UNION
  SELECT cat_name, cats.animal_type, birth_date, command FROM cats
  UNION
  SELECT dog_name, dogs.animal_type, birth_date, command FROM dogs
  UNION
  SELECT hamster_name, hamsters.animal_type, birth_date, command FROM hamsters
);

SELECT * FROM all_animals;
