Table which contain every [[Autogeek/4 UX-projecting/Entities/Users/Offer/Offer|Offer]] photo.

| Field name | Data type    | Unique         | Not Null | Default | Description                                                                     |
| ---------- | ------------ | -------------- | -------- | ------- | ------------------------------------------------------------------------------- |
| id         | Big Serial   | PK             | +        | -       | ID                                                                              |
| offer_id   | Int          | FK many to one | +        | -       | id from [[Autogeek/4 UX-projecting/Entities/Users/Offer/Tables/Offers\|Offers]] |
| url        | Varchar(255) | +              | +        | -       | Url to photo                                                                    |
| is_main    | boolean      | -              | +        | FALSE   | is photo main                                                                   |
| sort_order | byte         | -              | +        | 0       | order of photos                                                                 |
*Relations*:

| Mapped table                                                            | Column   | Relation type | Fetch type | Cascade | Orhpan removal | Optional |
| ----------------------------------------------------------------------- | -------- | ------------- | ---------- | ------- | -------------- | -------- |
| [[Autogeek/4 UX-projecting/Entities/Users/Offer/Tables/Offers\|Offers]] | offer_id | Many to one   | EAGER      | REFRESH | -              | false    |
