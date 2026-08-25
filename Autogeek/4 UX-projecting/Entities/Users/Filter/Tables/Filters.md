Table with data about [[Autogeek/4 UX-projecting/Entities/Users/Filter/Filter|filters]].

| Field name          | Data type   | Unique         | Not Null | Default | Description                                                                                                        |
| ------------------- | ----------- | -------------- | -------- | ------- | ------------------------------------------------------------------------------------------------------------------ |
| id                  | Big Serial  | PK             | +        | -       | ID                                                                                                                 |
| account_id          | Int         | FK many to one | +        | -       | Id from [[Autogeek/4 UX-projecting/Entities/Users/Account/Tables/Accounts\|accounts]]                              |
| full_name           | Varchar(50) | -              | +        | -       | Full name                                                                                                          |
| primary_props       | JSONB       | -              | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Users/Filter/Tables/JSONB/PrimaryProps\|primary_props]]             |
| complectation_props | JSONB       | -              | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Users/Filter/Tables/JSONB/ComplectationProps\|complectation_props]] |
| offer_props         | JSONB       | -              | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Users/Filter/Tables/JSONB/OfferProps\|offer_props]]                 |
| body_props          | JSONB       | -              | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Users/Filter/Tables/JSONB/BodyProps\|body_props]]                   |
| engine_props        | JSONB       | -              | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Users/Filter/Tables/JSONB/EngineProps\|engine_props]]               |
| gearbox_props       | JSONB       | -              | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Users/Filter/Tables/JSONB/GearboxProps\|gearbox_props]]             |
| brake_n_susp_props  | JSONB       | -              | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Users/Filter/Tables/JSONB/BrakeNSuspProps\|brake_n_susp_props]]     |
| other_props         | JSONB       | -              | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Users/Filter/Tables/JSONB/OtherProps\|other_props]]                 |
*Relations*:

| Mapped table                                                                  | Column     | Relation type | Fetch type | Cascade | Orhpan removal | Optional |
| ----------------------------------------------------------------------------- | ---------- | ------------- | ---------- | ------- | -------------- | -------- |
| [[Autogeek/4 UX-projecting/Entities/Users/Account/Tables/Accounts\|Accounts]] | account_id | Many to one   | EAGER      | REFRESH | -              | false    |
