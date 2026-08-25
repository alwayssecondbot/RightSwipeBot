Table which contains data about [[Autogeek/4 UX-projecting/Entities/Autoprom/Complectation/Complectation|complectations]]

| Field name       | Data type    | Unique         | Not Null | Default | Description                                                                                                            |
| ---------------- | ------------ | -------------- | -------- | ------- | ---------------------------------------------------------------------------------------------------------------------- |
| id               | Serial       | PK             | +        | -       | ID                                                                                                                     |
| full_name        | Varchar(100) | -              | +        | -       | Name of complectation                                                                                                  |
| generation_id    | Int          | FK many to one | +        | -       | id from [[Autogeek/4 UX-projecting/Entities/Autoprom/Generation/Tables/Generations\|generations]]                      |
| linght_props     | JSONB        | -              | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Autoprom/Complectation/Tables/JSONB/LightProps\|light props]]           |
| antitheft_props  | JSONB        | -              | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Autoprom/Complectation/Tables/JSONB/AntitheftProps\|antitheft props]]   |
| interior_props   | JSONB        | -              | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Autoprom/Complectation/Tables/JSONB/InteriorProps\|interior props]]     |
| safety_props     | JSONB        | -              | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Autoprom/Complectation/Tables/JSONB/SafetyProps\|safety props]]         |
| multimedia_props | JSONB        | -              | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Autoprom/Complectation/Tables/JSONB/MultimediaProps\|multimedia props]] |
| exterior_props   | JSONB        | -              | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Autoprom/Complectation/Tables/JSONB/ExteriorProps\|exterior props]]     |
*Relations*:

| Mapped table                                                                              | Column        | Relation type | Fetch type | Cascade | Orhpan removal | Optional |
| ----------------------------------------------------------------------------------------- | ------------- | ------------- | ---------- | ------- | -------------- | -------- |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Generation/Tables/Generations\|Generations]] | generation_id | Many to one   | LAZY       | REFRESH | -              | false    |
| [[Autogeek/4 UX-projecting/Entities/Users/Report/Tables/Reports\|Reports]]                | -             | One to many   | LAZY       | ALL     | true           | -        |
