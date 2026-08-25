Contains favourite generations

| Field name    | Data type | Unique | Not Null | Default | Description                                                                                                  |
| ------------- | --------- | ------ | -------- | ------- | ------------------------------------------------------------------------------------------------------------ |
| account_id    | Big int   | -      | +        | -       | account id from [[Autogeek/4 UX-projecting/Entities/Users/Account/Tables/Accounts\|Accounts]]                |
| generation_id | Int       | -      | +        | -       | generation id from [[Autogeek/4 UX-projecting/Entities/Autoprom/Generation/Tables/Generations\|Generations]] |

*Relations:*

| Mapped entity                                                                            | Column        | Relation type | Fetch type | Cascade | Orhpan removal | Optional |
| ---------------------------------------------------------------------------------------- | ------------- | ------------- | ---------- | ------- | -------------- | -------- |
| [[Autogeek/4 UX-projecting/Entities/Users/Account/Account\|Account]]                     | account_id    | Many to one   | EAGER      | REFRESH | -              | false    |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Generation/Tables/Generations\|Generation]] | generation_id | Many to one   | EAGER      | REFRESH | -              | false    |
