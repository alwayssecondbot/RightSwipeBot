Contains liked models

| Field name | Data type | Unique | Not Null | Default | Description                                                                                   |
| ---------- | --------- | ------ | -------- | ------- | --------------------------------------------------------------------------------------------- |
| account_id | Big int   | -      | +        | -       | account id from [[Autogeek/4 UX-projecting/Entities/Users/Account/Tables/Accounts\|Accounts]] |
| model_id   | Int       | -      | +        | -       | variation id from [[Autogeek/4 UX-projecting/Entities/Autoprom/Model/Tables/Models\|Models]]  |
*Relations:*

| Mapped entity                                                              | Column     | Relation type | Fetch type | Cascade | Orhpan removal | Optional |
| -------------------------------------------------------------------------- | ---------- | ------------- | ---------- | ------- | -------------- | -------- |
| [[Autogeek/4 UX-projecting/Entities/Users/Account/Account\|Account]]       | account_id | Many to one   | EAGER      | REFRESH | -              | false    |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Model/Tables/Models\|Models]] | model_id   | Many to one   | EAGER      | REFRESH | -              | false    |
