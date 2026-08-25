Table which contains information about [[Autogeek/4 UX-projecting/Entities/Users/Specialist/Specialist|Specialist]].

| Field name   | Data type               | Unique         | Not Null | Default | Description                                                                                |
| ------------ | ----------------------- | -------------- | -------- | ------- | ------------------------------------------------------------------------------------------ |
| id           | Bigint                  | PK             | +        | -       | ID                                                                                         |
| mail         | Varchar(100)            | +              | -        | -       | Email                                                                                      |
| login        | Varchar(100)            | +              | +        | -       | Login                                                                                      |
| full_name    | Varchar (250)           | -              | -        | -       | Full name                                                                                  |
| photo_url    | Varchar(255)            | +              | -        | -       | Profile photo link                                                                         |
| create_at    | DATE                    | -              | +        | Now()   | Account create date                                                                        |
| last_online  | Timestamp with timezone | -              | +        | Now()   | Last login                                                                                 |
| country_code | VARCHAR(3)              | FK many to one | -        | -       | code from [[Autogeek/4 UX-projecting/Entities/Global/Country/Tables/Countries\|countries]] |
| is_verified  | Boolean                 | -              | +        | False   | Is account verified                                                                        |
| description  | TEXT                    | -              | -        | -       | Description                                                                                |
*Relations*:

| Mapped entity                                                                  | Column       | Relation type | Fetch type | Cascade | Orhpan removal | Optional |
| ------------------------------------------------------------------------------ | ------------ | ------------- | ---------- | ------- | -------------- | -------- |
| [[Autogeek/4 UX-projecting/Entities/Global/Country/Tables/Countries\|Country]] | country_code | Many to one   | EAGER      | REFRESH | -              | false    |
| [[Autogeek/4 UX-projecting/Entities/Users/Article/Tables/Articles\|Article]]   | -            | One to many   | LAZY       | ALL     | true           | -        |
