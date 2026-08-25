[[JPA/entity/Entity|Entity]], which describes a review of the entities. 
A review can be created by user. It contains detailed description of cars properties and functions. Unlike reports, review can be created only by user who has a car specialist marker. *how it can be designed*

*Table in DB* - [[Autogeek/4 UX-projecting/Entities/Users/Review/Tables/Reviews|Reviews]].

*Full view:*

| Field name    | Description                     |
| ------------- | ------------------------------- |
| Creation date | creation_date                   |
| Author name   | account_id                      |
| Car name      | variation_id + complectation_id |
| Photos        | -                               |
| Description   | description                     |
| Rating        | rating                          |
*Short view:*

| Field name    | Description                     |
| ------------- | ------------------------------- |
| Author name   | account_id                      |
| Car name      | variation_id + complectation_id |
| Creation date | creation_date                   |
| Photos        | -                               |


[[Autogeek/4 UX-projecting/Entity list|Full and short views]].

Can be shown as [[Autogeek/4 UX-projecting/Entity list|entity list]].