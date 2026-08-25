Table which contains information about [[Autogeek/4 UX-projecting/Entities/Users/Article/Article|articles]].

| Field name     | Data type    | Unique         | Not Null | Default | Description                                                                                           |
| -------------- | ------------ | -------------- | -------- | ------- | ----------------------------------------------------------------------------------------------------- |
| id             | Big serial   | PK             | +        | -       | Id                                                                                                    |
| specialist_id  | Big int      | FK many to one | +        | -       | Author id from [[Autogeek/4 UX-projecting/Entities/Users/Specialist/Tables/Specialists\|Specialists]] |
| title          | Varchar(255) | -              | +        | -       | Title                                                                                                 |
| main_photo_url | Varchar(255) | +              | -        | -       | Main photo                                                                                            |
| content        | Text         | -              | +        | -       | Description of report                                                                                 |
| creation_date  | DATE         | -              | +        | NOW()   | Creation date                                                                                         |
| rating         | JSONB        | -              | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/JSONB/Rating\|Rating]]       |
*Relations*:

| Mapped table                                                                                          | Column        | Relation type | Fetch type | Cascade | Orhpan removal | Optional |
| ----------------------------------------------------------------------------------------------------- | ------------- | ------------- | ---------- | ------- | -------------- | -------- |
| [[Autogeek/4 UX-projecting/Entities/Users/Specialist/Tables/Specialists\|Specialists]]                | specialist_id | Many to one   | EAGER      | REFRESH | -              | false    |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Generation/Tables/Generation_photos\|Generation_photos]] | -             | One to many   | EAGER      | ALL     | true           | -        |
