CREATE TABLE IF NOT EXISTS countries
(
    code VARCHAR(3) NOT NULL UNIQUE PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    alpha2 VARCHAR(2) NOT NULL UNIQUE,
    alpha3 VARCHAR(3) NOT NULL UNIQUE,

    CONSTRAINT valid_alpha CHECK (LENGTH(alpha2) = 2 and LENGTH(alpha3) = 3),
    CONSTRAINT valid_code CHECK (LENGTH(code) = 3 AND code ~* '^[0-9]{3}'),
    CONSTRAINT valid_name CHECK (LENGTH(name) BETWEEN 3 AND 200)
);

CREATE TABLE IF NOT EXISTS corporations
(
    id SMALLSERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    country_code VARCHAR(3) NOT NULL,

    CONSTRAINT fk_countries
        FOREIGN KEY (country_code)
        REFERENCES countries(code)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT valid_name CHECK (LENGTH(name) BETWEEN 3 AND 200)
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
        REFERENCES corporations(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT valid_full_name CHECK (LENGTH(full_name) BETWEEN 3 AND 100),
    CONSTRAINT valid_short_name CHECK (LENGTH(full_name) BETWEEN 2 AND 25)
);

CREATE INDEX idx_brands_country_codes ON brands(country_code);
CREATE INDEX idx_brands_owners_id ON brands(owner_id);

COMMIT;