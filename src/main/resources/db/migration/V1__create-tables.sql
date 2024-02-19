CREATE SCHEMA IF NOT EXISTS "data";

-- Create Crew table
CREATE TABLE IF NOT EXISTS crew (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

-- Create Characters table
CREATE TABLE IF NOT EXISTS characters (
    id BIGINT PRIMARY KEY,
    name VARCHAR(30) NOT NULL UNIQUE,
    age INTEGER,
    description TEXT,
    role VARCHAR(255),
    crew_id BIGINT,
    FOREIGN KEY (crew_id) REFERENCES crew(id)
);

-- Create Character Ability table
CREATE TABLE IF NOT EXISTS character_ability (
    character_id BIGINT,
    ability VARCHAR(255),
    PRIMARY KEY (character_id, ability),
    FOREIGN KEY (character_id) REFERENCES characters(id)
);

-- Create Crew Members table
CREATE TABLE IF NOT EXISTS crew_members (
    crew_id BIGINT,
    members_id BIGINT,
    PRIMARY KEY (crew_id, members_id),
    FOREIGN KEY (crew_id) REFERENCES crew(id),
    FOREIGN KEY (members_id) REFERENCES characters(id)
);

