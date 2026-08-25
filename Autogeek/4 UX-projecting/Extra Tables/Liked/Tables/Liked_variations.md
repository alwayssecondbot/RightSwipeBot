Contains liked variations

| Field name   | Data type | Unique | Not Null | Default | Description                                                                                              |
| ------------ | --------- | ------ | -------- | ------- | -------------------------------------------------------------------------------------------------------- |
| account_id   | Big int   | -      | +        | -       | account id from [[Autogeek/4 UX-projecting/Entities/Users/Account/Tables/Accounts\|Accounts]]            |
| variation_id | Int       | -      | +        | -       | variation id from [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/Variations\|Variations]] |

*Relations:*

| Mapped entity                                                                         | Column       | Relation type | Fetch type | Cascade | Orhpan removal | Optional |
| ------------------------------------------------------------------------------------- | ------------ | ------------- | ---------- | ------- | -------------- | -------- |
| [[Autogeek/4 UX-projecting/Entities/Users/Account/Account\|Account]]                  | account_id   | Many to one   | EAGER      | REFRESH | -              | false    |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/Variations\|Variation]] | variation_id | Many to one   | EAGER      | REFRESH | -              | false    |
