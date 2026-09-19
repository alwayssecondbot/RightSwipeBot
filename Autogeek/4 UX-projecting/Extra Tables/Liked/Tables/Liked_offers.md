Contains liked offers

| Field name | Data type | Unique | Not Null | Default | Description                                                                                   |
| ---------- | --------- | ------ | -------- | ------- | --------------------------------------------------------------------------------------------- |
| account_id | Big int   | -      | +        | -       | account id from [[Autogeek/4 UX-projecting/Entities/Users/Account/Tables/Accounts\|Accounts]] |
| offer_id   | Int       | -      | +        | -       | variation id from [[Autogeek/4 UX-projecting/Entities/Users/Offer/Tables/Offers\|Offers]]     |

*Relations:*

| Mapped entity                                                          | Column     | Relation type | Fetch type | Cascade | Orhpan removal | Optional |
| ---------------------------------------------------------------------- | ---------- | ------------- | ---------- | ------- | -------------- | -------- |
| [[Autogeek/4 UX-projecting/Entities/Users/Account/Account\|Account]]   | account_id | Many to one   | EAGER      | REFRESH | -              | false    |
| [[Autogeek/4 UX-projecting/Entities/Users/Offer/Tables/Offers\|Offer]] | offer_id   | Many to one   | EAGER      | REFRESH | -              | false    |
