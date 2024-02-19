
-- Populate Crew
INSERT INTO crew (id, name) VALUES (1, 'Straw Hat Pirates');

-- Populate Characters
INSERT INTO characters (id, name, age, description, role, crew_id) VALUES
(1, 'Monkey D. Luffy', 19, 'Monkey D. Luffy is the captain of the Straw Hat Pirates, known for his goal to become the Pirate King. He possesses the power of the Gomo-Gomo no Mi, granting him stretchy abilities.', 'Captain', 1),
(2, 'Roronoa Zoro', 21, 'Roronoa Zoro, also known as ''Pirate Hunter'' Zoro, is a vital swordsman and Senior Officer in the Straw Hat Pirates, serving as the right-hand man to their captain, Monkey D. Luffy.', 'Combatant', 1),
(3, 'Nami', 20, 'Nami is the Straw Hat Pirates'' navigator, known for her exceptional navigational skills and cartography expertise. She is determined to create accurate maps of the world.', 'Navigator', 1),
(4, 'Usopp', 19, 'Usopp, the crew''s sharpshooter and a talented sniper. He is known for his tall tales and marksmanship, often employing his slingshot for ranged attacks.', 'Sniper', 1),
(5, 'Sanji', 21, 'Sanji, the Straw Hat Pirates'' cook and martial artist. He is skilled in the Black Leg style, using powerful kicks in combat. Sanji is also known for his chivalry and love for cooking.', 'Chef', 1),
(6, 'Tony Tony Chopper', 17, 'Tony Tony Chopper is the crew''s doctor and a reindeer who consumed the Human-Human Fruit. This allows him to transform into different forms, each with unique abilities.', 'Doctor', 1),
(7, 'Nico Robin', 30, 'Nico Robin, the crew''s archaeologist and historian. She possesses the powers of the Hana Hana no Mi, allowing her to sprout multiple limbs and eyes. Robin is knowledgeable about the world''s history.', 'Archaeologist', 1),
(8, 'Franky', 36, 'Franky, the shipwright of the Straw Hat Pirates. He is a cyborg with superhuman strength and is responsible for building and maintaining the crew''s ship, the Thousand Sunny.', 'Shipwright', 1),
(9, 'Brook', 88, 'Brook, the crew''s musician and a living skeleton. He consumed the Revive-Revive Fruit, allowing his soul to return to his body after death. Brook is a skilled swordsman and uses musical attacks in battle.', 'Musician', 1);

-- Populate Character Abilities
INSERT INTO character_ability (character_id, ability) VALUES
(1, 'Observation Haki'),
(1, 'Conqueror Haki'),
(1, 'Proficient hand-to-hand combatant'),
(1, 'Super Strength'),
(1, 'Gomo Gomo no Mi'),
(1, 'Excellent tactical sense'),
(1, 'Armament Haki'),
(1, 'Great leadership skills'),
(2, 'Observation Haki (Kenbunshoku Haki)'),
(2, 'Conqueror''s Haki (Haoshoku Haki)'),
(2, 'Armament Haki (Busoshoku Haki)'),
(2, 'Excellent tactical sense'),
(3, 'Exceptional navigation skills'),
(3, 'Cartography expertise'),
(3, 'Meteorology knowledge'),
(3, 'Skilled in using the Clima-Tact'),
(4, 'Expert Marksmanship'),
(4, 'Inventive Gadgets'),
(4, 'Sniper King Mode'),
(4, 'Pop Greens Expertise'),
(5, 'Black Leg Style'),
(5, 'Powerful Kicks'),
(5, 'Sky Walk'),
(5, 'Diable Jambe'),
(6, 'Human-Human Fruit (Ushi Ushi no Mi, Model: Bison)'),
(6, 'Medical Knowledge'),
(6, 'Monster Point'),
(6, 'Scope and Scalpel Techniques'),
(7, 'Hana Hana no Mi'),
(7, 'Archaeological Knowledge'),
(7, 'Gigantesco Mano'),
(7, 'Mil Fleurs: Clutch'),
(8, 'Superhuman Strength'),
(8, 'Cybernetic Enhancements'),
(8, 'Coup de Vent'),
(8, 'General Cannon'),
(9, 'Swordsmanship'),
(9, 'Musical Attacks'),
(9, 'Revive-Revive Fruit (Yomi Yomi no Mi)'),
(9, 'Soul Solid Sword Techniques'),
(9, 'Lullaby Parry');

-- Populate Crew Members
INSERT INTO crew_members (crew_id, members_id) VALUES
(1, 1),  -- Monkey D. Luffy
(1, 2),  -- Roronoa Zoro
(1, 3),  -- Nami
(1, 4),  -- Usopp
(1, 5),  -- Sanji
(1, 6),  -- Tony Tony Chopper
(1, 7),  -- Nico Robin
(1, 8),  -- Franky
(1, 9);  -- Brook

