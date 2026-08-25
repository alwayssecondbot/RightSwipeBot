Table which contains information about [[Autogeek/4 UX-projecting/Entities/Users/Account/Account|accounts]].

| Field name     | Data type               | Unique         | Not Null | Default | Description                                                                                |
| -------------- | ----------------------- | -------------- | -------- | ------- | ------------------------------------------------------------------------------------------ |
| id             | Big serial              | PK             | +        | -       | ID                                                                                         |
| mail           | Varchar(100)            | +              | -        | -       | Email                                                                                      |
| login          | Varchar(100)            | +              | +        | -       | Login                                                                                      |
| phone_number   | Varchar(30)             | +              | -        | -       | Phone_number                                                                               |
| full_name      | Varchar (250)           | -              | -        | -       | Full name                                                                                  |
| birthday       | Date                    | -              | -        | -       | Birth date                                                                                 |
| photo_url      | Varchar(255)            | +              | -        | -       | Profile photo link                                                                         |
| is_corporation | Boolean                 | -              | +        | False   | Is account a corporation                                                                   |
| create_at      | DATE                    | -              | +        | Now()   | Account create date                                                                        |
| last_online    | Timestamp with timezone | -              | +        | Now()   | Last login                                                                                 |
| country_code   | VARCHAR(3)              | FK many to one | -        | -       | code from [[Autogeek/4 UX-projecting/Entities/Global/Country/Tables/Countries\|countries]] |
| drive_since    | Date                    | -              | -        | -       | Driving since                                                                              |
| is_verified    | Boolean                 | -              | +        | False   | Is account verified                                                                        |
*Relations*:

| Mapped table                                                                                            | Column       | Relation type | Fetch type | Cascade | Orhpan removal | Optional |
| ------------------------------------------------------------------------------------------------------- | ------------ | ------------- | ---------- | ------- | -------------- | -------- |
| [[Autogeek/4 UX-projecting/Entities/Global/Country/Tables/Countries\|Countries]]                        | country_code | Many to one   | EAGER      | REFRESH | -              | false    |
| [[Autogeek/4 UX-projecting/Entities/Users/Filter/Tables/Filters\|Filters]]                              | -            | One to many   | LAZY       | ALL     | true           | -        |
| [[Autogeek/4 UX-projecting/Entities/Users/Offer/Tables/Offers\|Offers]]                                 | -            | One to many   | LAZY       | ALL     | true           | -        |
| [[Autogeek/4 UX-projecting/Entities/Users/Report/Tables/Reports\|Reports]]                              | -            | One to many   | LAZY       | ALL     | true           | -        |
| [[Autogeek/4 UX-projecting/Entities/Users/Review/Tables/Reviews\|Reviews]]                              | -            | One to many   | LAZY       | ALL     | true           | -        |
| [[Autogeek/4 UX-projecting/Extra Tables/Favourite/Tables/Favourite_generations\|Favourite_generations]] | -            | One to many   | LAZY       | ALL     | true           | -        |
| [[Autogeek/4 UX-projecting/Extra Tables/Favourite/Tables/Favourite_variations\|Favourite_variations]]   | -            | One to many   | LAZY       | ALL     | true           | -        |
| [[Autogeek/4 UX-projecting/Extra Tables/Liked/Tables/Liked_models\|Liked_models]]                       | -            | One to many   | LAZY       | ALL     | true           | -        |
| [[Autogeek/4 UX-projecting/Extra Tables/Liked/Tables/Liked_generations\|Liked_generations]]             | -            | One to many   | LAZY       | ALL     | true           | -        |
| [[Autogeek/4 UX-projecting/Extra Tables/Liked/Tables/Liked_variations\|Liked_variations]]               | -            | One to many   | LAZY       | ALL     | true           | -        |
| [[Autogeek/4 UX-projecting/Extra Tables/Liked/Tables/Liked_offers\|Liked_offers]]                       | -            | One to many   | LAZY       | ALL     | true           | -        |
