Table which contain every [[Autogeek/4 UX-projecting/Entities/Users/Review/Review|Review]] photo.

| Field name | Data type    | Unique         | Not Null | Default | Description                                                                        |
| ---------- | ------------ | -------------- | -------- | ------- | ---------------------------------------------------------------------------------- |
| id         | Big Serial   | PK             | +        | -       | ID                                                                                 |
| review_id  | Int          | FK many to one | +        | -       | id from [[Autogeek/4 UX-projecting/Entities/Users/Review/Tables/Reviews\|Reviews]] |
| url        | Varchar(255) | +              | +        | -       | Url to photo                                                                       |
| is_main    | boolean      | -              | +        | FALSE   | is photo main                                                                      |
| sort_order | byte         | -              | +        | 0       | order of photos                                                                    |
*Relations*:

| Mapped table                                                               | Column    | Relation type | Fetch type | Cascade | Orhpan removal | Optional |
| -------------------------------------------------------------------------- | --------- | ------------- | ---------- | ------- | -------------- | -------- |
| [[Autogeek/4 UX-projecting/Entities/Users/Review/Tables/Reviews\|Reviews]] | review_id | Many to one   | EAGER      | REFRESH | -              | false    |
