Table which contains data about [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Variation|variations]]

| Имя поля           | Тип данных   | Unique         | Not Null | Default | Описание                                                                                                                  |
| ------------------ | ------------ | -------------- | -------- | ------- | ------------------------------------------------------------------------------------------------------------------------- |
| id                 | Serial       | PK             | +        | -       | ID                                                                                                                        |
| full_name          | Varchar(100) | +              | +        | -       | Full name                                                                                                                 |
| generation_id      | Int          | FK many to one | +        | -       | Generation id from [[Autogeek/4 UX-projecting/Entities/Autoprom/Generation/Tables/Generations\|generations]]              |
| body_type          | Varchar(255) | -              | -        | -       | Body type from [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/enums/BodyType\|BodyType]]                   |
| drive_type         | Varchar(255) | -              | -        | -       | Drive type from [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/enums/DriveType\|DriveType]]                |
| engine_id          | Int          | FK many to one | -        | -       | Engine id from [[Autogeek/4 UX-projecting/Entities/Autoprom/Engine/Tables/Engines\|engines]]                              |
| boost_type         | Varchar(255) | -              | -        | -       | Boost type from [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/enums/BoostType\|BoostTypes]]               |
| engine_position    | Varchar(255) | -              | -        | -       | Engine position from [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/enums/EnginePosition\|EnginePosition]] |
| gearbox_id         | Int          | FK many to one | -        | -       | Gearbox id from [[Autogeek/4 UX-projecting/Entities/Autoprom/Gearbox/Tables/Gearboxes\|gearboxes]]                        |
| rating             | JSONB        | -              | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/JSONB/Rating\|Rating]]                           |
| body_props         | JSONB        | -              | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/JSONB/BodyProps\|BodyProps]]                     |
| susp_brake_props   | JSONB        | -              | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/JSONB/SuspBrakeProps\|SuspBrakeProps]]           |
| other_props        | JSONB        | -              | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/JSONB/OtherProps\|OtherProps]]                   |
| description_review | Text         | -              | -        | -       | Description and review                                                                                                    |
| acl_to_100         | bytea        | -              | -        | -       | Acceleration to 100 (s/10)                                                                                                |
| fuel_per_100       | bytea        | -              | -        | -       | Fuel consumption per 100 km (l);                                                                                          |
*Relations*:

| Mapped table                                                                                          | Column        | Relation type | Fetch type | Cascade | Orhpan removal | Optional |
| ----------------------------------------------------------------------------------------------------- | ------------- | ------------- | ---------- | ------- | -------------- | -------- |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Generation/Tables/Generations\|Generations]]             | generation_id | Many to one   | LAZY       | REFRESH | -              | false    |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Engine/Tables/Engines\|Engines]]                         | engine_id     | Many to one   | LAZY       | REFRESH | -              | true     |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Gearbox/Tables/Gearboxes\|Gearboxes]]                    | engine_id     | Many to one   | LAZY       | REFRESH | -              | true     |
| [[Autogeek/4 UX-projecting/Extra Tables/Liked/Tables/Liked_variations\|Liked_variations]]             | -             | One to many   | LAZY       | ALL     | true           | -        |
| [[Autogeek/4 UX-projecting/Extra Tables/Favourite/Tables/Favourite_variations\|Favourite_variations]] | -             | One to many   | LAZY       | ALL     | true           | -        |
| [[Autogeek/4 UX-projecting/Entities/Users/Report/Tables/Reports\|Reports]]                            | -             | One to many   | LAZY       | ALL     | true           | -        |
