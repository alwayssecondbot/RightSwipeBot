Table which contains information about [[Autogeek/4 UX-projecting/Entities/Users/Report/Report|reports]].

| Field name       | Data type                  | Unique         | Not Null | Default | Description                                                                                                  |
| ---------------- | -------------------------- | -------------- | -------- | ------- | ------------------------------------------------------------------------------------------------------------ |
| id               | Big serial                 | PK             | +        | -       | Id                                                                                                           |
| account_id       | Int                        | FK many to one | +        | -       | Account id from table [[Autogeek/4 UX-projecting/Entities/Users/Account/Tables/Accounts\|accounts]]          |
| generation_id    | Int                        | FK many to one | +        | -       | Generation id from [[Autogeek/4 UX-projecting/Entities/Autoprom/Generation/Tables/Generations\|generations]] |
| variation_id     | Int                        | FK many to one | -        | -       | Variation id from [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/Variations\|variations]]     |
| complectation_id | Int                        | FK many to one | -        | -       | id from [[Autogeek/4 UX-projecting/Entities/Autoprom/Complectation/Tables/Complectations\|complectations]]   |
| description      | Text                       | -              | +        | -       | Description of report                                                                                        |
| creation_date    | Timestamp without timezone | -              | +        | NOW()   | Creation date                                                                                                |
| rating           | JSONB                      | -              | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/JSONB/Rating\|rating]]              |
*Relations*:

| Mapped table                                                                                       | Column           | Relation type | Fetch type | Cascade | Orhpan removal | Optional |
| -------------------------------------------------------------------------------------------------- | ---------------- | ------------- | ---------- | ------- | -------------- | -------- |
| [[Autogeek/4 UX-projecting/Entities/Users/Account/Tables/Accounts\|Accounts]]                      | account_id       | Many to one   | EAGER      | REFRESH | -              | false    |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Generation/Tables/Generations\|Generations]]          | generation_id    | Many to one   | EAGER      | REFRESH | -              | false    |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/Variations\|Variations]]             | variation_id     | Many to one   | EAGER      | REFRESH | -              | true     |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Complectation/Tables/Complectations\|Complectations]] | complectation_id | Many to one   | EAGER      | REFRESH | -              | true     |
| [[Autogeek/4 UX-projecting/Entities/Users/Report/Tables/Report_photos\|Report_photos]]             | -                | One to many   | EAGER      | ALL     | true           | -        |
