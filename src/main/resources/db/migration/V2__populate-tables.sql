
-- Populate Crew
INSERT INTO crew (id, name) VALUES (1, 'Straw Hat Pirates');

-- Populate Characters
INSERT INTO characters (id, name, age, description, role, crew_id) VALUES
(1, 'Monkey D. Luffy', 19, 'Monkey D. Luffy is the captain of the Straw Hat Pirates, known for his goal to become the Pirate King. He possesses the power of the Gomo-Gomo no Mi, granting him stretchy abilities.', 'Captain', 1),
(2, 'Roronoa Zoro', 21, 'Roronoa Zoro, also known as ''Pirate Hunter'' Zoro, is a vital swordsman and Senior Officer in the Straw Hat Pirates, serving as the right-hand man to their captain, Monkey D. Luffy.', 'Combatant', 1),
(3, 'Nami', 20, 'Nami is the Straw Hat Pirates'' navigator, known for her exceptional navigational skills and cartography expertise. She is determined to create accurate maps of the world.', 'Navigator', 1);


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
    (3, 'Skilled in using the Clima-Tact');

-- Populate Crew Members
INSERT INTO crew_members (crew_id, members_id) VALUES
(1, 1),  -- Monkey D. Luffy
(1, 2),  -- Roronoa Zoro
(1, 3);  -- Nami