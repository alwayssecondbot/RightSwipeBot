Tables which contains data about [[Autogeek/4 UX-projecting/Entities/Autoprom/Brand/Brand|brands]].

| Field name          | Data type    | Unique         | Not Null | Default | Description                                                                                        |
| ------------------- | ------------ | -------------- | -------- | ------- | -------------------------------------------------------------------------------------------------- |
| id                  | Small serial | PK             | +        | -       | ID                                                                                                 |
| short_name          | Varchar(50)  | +              | +        | -       | Short name                                                                                         |
| full_name           | Varchar(100) | +              | +        | -       | Full name                                                                                          |
| country_code        | Varchar(3)   | FK many to one | +        | -       | Country code from [[Autogeek/4 UX-projecting/Entities/Global/Country/Tables/Countries\|countries]] |
| concern_id          | Small int    | FK many to one | +        | -       | Concern id from [[Autogeek/4 UX-projecting/Entities/Autoprom/Concern/Tables/Сoncerns\|concerns]]   |
| logo_url            | Varchar(255) | +              | -        | -       | Logo brand                                                                                         |
| capitalization      | Int          | -              | -        | -       | Capitalization (mil $)                                                                             |
| growth              | Bytea        | -              | -        | -       | Grows of capitalization (%) in 3 year period                                                       |
| description_history | Text         | -              | -        | -       | Brand's description and history                                                                    |
| produced_auto       | Int          | -              | -        | -       | Cars produced (last year)                                                                          |
| sold_auto           | Int          | -              | -        | -       | Cars sold (last year)                                                                              |
*Relations*:

| Mapped table                                                                     | Column       | Relation type | Fetch type | Cascade | Orhpan removal | Optional |
| -------------------------------------------------------------------------------- | ------------ | ------------- | ---------- | ------- | -------------- | -------- |
| [[Autogeek/4 UX-projecting/Entities/Global/Country/Tables/Countries\|Countries]] | country_code | Many to one   | EAGER      | REFRESH | -              | false    |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Concern/Tables/Сoncerns\|Сoncerns]] | concern_id   | Many to one   | EAGER      | REFRESH | -              | false    |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Model/Tables/Models\|Models]]       | -            | One to many   | LAZY       | ALL     | true           | -        |