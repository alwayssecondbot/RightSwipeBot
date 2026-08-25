Table which containc properties of [[Autogeek/4 UX-projecting/Entities/Autoprom/Engine/Engine|engines]].

| Field name          | Data type    | Unique         | Not Null | Default | Description                                                                                                                            |
| ------------------- | ------------ | -------------- | -------- | ------- | -------------------------------------------------------------------------------------------------------------------------------------- |
| id                  | Serial       | PK             | +        | -       | ID                                                                                                                                     |
| full_name           | Varchar(250) | +              | +        | -       | Full name                                                                                                                              |
| parent_id           | Int          | FK one to many | -        | -       | Engine parent id from [[Autogeek/4 UX-projecting/Entities/Autoprom/Engine/Tables/Engines\|engines]]                                    |
| capacity            | Smallint     | -              | -        | -       | Engine capacity                                                                                                                        |
| type                | Varchar(255) | -              | -        | -       | Engine type from [[Autogeek/4 UX-projecting/Entities/Autoprom/Engine/Tables/enums/EngineType\|EngineTypes]]                            |
| power_system        | Varchar(255) | -              | -        | -       | Engine power system type from [[Autogeek/4 UX-projecting/Entities/Autoprom/Engine/Tables/enums/EnginePowerSystem\|EnginePowerSystems]] |
| power               | Smallint     | -              | -        | -       | Engine power (h.p.)                                                                                                                    |
| torque              | Smallint     | -              | -        | -       | Torque (N\*m)                                                                                                                          |
| cylinders_position  | Varchar(255) | -              | -        | -       | Cylinders position from [[Autogeek/4 UX-projecting/Entities/Autoprom/Engine/Tables/enums/CylindersPosition\|CylindersPositions]]       |
| cylinders_quantity  | bytea        | -              | -        | -       | Cylingers_quantity                                                                                                                     |
| valves_per_cylinder | bytea        | -              | -        | -       | Valves per cylinder                                                                                                                    |
| compression_ratio   | bytea        | -              | -        | -       | Compression ratio                                                                                                                      |
| cylinders_diameter  | Smallint     | -              | -        | -       | Cylinders diameter                                                                                                                     |
| piston_stroke       | Smallint     | -              | -        | -       | Piston stroke                                                                                                                          |
| fuel_type           | Varchar(255) | -              | -        | -       | Fuel type from [[Autogeek/4 UX-projecting/Entities/Autoprom/Engine/Tables/enums/FuelType\|FuelTypes]]                                  |
| co2_emission        | Smallint     | -              | -        | -       | СО2 emission (g/km)                                                                                                                    |
| review              | Text         | -              | -        | -       | review                                                                                                                                 |
*Relations*:

| Mapped table                                                                              | Column           | Relation type | Fetch type | Cascade | Orhpan removal |
| ----------------------------------------------------------------------------------------- | ---------------- | ------------- | ---------- | ------- | -------------- |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Engine/Tables/Engines\|Engines]]             | engine_parent_id | Many to one   | LAZY       | REFRESH | -              |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Engine/Tables/Engine_photos\|Engine_photos]] | -                | One to many   | EAGER      | ALL     | true           |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Engine/Tables/Engines\|Engines]]             | -                | One to many   | LAZY       | ALL     | true           |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/Variations\|Variations]]    | -                | One to many   | LAZY       | ALL     | true           |
