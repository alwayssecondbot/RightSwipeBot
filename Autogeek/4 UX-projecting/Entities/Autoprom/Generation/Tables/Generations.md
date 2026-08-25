Table which contains data about [[Autogeek/4 UX-projecting/Entities/Autoprom/Generation/Generation|generations]]

| Field name           | Data type    | Unique         | Not Null | Default | Description                                                                                                       |
| -------------------- | ------------ | -------------- | -------- | ------- | ----------------------------------------------------------------------------------------------------------------- |
| id                   | Serial       | PK             | +        | -       | ID                                                                                                                |
| full_name            | Varchar(100) | +              | +        | -       | Full name                                                                                                         |
| model_id             | Int          | FK many to one | +        | -       | model which generation belongs to from [[Autogeek/4 UX-projecting/Entities/Autoprom/Model/Tables/Models\|models]] |
| car_class            | Varchar(255) | -              | -        | -       | car_class_id from [[Autogeek/4 UX-projecting/Entities/Autoprom/Generation/Tables/enums/CarClass\|car_classes]]    |
| year_start           | Smallint     | -              | -        | -       | start of construction                                                                                             |
| year_stop            | Smallint     | -              | -        | -       | end of construction                                                                                               |
| produced_auto        | Int          | -              | -        | -       | how many were produced                                                                                            |
| sold_auto            | Int          | -              | -        | -       | how many were sold                                                                                                |
| description_n_review | Text         | -              | -        | -       | Description + review                                                                                              |
| price_max            | Int          | -              | -        | -       | Prices max from [[Autogeek/4 UX-projecting/Entities/Users/Offer/Tables/Offers\|offers]]                           |
| price_min            | Int          | -              | -        | -       | Prices min from [[Autogeek/4 UX-projecting/Entities/Users/Offer/Tables/Offers\|offers]]                           |
*Relations*:

| Mapped table                                                                                            | Column   | Relation type | Fetch type | Cascade | Orhpan removal | Optional |
| ------------------------------------------------------------------------------------------------------- | -------- | ------------- | ---------- | ------- | -------------- | -------- |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Model/Tables/Models\|Models]]                              | model_id | Many to one   | EAGER      | REFRESH | -              | false    |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Generation/Tables/Generation_photos\|Generation_photos]]   | -        | One to many   | EAGER      | ALL     | true           | -        |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Complectation/Tables/Complectations\|Complectations]]      | -        | One to many   | LAZY       | ALL     | true           | -        |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/Variations\|Variations]]                  | -        | One to many   | LAZY       | ALL     | true           | -        |
| [[Autogeek/4 UX-projecting/Extra Tables/Liked/Tables/Liked_generations\|Liked_generations]]             | -        | One to many   | LAZY       | ALL     | true           | -        |
| [[Autogeek/4 UX-projecting/Extra Tables/Favourite/Tables/Favourite_generations\|Favourite_generations]] | -        | One to many   | LAZY       | ALL     | true           | -        |
| [[Autogeek/4 UX-projecting/Entities/Users/Report/Tables/Reports\|Reports]]                              | -        | One to many   | LAZY       | ALL     | true           | -        |
