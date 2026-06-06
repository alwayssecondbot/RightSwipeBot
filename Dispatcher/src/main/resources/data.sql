-- ==========================================
-- 1. LOOKUPS (Geography & Mechanics)
-- ==========================================
INSERT INTO countries (code, full_name, alpha2, alpha3, flag_url)
VALUES ('276', 'Germany', 'DE', 'DEU', '/images/flags/de.webp')
ON CONFLICT (code) DO UPDATE SET
    full_name = EXCLUDED.full_name,
    alpha2 = EXCLUDED.alpha2,
    alpha3 = EXCLUDED.alpha3,
    flag_url = EXCLUDED.flag_url;

INSERT INTO cities (id, full_name, country_code)
VALUES (1,'Ingolstadt', '276'), (2, 'Wolfsburg', '276')
ON CONFLICT (id) DO UPDATE SET
    full_name = EXCLUDED.full_name,
    country_code = EXCLUDED.country_code;

INSERT INTO gearboxes (full_name, gear_quantity, type)
VALUES ('S-Tronic 7-Speed', 7, 'DCT'), ('DQ-200 7-Speed', 7, 'AMT')
ON CONFLICT (full_name) DO UPDATE SET
    full_name = EXCLUDED.full_name,
    gear_quantity = EXCLUDED.gear_quantity,
    type = EXCLUDED.type;

INSERT INTO engines (full_name, capacity, cylinders_position, cylinders_quantity, fuel_type, power, power_system, type)
VALUES ('2.0 TFSI', 1984, 'INLINE', 4, 'PETROL', 249, 'DIRECT', 'MULTICYLINDER'),
       ('2.0 DTH', 1984, 'INLINE', 4, 'PETROL', 186, 'DIRECT', 'MULTICYLINDER')
ON CONFLICT (full_name) DO UPDATE SET
    full_name = EXCLUDED.full_name,
    capacity = EXCLUDED.capacity,
    cylinders_position = EXCLUDED.cylinders_position,
    cylinders_quantity = EXCLUDED.cylinders_quantity,
    fuel_type = EXCLUDED.fuel_type,
    power = EXCLUDED.power,
    power_system = EXCLUDED.power_system,
    type = EXCLUDED.type;

-- ==========================================
-- 2. CORE CATALOG (Parents & Children)
-- ==========================================
-- Insert Concern first (assuming you removed NOT NULL from main_brand_id)
INSERT INTO concerns (id, full_name, country_code, capitalization, is_deleted)
VALUES (1, 'Volkswagen Group', '276', 80000, FALSE)
ON CONFLICT (id) DO UPDATE SET
    full_name = EXCLUDED.full_name,
    country_code = EXCLUDED.country_code,
    capitalization = EXCLUDED.capitalization,
    is_deleted = EXCLUDED.is_deleted;

-- Insert Brands linked to the Concern
INSERT INTO brands (id, full_name, short_name, country_code, concern_id, is_deleted)
VALUES
    (1, 'Audi AG', 'Audi', '276', 1, FALSE),
    (2, 'Volkswagen', 'VW', '276', 1, FALSE)
ON CONFLICT (id) DO UPDATE SET
    full_name = EXCLUDED.full_name,
    short_name = EXCLUDED.short_name,
    country_code = EXCLUDED.country_code,
    concern_id = EXCLUDED.concern_id,
    is_deleted = EXCLUDED.is_deleted;

-- Update Concern to set the Main Brand
UPDATE concerns SET main_brand_id = 2 WHERE id = 1;

-- ==========================================
-- 3. VEHICLES & VARIATIONS (Testing JSONB)
-- ==========================================
INSERT INTO models (id, full_name, brand_id)
VALUES (1,'Audi A4', 1),
       (2,'Volkswagen Passat CC', 2)
ON CONFLICT (id) DO UPDATE SET
    full_name = EXCLUDED.full_name,
    brand_id = EXCLUDED.brand_id;

INSERT INTO generations (id, full_name, model_id, car_class, year_start, is_deleted)
VALUES (1,'B9 (8W) Facelift', 1, 'D', 2019, FALSE),
       (2,'II Facelift', 2, 'D', 2020, FALSE)
ON CONFLICT (id) DO UPDATE SET
    full_name = EXCLUDED.full_name,
    model_id = EXCLUDED.model_id,
    car_class = EXCLUDED.car_class,
    year_start = EXCLUDED.year_start,
    is_deleted = EXCLUDED.is_deleted;

-- Injecting the Variation with complex JSON properties to test your records mapping
INSERT INTO variations (
    id, full_name, generation_id, engine_id, gearbox_id,
    body_type, boost_type, drive_type, engine_position,
    fuel_per_100, acl_to_100,
    body_props, susp_brake_props, other_props
) VALUES (1, '45 TFSI quattro S tronic', 1, 1, 1,
          'SEDAN', 'TURBOCHARGED', 'AWD', 'FRONT',
          68, 58,
          '{ "bodyLength": 4762, "bodyWidth": 1847, "bodyHeight": 1428, "groundClearance": 140, "wheelBase": 2820, "frontTrack": 1572, "backTrack": 1555, "doorsQuantity": 4, "seatsQuantity": 5, "curbWeight": 1545,
          "grossWeight": 2110, "minTrunkCapacity": 460, "maxTrunkCapacity": 460,"tankCapacity": 54}'::jsonb,
          '{"frontSuspensionType": "ACTIVE", "backSuspensionType": "ACTIVE", "frontBrakeType": "DISC", "backBrakeType": "DISC"}'::jsonb,
          '{"maxRange": 794, "wheelOrientation": "LEFT", "ecoClass": 6}'::jsonb),
      (2, 'Dazzling', 2, 2, 2, 'LIFTBACK', 'TURBOCHARGED', 'FWD', 'FRONT', 68, 83,
       '{ "bodyLength": 4864, "bodyWidth": 1870, "bodyHeight": 1459, "groundClearance": 152, "wheelBase": 2841, "frontTrack": 1586, "backTrack": 1572, "doorsQuantity": 5, "seatsQuantity": 5, "curbWeight": 1650,
          "grossWeight": 2110, "minTrunkCapacity": 501, "maxTrunkCapacity": 501,"tankCapacity": 66}'::jsonb,
       '{"frontSuspensionType": "ACTIVE", "backSuspensionType": "ACTIVE", "frontBrakeType": "DISC", "backBrakeType": "DISC"}'::jsonb,
       '{"maxRange": null, "wheelOrientation": "LEFT", "ecoClass": 6}'::jsonb)
ON CONFLICT (id) DO UPDATE SET
    full_name = EXCLUDED.full_name,
    generation_id = EXCLUDED.generation_id,
    engine_id = EXCLUDED.engine_id,
    gearbox_id = EXCLUDED.gearbox_id,
    body_type = EXCLUDED.body_type,
    boost_type = EXCLUDED.boost_type,
    drive_type = EXCLUDED.drive_type,
    engine_position = EXCLUDED.engine_position,
    fuel_per_100 = EXCLUDED.fuel_per_100,
    acl_to_100 = EXCLUDED.acl_to_100,
    body_props = EXCLUDED.body_props,
    susp_brake_props = EXCLUDED.susp_brake_props,
    other_props = EXCLUDED.other_props;

-- ==========================================
-- 4. PHOTOS (Testing the Metadata Strategy)
-- ==========================================
INSERT INTO generation_photos (generation_id, url, is_main, sort_order)
VALUES
    (1, '/images/cars/audi_a4_b9_main.webp', TRUE, 1),
    (1, '/images/cars/audi_a4_b9_side.webp', FALSE, 2),
    (1, '/images/cars/audi_a4_b9_interior.webp', FALSE, 3),
    (2, '/images/cars/vw_passat_cc_2_face_dazzling_main.webp', TRUE, 1),
    (2, '/images/cars/vw_passat_cc_2_face_dazzling_side.webp', FALSE, 2),
    (2, '/images/cars/vw_passat_cc_2_face_dazzling_interior.webp', FALSE, 3)
ON CONFLICT (url) DO UPDATE SET
    generation_id = EXCLUDED.generation_id,
    is_main = EXCLUDED.is_main,
    sort_order = EXCLUDED.sort_order;