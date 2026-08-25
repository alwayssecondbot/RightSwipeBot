Table which contains data about [[Autogeek/4 UX-projecting/Entities/Autoprom/Concern/Concern|concerns]].

| Field name          | Data type    | Unique         | Not Null | Default | Description                                                                                    |
| ------------------- | ------------ | -------------- | -------- | ------- | ---------------------------------------------------------------------------------------------- |
| id                  | Small serial | PK             | +        | -       | ID                                                                                             |
| short_name          | Varchar(50)  | +              | +        | -       | Short name                                                                                     |
| full_name           | Varchar(100) | +              | +        | -       | Full name                                                                                      |
| logo_url            | Varchar(255) | +              | -        | -       | Concens logo                                                                                   |
| country_code        | Varchar(3)   | FK many to one | +        | -       | iso_code from [[Autogeek/4 UX-projecting/Entities/Global/Country/Tables/Countries\|countries]] |
| main_brand_id       | Int          | FK one to one  | +        | -       | brand_id from [[Autogeek/4 UX-projecting/Entities/Autoprom/Brand/Tables/Brands\|brands]]       |
| capitalization      | Int          | -              | -        | -       | Capitalization (bil $)                                                                         |
| grows               | Bytea        | -              | -        | -       | Grows of capitalization (%) in 3 year period                                                   |
| description_history | Text         | -              | -        | -       | Concern's description and history                                                              |
*Relations*:

| Mapped table                                                                     | Column        | Relation type | Fetch type | Cascade        | Orhpan removal | Optional |
| -------------------------------------------------------------------------------- | ------------- | ------------- | ---------- | -------------- | -------------- | -------- |
| [[Autogeek/4 UX-projecting/Entities/Global/Country/Tables/Countries\|Countries]] | country_code  | Many to one   | EAGER      | REFRESH        | -              | false    |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Brand/Tables/Brands\|Brands]]       | main_brand_id | One to one    | EAGER      | PERSIST, MERGE | -              | false    |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Brand/Tables/Brands\|Brands]]       | -             | One to many   | LAZY       | ALL            | true           | -        |
