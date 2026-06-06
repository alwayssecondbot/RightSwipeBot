
-- GENERAL ENTITIES
CREATE TABLE IF NOT EXISTS countries
(
    code VARCHAR(3) PRIMARY KEY,
    full_name VARCHAR(200) NOT NULL,
    alpha2 VARCHAR(2) NOT NULL UNIQUE,
    alpha3 VARCHAR(3) NOT NULL UNIQUE,
    flag_url VARCHAR(255) UNIQUE,


    CONSTRAINT valid_alpha2 CHECK (LENGTH((alpha2)::text) = 2),
    CONSTRAINT valid_alpha3 CHECK (LENGTH((alpha3)::text) = 3),
    CONSTRAINT valid_code CHECK (LENGTH((code)::text) = 3 AND code ~* '^[0-9]{3}')
);

CREATE TABLE IF NOT EXISTS cities
(
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(200) NOT NULL,
    country_code VARCHAR(3) NOT NULL,

    CONSTRAINT fk_countries
        FOREIGN KEY (country_code)
            REFERENCES countries(code)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
);

CREATE INDEX IF NOT EXISTS idx_cities_country_code ON cities(country_code);

--USER ENTITIES
CREATE TABLE IF NOT EXISTS accounts
(
    id             BIGSERIAL PRIMARY KEY,
    birthday       DATE,
    creation_date  DATE DEFAULT NOW() NOT NULL,
    drive_since    DATE,
    full_name      VARCHAR(255),
    is_corporation BOOLEAN DEFAULT FALSE NOT NULL,
    is_verified    BOOLEAN DEFAULT FALSE NOT NULL,
    last_online    TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    "login"        VARCHAR(100) NOT NULL UNIQUE,
    mail           VARCHAR(100) UNIQUE,
    phone_number   VARCHAR(30) UNIQUE,
    photo_url      VARCHAR(255) UNIQUE,
    country_code   VARCHAR(3) NOT NULL,
    is_deleted     BOOLEAN DEFAULT FALSE NOT NULL,

    CONSTRAINT fk_countries
        FOREIGN KEY (country_code)
            REFERENCES countries(code)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,

    CONSTRAINT valid_mail CHECK ((mail)::text ~* '^[a-z0-9!#$%&''*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&''*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$'::text),
    CONSTRAINT valid_phone_number CHECK ((phone_number)::text ~ '^\+[1-9]{1,9} \([0-9]{3}\) [0-9]{7}$'::text)
);

CREATE INDEX IF NOT EXISTS idx_accounts_country_code ON accounts(country_code);

CREATE TABLE IF NOT EXISTS article_photos
(
    id         BIGSERIAL PRIMARY KEY,
    is_main    BOOLEAN DEFAULT FALSE NOT NULL,
    sort_order SMALLINT DEFAULT 0 NOT NULL,
    url        VARCHAR(255) NOT NULL UNIQUE,
    article_id BIGINT NOT NULL,

    constraint fk_articles
        FOREIGN KEY (article_id)
            REFERENCES articles(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

CREATE INDEX IF NOT EXISTS idx_article_photos_article_id_is_main ON article_photos(article_id) WHERE is_main = TRUE;
CREATE INDEX IF NOT EXISTS idx_article_photos_article_id_sort_order ON article_photos(article_id,sort_order);

CREATE TABLE IF NOT EXISTS articles
(
    id             BIGSERIAL PRIMARY KEY,
    title          VARCHAR(255) NOT NULL,
    "content"      TEXT NOT NULL,
    creation_date  DATE DEFAULT NOW() NOT NULL,
    rating         JSONB
);

CREATE INDEX IF NOT EXISTS idx_articles_creation_date ON articles(creation_date);

CREATE TABLE IF NOT EXISTS filters
(
    id                  BIGSERIAL PRIMARY KEY,
    body_props          JSONB,
    brakensusp_props    JSONB,
    complectation_props JSONB,
    engine_props        JSONB,
    full_name           VARCHAR(50) NOT NULL,
    gearbox_props       JSONB,
    offer_props         JSONB,
    other_props         JSONB,
    primary_props       JSONB,
    account_id          BIGINT NOT NULL,

    CONSTRAINT fk_accounts
        FOREIGN KEY (account_id)
        REFERENCES accounts
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE INDEX IF NOT EXISTS idx_filters_account_id ON filters(account_id);

CREATE TABLE IF NOT EXISTS offers
(
    id                BIGSERIAL PRIMARY KEY,
    body_color        SMALLINT NOT NULL,
    body_color_type   VARCHAR(25) NOT NULL,
    complectation     JSONB NOT NULL,
    creation_date     DATE DEFAULT NOW() NOT NULL,
    description       TEXT NOT NULL,
    has_guarantee     BOOLEAN DEFAULT FALSE NOT NULL,
    interior_color    SMALLINT NOT NULL,
    is_deleted        BOOLEAN DEFAULT FALSE NOT NULL,
    last_update       DATE NOT NULL,
    may_change        BOOLEAN DEFAULT FALSE NOT NULL,
    mileage           INT NOT NULL,
    offer_type        VARCHAR(25) NOT NULL,
    price             BIGINT NOT NULL,
    was_in_accident   BOOLEAN DEFAULT FALSE NOT NULL,
    seller_account_id BIGINT NOT NULL,
    city_id           INT NOT NULL,
    variation_id      INT NOT NULL,
    vrc_id            BIGINT UNIQUE,

    CONSTRAINT fk_vrces
        FOREIGN KEY (vrc_id)
        REFERENCES vrces(id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,

    CONSTRAINT fk_variations
        FOREIGN KEY (variation_id)
        REFERENCES variations
        ON UPDATE CASCADE
        ON DELETE RESTRICT,

    CONSTRAINT fk_accounts,
        FOREIGN KEY (seller_account_id)
        REFERENCES accounts(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    CONSTRAINT fk_citites,
        FOREIGN KEY (city_id)
        REFERENCES cities(id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,

    CONSTRAINT positive_price CHECK (price >= 0),
    CONSTRAINT positive_mileage CHECK (mileage >= 0),
    CONSTRAINT range_body_color CHECK (body_color >= 0 AND body_color <=128),
    CONSTRAINT offers_body_color_type_check CHECK ((body_color_type)::text = ANY((ARRAY ['GLOSS'::character varying, 'METALLIC'::character varying, 'CHROME'::character varying, 'CARBON'::character varying, 'MATTE'::character varying, 'IRIDESCENT'::character varying, 'CHAMELEON_FLAKE'::character varying, 'COLOR_SHIFT'::character varying])::text[])),
    CONSTRAINT offers_offer_type_check CHECK ((offer_type)::text = ANY((ARRAY ['IN_STOCK'::character varying, 'IMPORT'::character varying])::text[])),
    CONSTRAINT legit_vrc CHECK (((offer_type)::text = 'IN_STOCK'::text AND vrc_id IS NOT NULL) OR ((offer_type)::text = 'IMPORT'::text AND vrc_id IS NULL)),
    CONSTRAINT range_interior_color CHECK (interior_color >= 0 AND interior_color <=128)
);

CREATE INDEX IF NOT EXISTS idx_offers_city_id ON offers(city_id);
CREATE INDEX IF NOT EXISTS idx_offers_variation_id ON offers(variation_id);
CREATE INDEX IF NOT EXISTS idx_offers_seller_account_id ON offers(seller_account_id);
CREATE INDEX IF NOT EXISTS idx_offers_creation_date ON offers(creation_date);
CREATE INDEX IF NOT EXISTS idx_offers_mileage ON offers(mileage);
CREATE INDEX IF NOT EXISTS idx_offers_price ON offers(price);


CREATE TABLE IF NOT EXISTS offer_photos
(
    id         BIGSERIAL PRIMARY KEY,
    is_main    BOOLEAN DEFAULT FALSE NOT NULL,
    sort_order SMALLINT DEFAULT 0 NOT NULL,
    url        VARCHAR(255) NOT NULL UNIQUE,
    offer_id   BIGINT NOT NULL,

    CONSTRAINT fk_offers
        FOREIGN KEY (offer_id)
        REFERENCES offers(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS idx_offer_photos_offer_id_is_main ON offer_photos(offer_id) WHERE is_main = TRUE;
CREATE INDEX IF NOT EXISTS idx_offer_photos_offer_id_sort_order ON offer_photos(offer_id, sort_order);


CREATE TABLE IF NOT EXISTS reports
(
    id               BIGSERIAL PRIMARY KEY,
    creation_date    DATE DEFAULT NOW() NOT NULL,
    description      TEXT NOT NULL,
    rating           JSONB,
    account_id       BIGINT NOT NULL,
    complectation_id INT,
    generation_id    INT NOT NULL,
    variation_id     INT,


    CONSTRAINT fk_variations
        FOREIGN KEY (variation_id)
        REFERENCES variations(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT fk_accounts
        FOREIGN KEY (account_id)
        REFERENCES accounts
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    CONSTRAINT fk_complectations
        FOREIGN KEY (complectation_id)
        REFERENCES complectations(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT fk_generations
        FOREIGN KEY (generation_id)
        REFERENCES generations(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE INDEX IF NOT EXISTS idx_reports_creation_date ON reports(creation_date);
CREATE INDEX IF NOT EXISTS idx_reports_account_id ON reports(account_id);
CREATE INDEX IF NOT EXISTS idx_reports_complectation_id ON reports(complectation_id);
CREATE INDEX IF NOT EXISTS idx_reports_generation_id ON reports(generation_id);
CREATE INDEX IF NOT EXISTS idx_reports_variation_id ON reports(variation_id);


CREATE TABLE IF NOT EXISTS report_photos
(
    id         BIGSERIAL PRIMARY KEY,
    is_main    BOOLEAN DEFAULT FALSE NOT NULL,
    sort_order SMALLINT DEFAULT 0 NOT NULL,
    url        VARCHAR(255) NOT NULL UNIQUE,
    report_id  BIGINT NOT NULL,

    CONSTRAINT fk_reports
        FOREIGN KEY (report_id)
        REFERENCES reports(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE INDEX IF NOT EXISTS idx_report_photos_report_id_is_main ON report_photos(report_id) WHERE is_main = TRUE;
CREATE INDEX IF NOT EXISTS idx_report_photos_report_id_sort_order ON report_photos(report_id,sort_order);

CREATE TABLE IF NOT EXISTS reviews
(
    id                BIGSERIAL PRIMARY KEY,
    creation_date     DATE DEFAULT NOW() NOT NULL,
    description       TEXT NOT NULL,
    rating            JSONB,
    account_id        BIGINT NOT NULL,
    complectation_id INT,
    generation_id     INT NOT NULL,
    variation_id      INT,

    CONSTRAINT fk_variations
        FOREIGN KEY (variation_id)
        REFERENCES variations(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT fk_accounts
        FOREIGN KEY (account_id)
            REFERENCES accounts
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    CONSTRAINT fk_complectations
        FOREIGN KEY (complectation_id)
            REFERENCES complectations(id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,

    CONSTRAINT fk_generations
        FOREIGN KEY (generation_id)
            REFERENCES generations(id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
);

CREATE INDEX IF NOT EXISTS idx_reviews_creation_date ON reviews(creation_date);
CREATE INDEX IF NOT EXISTS idx_reviews_account_id ON reviews(account_id);
CREATE INDEX IF NOT EXISTS idx_reviews_complectation_id ON reviews(complectation_id);
CREATE INDEX IF NOT EXISTS idx_reviews_generation_id ON reviews(generation_id);
CREATE INDEX IF NOT EXISTS idx_reviews_variation_id ON reviews(variation_id);

CREATE TABLE IF NOT EXISTS review_photos
(
    id         BIGSERIAL PRIMARY KEY,
    is_main    BOOLEAN DEFAULT FALSE NOT NULL,
    sort_order SMALLINT DEFAULT 0 NOT NULL,
    url        VARCHAR(255) NOT NULL UNIQUE,
    review_id  BIGINT NOT NULL,

    CONSTRAINT fk_reviews
        FOREIGN KEY (review_id)
        REFERENCES reviews
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE INDEX IF NOT EXISTS idx_review_photos_review_id_is_main ON review_photos(review_id) WHERE is_main = TRUE;
CREATE INDEX IF NOT EXISTS idx_review_photos_review_id_sort_order ON review_photos(review_id, sort_order);

CREATE TABLE IF NOT EXISTS vrces
(
    id            BIGSERIAL PRIMARY KEY,
    is_original   BOOLEAN NOT NULL,
    owners        JSONB NOT NULL,
    produced_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS liked_models
(
    account_id BIGINT NOT NULL
        CONSTRAINT fk_accounts
            REFERENCES accounts(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    model_id INTEGER NOT NULL
        CONSTRAINT fk_models
            REFERENCES models(id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,
    PRIMARY KEY (account_id, model_id)
);

CREATE INDEX IF NOT EXISTS idx_liked_models_account_id ON liked_models(account_id);
CREATE INDEX IF NOT EXISTS idx_liked_models_model_id ON liked_models(model_id);


CREATE TABLE IF NOT EXISTS liked_offers
(
    offer_id   BIGINT NOT NULL
        CONSTRAINT fk_offers
            REFERENCES offers(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    account_id BIGINT NOT NULL
        CONSTRAINT fk_accounts
            REFERENCES accounts(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    primary key (offer_id, account_id)
);

CREATE INDEX IF NOT EXISTS idx_liked_offers_account_id ON liked_offers(account_id);
CREATE INDEX IF NOT EXISTS idx_liked_offers_offer_id ON liked_offers(offer_id);


CREATE TABLE IF NOT EXISTS liked_variations
(
    account_id   BIGINT NOT NULL
        CONSTRAINT fk_accounts
            REFERENCES accounts(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    variation_id INT NOT NULL
        CONSTRAINT fk_variations
            REFERENCES variations(id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,
    primary key (account_id, variation_id)
);

CREATE INDEX IF NOT EXISTS idx_liked_variations_account_id ON liked_variations(account_id);
CREATE INDEX IF NOT EXISTS idx_liked_variations_variation_id ON liked_variations(variation_id);


CREATE TABLE IF NOT EXISTS liked_generations
(
    account_id    BIGINT NOT NULL
        CONSTRAINT fk_accounts
            REFERENCES accounts(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    generation_id INT NOT NULL
        CONSTRAINT fk_generations
            REFERENCES generations(id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,
    primary key (account_id, generation_id)
);

CREATE INDEX IF NOT EXISTS idx_liked_generations_account_id ON liked_generations(account_id);
CREATE INDEX IF NOT EXISTS idx_liked_generations_generation_id ON liked_generations(generation_id);

CREATE TABLE IF NOT EXISTS favourite_generations
(
    account_id    BIGINT NOT NULL
        CONSTRAINT fk_accounts
            REFERENCES accounts(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    generation_id INT NOT NULL
        CONSTRAINT fk_generations
            REFERENCES generations(id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,
    primary key (account_id, generation_id)
);

CREATE INDEX IF NOT EXISTS idx_favourite_generations_account_id ON favourite_generations(account_id);
CREATE INDEX IF NOT EXISTS idx_favourite_generations_generation_id ON favourite_generations(generation_id);


CREATE TABLE IF NOT EXISTS favourite_variations
(
    account_id   BIGINT NOT NULL
        CONSTRAINT fk_accounts
            REFERENCES accounts(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    variation_id INT NOT NULL
        CONSTRAINT fk_variations
            REFERENCES variations(id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,
    primary key (account_id, variation_id)
);

CREATE INDEX IF NOT EXISTS idx_favourite_variations_account_id ON favourite_variations(account_id);
CREATE INDEX IF NOT EXISTS idx_favourite_variations_variation_id ON favourite_variations(variation_id);


--AUTOPROM ENTITIES
CREATE TABLE IF NOT EXISTS concerns
(
    id                  SMALLSERIAL PRIMARY KEY,
    full_name           VARCHAR(100) NOT NULL,
    country_code        VARCHAR(3) NOT NULL,
    capitalization      INT,
    description_history TEXT,
    grows               SMALLINT,
    logo_url            VARCHAR(255) UNIQUE,
    main_brand_id       SMALLINT UNIQUE,
    is_deleted          BOOLEAN DEFAULT FALSE NOT NULL,

    CONSTRAINT fk_brands
        FOREIGN KEY (main_brand_id)
        REFERENCES brands(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT fk_countries
        FOREIGN KEY (country_code)
        REFERENCES countries(code)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT positive_capitalization CHECK (capitalization > 0)
);

CREATE INDEX IF NOT EXISTS idx_concerns_country_code ON concerns(country_code);

CREATE TABLE IF NOT EXISTS brands
(
    id SMALLSERIAL PRIMARY KEY,
    full_name           VARCHAR(100) NOT NULL,
    short_name          VARCHAR(50) NOT NULL,
    country_code        VARCHAR(3) NOT NULL,
    capitalization      INT,
    description_history TEXT,
    grows               SMALLINT,
    logo_url            VARCHAR(255) UNIQUE,
    produced_auto       INT,
    sold_auto           INT,
    concern_id          SMALLINT NOT NULL,
    is_deleted          BOOLEAN DEFAULT FALSE NOT NULL,

    CONSTRAINT fk_countries
        FOREIGN KEY (country_code)
        REFERENCES countries(code)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT fk_concerns
        FOREIGN KEY (concern_id)
        REFERENCES concerns(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT positive_sold_auto CHECK (sold_auto > 0),
    CONSTRAINT positive_produced_auto CHECK (produced_auto > 0),
    CONSTRAINT positive_capitalization CHECK (capitalization > 0)
);

CREATE INDEX IF NOT EXISTS idx_brands_country_code ON brands(country_code);
CREATE INDEX IF NOT EXISTS idx_brands_concern_id ON brands(concern_id);

CREATE TABLE IF NOT EXISTS models
(
    id                  SERIAL PRIMARY KEY,
    full_name           VARCHAR(100) NOT NULL,
    description_history TEXT,
    brand_id            SMALLINT NOT NULL,
    is_deleted          BOOLEAN DEFAULT FALSE NOT NULL,

    CONSTRAINT fk_brands
        FOREIGN KEY (brand_id)
        REFERENCES brands(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE INDEX IF NOT EXISTS idx_models_brand_id ON models(brand_id);


CREATE TABLE IF NOT EXISTS generations
(
    id                  SERIAL PRIMARY KEY,
    full_name           VARCHAR(100) NOT NULL,
    model_id            INT          NOT NULL,
    car_class           VARCHAR(25)  NOT NULL,
    description_history TEXT,
    price_max           INT,
    price_min           INT,
    produced_auto       INT,
    sold_auto           INT,
    year_start          SMALLINT,
    year_stop           SMALLINT,
    is_deleted          BOOLEAN DEFAULT FALSE NOT NULL,


    CONSTRAINT fk_models
        FOREIGN KEY (model_id)
            REFERENCES models (id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,

    CONSTRAINT positive_year_stop CHECK ((year_stop)::numeric <= EXTRACT(year FROM now())),
    CONSTRAINT positive_year_start CHECK (year_start >= 1900),
    CONSTRAINT positive_sold_auto CHECK (sold_auto >= 0),
    CONSTRAINT positive_produced_auto CHECK (produced_auto >= 0),
    CONSTRAINT positive_price_min CHECK (price_min >= 0),
    CONSTRAINT positive_price_max CHECK (price_max >= 0),
    CONSTRAINT generations_car_class_check CHECK ((car_class)::text = ANY((ARRAY ['A'::character varying, 'B'::character varying, 'C'::character varying, 'D'::character varying, 'E'::character varying, 'F'::character varying, 'SUV'::character varying, 'M'::character varying, 'S'::character varying])::text[]))
);

CREATE INDEX IF NOT EXISTS idx_generations_model_id ON generations(model_id);
CREATE INDEX IF NOT EXISTS idx_generations_car_class ON generations(car_class);


CREATE TABLE IF NOT EXISTS generation_photos
(
    id            BIGSERIAL PRIMARY KEY,
    is_main       BOOLEAN DEFAULT FALSE NOT NULL,
    sort_order    SMALLINT DEFAULT 0 NOT NULL,
    url           VARCHAR(255) NOT NULL UNIQUE,
    generation_id INT NOT NULL,

    CONSTRAINT fk_generations
        FOREIGN KEY (generation_id)
        REFERENCES generations(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE INDEX IF NOT EXISTS idx_generation_photos_generation_id_is_main ON generation_photos(generation_id) WHERE is_main = TRUE;
CREATE INDEX IF NOT EXISTS idx_generation_photos_generation_id_sort_order ON generation_photos(generation_id, sort_order);

CREATE TABLE IF NOT EXISTS variations
(
    id                 BIGSERIAL PRIMARY KEY,
    acl_to_100         SMALLINT,
    body_type          VARCHAR(25) NOT NULL,
    boost_type         VARCHAR(25) NOT NULL,
    description_review TEXT,
    drive_type         VARCHAR(25) NOT NULL,
    engine_position    VARCHAR(25) NOT NULL,
    fuel_per_100       SMALLINT,
    full_name          VARCHAR(100) NOT NULL,
    other_props        JSONB,
    rating             JSONB,
    susp_brake_props   JSONB,
    body_props         JSONB,
    engine_id          INT,
    gearbox_id         INT,
    generation_id      INT NOT NULL,

    constraint fk_generations
        FOREIGN KEY (generation_id)
        REFERENCES generations(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT fk_gearboxes
        FOREIGN KEY (gearbox_id)
        REFERENCES gearboxes(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT fk_engines
        FOREIGN KEY (engine_id)
        REFERENCES engines(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT positive_fuel_per_100 CHECK (fuel_per_100 > 0),
    CONSTRAINT positive_acl_to_100 CHECK (acl_to_100 > 0),
    CONSTRAINT variations_body_type_check CHECK ((body_type)::text = ANY((ARRAY ['CABRIOLET'::character varying, 'COUPE'::character varying, 'CONVERTIBLE'::character varying, 'CROSSOVER'::character varying, 'HATCHBACK'::character varying, 'LIMOUSINE'::character varying, 'LIFTBACK'::character varying, 'MICRO'::character varying, 'MINIVAN'::character varying, 'MUSCLE'::character varying, 'OFFROAD'::character varying, 'PICKUP'::character varying, 'ROADSTER'::character varying, 'SEDAN'::character varying, 'SPORT'::character varying, 'SUV'::character varying, 'VAN'::character varying, 'WAGON'::character varying])::text[])),
    CONSTRAINT variations_boost_type_check CHECK ((boost_type)::text = ANY((ARRAY ['TURBOCHARGED'::character varying, 'ATMOSPHERIC'::character varying])::text[])),
    CONSTRAINT variations_drive_type_check CHECK ((drive_type)::text = ANY((ARRAY ['FWD'::character varying, 'RWD'::character varying, '_4WD'::character varying, 'AWD'::character varying])::text[])),
    CONSTRAINT variations_engine_position_check CHECK ((engine_position)::text = ANY((ARRAY ['FRONT'::character varying, 'CENTER'::character varying, 'REAR'::character varying])::text[]))
);

CREATE INDEX IF NOT EXISTS idx_variations_generation_id ON variations(generation_id);
CREATE INDEX IF NOT EXISTS idx_variations_gearbox_id ON variations(gearbox_id);
CREATE INDEX IF NOT EXISTS idx_variations_engine_id ON variations(engine_id);
CREATE INDEX IF NOT EXISTS idx_variations_body_type ON variations(body_type);
CREATE INDEX IF NOT EXISTS idx_variations_acl_to_100 ON variations(acl_to_100);
CREATE INDEX IF NOT EXISTS idx_variations_fuel_per_100 ON variations(fuel_per_100);

create table engines
(
    id                  SERIAL PRIMARY KEY,
    capacity            SMALLINT,
    co2_emission        SMALLINT,
    compression_ratio   SMALLINT,
    cylinders_diameter  SMALLINT,
    cylinders_position  VARCHAR(25) NOT NULL,
    cylinders_quantity  SMALLINT,
    fuel_type           VARCHAR(25) NOT NULL,
    full_name           VARCHAR(255) NOT NULL UNIQUE,
    piston_stroke       SMALLINT,
    power               SMALLINT,
    power_system        VARCHAR(25) NOT NULL,
    review              TEXT,
    torque              SMALLINT,
    "type"                VARCHAR(25) NOT NULL,
    valves_per_cylinder SMALLINT,
    parent_id           INT,

    CONSTRAINT fk_engines
        FOREIGN KEY (parent_id)
        REFERENCES engines(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT positive_capacity CHECK (capacity > 0),
    CONSTRAINT positive_co2_emission CHECK (co2_emission > 0),
    CONSTRAINT positive_compression_ratio CHECK (compression_ratio > 0),
    CONSTRAINT positive_piston_stroke CHECK (piston_stroke > 0),
    CONSTRAINT positive_power CHECK (power > 0),
    CONSTRAINT positive_torque CHECK (torque > 0),
    CONSTRAINT positive_valves_per_cylinder CHECK (valves_per_cylinder > 0),
    CONSTRAINT positive_cylinders_diameter CHECK (cylinders_diameter > 0),
    CONSTRAINT positive_cylinders_quantity CHECK (cylinders_quantity > 0),
    CONSTRAINT engines_cylinders_position_check CHECK ((cylinders_position)::text = ANY((ARRAY ['FLAT'::character varying, 'INLINE'::character varying, 'V'::character varying, 'W'::character varying])::text[])),
    CONSTRAINT engines_fuel_type_check CHECK ((fuel_type)::text = ANY((ARRAY ['DIESEL'::character varying, 'HYBRID'::character varying, 'PETROL'::character varying, 'ELECTRO'::character varying, 'AUTOGAS'::character varying])::text[])),
    CONSTRAINT engines_power_system_check CHECK ((power_system)::text = ANY((ARRAY ['DIRECT'::character varying, 'INDIRECT'::character varying])::text[])),
    CONSTRAINT engines_type_check CHECK (("type")::text = ANY((ARRAY ['WANKEL'::character varying, 'ELECTRIC'::character varying, 'MULTICYLINDER'::character varying])::text[]))
);

CREATE INDEX IF NOT EXISTS idx_engines_parent_id ON engines(parent_id);
CREATE INDEX IF NOT EXISTS idx_engines_capacity ON engines(capacity);
CREATE INDEX IF NOT EXISTS idx_engines_power ON engines(power);
CREATE INDEX IF NOT EXISTS idx_engines_torque ON engines(torque);

CREATE TABLE IF NOT EXISTS engine_photos
(
    id         BIGSERIAL PRIMARY KEY,
    is_main    BOOLEAN DEFAULT FALSE NOT NULL,
    sort_order SMALLINT DEFAULT 0 NOT NULL,
    url        VARCHAR(255) NOT NULL UNIQUE,
    engine_id  INT NOT NULL,

    CONSTRAINT fk_engines
        FOREIGN KEY (engine_id)
        REFERENCES engines(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE INDEX IF NOT EXISTS idx_engine_photos_engine_id_is_main ON engine_photos(engine_id) WHERE is_main = TRUE;
CREATE INDEX IF NOT EXISTS idx_engine_photos_engine_id_sort_order ON engine_photos(engine_id,sort_order);

CREATE TABLE IF NOT EXISTS gearboxes
(
    id            SERIAL PRIMARY KEY,
    full_name     VARCHAR(255) NOT NULL UNIQUE,
    gear_quantity SMALLINT,
    review        TEXT,
    "type"          VARCHAR(25) NOT NULL,
    parent_id     INT,

    CONSTRAINT fk_gearboxes
        FOREIGN KEY (parent_id)
        REFERENCES gearboxes(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT positive_gear_quantity CHECK (gear_quantity > 0),
    CONSTRAINT gearboxes_type_check CHECK (("type")::text = ANY((ARRAY ['AMT'::character varying, 'CVT'::character varying, 'DCT'::character varying, 'MT'::character varying, 'TCA'::character varying])::text[]))
);

CREATE INDEX IF NOT EXISTS idx_gearboxes_type ON gearboxes("type");
CREATE INDEX IF NOT EXISTS idx_gearboxes_parent_id ON gearboxes(parent_id);


CREATE TABLE IF NOT EXISTS gearbox_photos
(
    id         BIGSERIAL PRIMARY KEY,
    is_main    BOOLEAN DEFAULT FALSE NOT NULL,
    sort_order SMALLINT DEFAULT 0 NOT NULL,
    url        VARCHAR(255) NOT NULL UNIQUE,
    gearbox_id INTEGER NOT NULL,

    CONSTRAINT fk_gearboxes
        FOREIGN KEY (gearbox_id)
        REFERENCES gearboxes(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE INDEX IF NOT EXISTS idx_gearbox_photos_gearbox_id_is_main ON gearbox_photos(gearbox_id) WHERE is_main = TRUE;
CREATE INDEX IF NOT EXISTS idx_gearbox_photos_gearbox_id_sort_order ON gearbox_photos(gearbox_id,sort_order);

CREATE TABLE IF NOT EXISTS complectations
(
    id               BIGSERIAL PRIMARY KEY,
    antitheft_props  JSONB,
    exterior_props   JSONB,
    full_name        VARCHAR(100) NOT NULL,
    interior_props   JSONB,
    light_props      JSONB,
    multimedia_props JSONB,
    safety_props     JSONB,
    generation_id    INT NOT NULL,

    CONSTRAINT fk_generations
        FOREIGN KEY (generation_id)
        REFERENCES generations(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE INDEX IF NOT EXISTS idx_complectations_generation_id ON complectations(generation_id);

COMMIT;