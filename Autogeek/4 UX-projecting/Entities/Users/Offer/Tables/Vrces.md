Contains vehicle registration certificates.

| Column name   | Data type  | Unique | Not Null | Default | Description         |
| ------------- | ---------- | ------ | -------- | ------- | ------------------- |
| id            | Big serial | PK     | +        | -       | ID                  |
| is_original   | Boolean    | -      | +        | false   | Is vrs original     |
| produced_date | Date       | -      | +        | -       | Year of manufacture |
| owners        | JSONB      | -      | +        | -       | Owners              |
*Relations*:

| Mapped table                                                            | Column | Relation type | Fetch type | Cascade | Orhpan removal | Optional |
| ----------------------------------------------------------------------- | ------ | ------------- | ---------- | ------- | -------------- | -------- |
| [[Autogeek/4 UX-projecting/Entities/Users/Offer/Tables/Offers\|Offers]] | -      | One to one    | LAZY       | ALL     | true           | false    |
