[[Autogeek/4 UX-projecting/Entity|Entity]] which represent generation of car model.

*Table in DB* - [[Autogeek/4 UX-projecting/Entities/Autoprom/Generation/Tables/Generations|Generations]].

*Full view:*

| Description                                                                                                               | Field name                      |
| ------------------------------------------------------------------------------------------------------------------------- | ------------------------------- |
| Full name                                                                                                                 | full_name                       |
| Generation photos                                                                                                         | -                               |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Model/Model\|Models]] name-link                                              | model_id                        |
| Car class                                                                                                                 | car_class                       |
| Years of producing                                                                                                        | year_start - year_stop          |
| Description and review                                                                                                    | description_n_review            |
| Amount of produced autos                                                                                                  | produced_auto                   |
| Amount of sold autos                                                                                                      | sold_auto                       |
| Prices range                                                                                                              | prices_range                    |
| Table with [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Variation\|variations]] and properties                  | -                               |
| Table with name-links of [[Autogeek/4 UX-projecting/Entities/Autoprom/Complectation/Complectation\|complectations]]       | -                               |
| List of [[Autogeek/4 UX-projecting/Entities/Users/Report/Report\|reports]] in short view                                  | -                               |
| List with name-links of [[Autogeek/4 UX-projecting/Entities/Global/Country/Country\|countries]]  where autos are produced | *think about realization later* |

*Short view:*

| Description                                                                  | Field name |
| ---------------------------------------------------------------------------- | ---------- |
| Full name                                                                    | full_name  |
| Generation photos                                                            | -          |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Brand/Brand\|Brands]] name-link | brand_id   |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Model/Model\|Models]] name-link | model_id   |
[[Autogeek/4 UX-projecting/Entity list|Full and short views]].

Can be shown as [[Autogeek/4 UX-projecting/Entity list|entity list]].