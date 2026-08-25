Tables which contains data about [[Autogeek/4 UX-projecting/Entities/Autoprom/Model/Model|models]].

| Field name          | Data type    | Unique         | Not Null | Default | Description                                                                                 |
| ------------------- | ------------ | -------------- | -------- | ------- | ------------------------------------------------------------------------------------------- |
| id                  | Serial       | PK             | +        | -       | ID                                                                                          |
| full_name           | Varchar(100) | +              | +        | -       | Full name                                                                                   |
| brand_id            | Small int    | FK many to one | +        | -       | Brand-owner from [[Autogeek/4 UX-projecting/Entities/Autoprom/Brand/Tables/Brands\|brands]] |
| description_history | Text         | -              | -        | -       | Description and history                                                                     |
*Relations*:

| Mapped table                                                                              | Column   | Relation type | Fetch type | Cascade | Orhpan removal | Optional |
| ----------------------------------------------------------------------------------------- | -------- | ------------- | ---------- | ------- | -------------- | -------- |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Brand/Tables/Brands\|Brands]]                | brand_id | Many to one   | EAGER      | REFRESH | -              | false    |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Generation/Tables/Generations\|Generations]] | -        | One to many   | LAZY       | ALL     | true           | -        |
| [[Autogeek/4 UX-projecting/Extra Tables/Liked/Tables/Liked_models\|Liked_models]]         | -        | One to many   | LAZY       | ALL     | true           | -        |
