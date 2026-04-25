
-- GENERAL ENTITIES
CREATE TABLE IF NOT EXISTS countries
(
    code VARCHAR(3) NOT NULL UNIQUE PRIMARY KEY,
    full_name VARCHAR(200) NOT NULL,
    alpha2 VARCHAR(2) NOT NULL UNIQUE,
    alpha3 VARCHAR(3) NOT NULL UNIQUE,
    flag VARCHAR(255) NOT NULL UNIQUE


    CONSTRAINT valid_alpha CHECK (LENGTH(alpha2) = 2 and LENGTH(alpha3) = 3),
    CONSTRAINT valid_code CHECK (LENGTH(code) = 3 AND code ~* '^[0-9]{3}'),
    CONSTRAINT valid_name CHECK (LENGTH(full_name) BETWEEN 3 AND 200)
);

CREATE TABLE IF NOT EXISTS cities
(
    id SERIAL NOT NULL UNIQUE PRIMARY KEY,
    full_name VARCHAR(200) NOT NULL,
    country_code VARCHAR(3) NOT NULL,

    CONSTRAINT fk_countries
        FOREIGN KEY (country_code)
            REFERENCES countries(code)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,

    CONSTRAINT valid_name CHECK (LENGTH(full_name) BETWEEN 3 AND 200)
);

--AUTOPROM ENTITIES
CREATE TABLE IF NOT EXISTS concerns
(
    id SMALLSERIAL PRIMARY KEY,
    full_name VARCHAR(200) NOT NULL,
    country_code VARCHAR(3) NOT NULL,

    CONSTRAINT fk_countries
        FOREIGN KEY (country_code)
        REFERENCES countries(code)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT valid_name CHECK (LENGTH(full_name) BETWEEN 3 AND 200)
);

CREATE TABLE IF NOT EXISTS brands
(
    id SMALLSERIAL PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL UNIQUE,
    short_name VARCHAR(25) NOT NULL UNIQUE,
    country_code VARCHAR(3) NOT NULL,
    owner_id SMALLINT NOT NULL,

    CONSTRAINT fk_countries
        FOREIGN KEY (country_code)
        REFERENCES countries(code)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT fk_owners
        FOREIGN KEY (owner_id)
        REFERENCES concerns(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT valid_full_name CHECK (LENGTH(full_name) BETWEEN 3 AND 100),
    CONSTRAINT valid_short_name CHECK (LENGTH(short_name) BETWEEN 2 AND 25)
);

CREATE TABLE IF NOT EXISTS car_models
(
    id SERIAL PRIMARY KEY,
    model_name VARCHAR(200) NOT NULL,
    brand_id SMALLINT NOT NULL,
    assemble_country VARCHAR(3) NOT NULL,
    assemble_date SMALLINT NOT NULL,

    CONSTRAINT fk_brands
        FOREIGN KEY (brand_id)
            REFERENCES brands(id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,

    CONSTRAINT fk_assemble_country
        FOREIGN KEY (assemble_country)
            REFERENCES countries(code)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,

    CONSTRAINT valid_model_name CHECK (LENGTH(model_name) BETWEEN 1 AND 200),
    CONSTRAINT valid_assemble_date CHECK (assemble_date BETWEEN 1800 AND 2100)
);

CREATE INDEX IF NOT EXISTS idx_brands_country_codes ON brands(country_code);
CREATE INDEX IF NOT EXISTS idx_brands_owners_id ON brands(owner_id);
CREATE INDEX IF NOT EXISTS idx_car_models_brand_id ON car_models(brand_id);
CREATE INDEX IF NOT EXISTS idx_car_models_model_name ON car_models(model_name);

COMMIT;