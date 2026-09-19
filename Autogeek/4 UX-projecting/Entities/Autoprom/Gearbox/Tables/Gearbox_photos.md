Table which contain every [[Autogeek/4 UX-projecting/Entities/Autoprom/Gearbox/Gearbox|Gearbox]] photo.

| Field name | Data type    | Unique         | Not Null | Default | Description                                                                                |
| ---------- | ------------ | -------------- | -------- | ------- | ------------------------------------------------------------------------------------------ |
| id         | Big Serial   | PK             | +        | -       | ID                                                                                         |
| gearbox_id | Int          | FK many to one | +        | -       | id from [[Autogeek/4 UX-projecting/Entities/Autoprom/Gearbox/Tables/Gearboxes\|Gearboxes]] |
| url        | Varchar(255) | +              | +        | -       | Url to photo                                                                               |
| is_main    | boolean      | -              | +        | FALSE   | is photo main                                                                              |
| sort_order | byte         | -              | +        | 0       | order of photos                                                                            |
*Relations*:

| Mapped table                                                                       | Column     | Relation type | Fetch type | Cascade | Orhpan removal | Optional |
| ---------------------------------------------------------------------------------- | ---------- | ------------- | ---------- | ------- | -------------- | -------- |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Gearbox/Tables/Gearboxes\|Gearboxes]] | gearbox_id | Many to one   | EAGER      | REFRESH | -              | false    |
