Table which contains data about [[Autogeek/4 UX-projecting/Entities/Global/Country/Tables/Countries|countries]].

| Field name | Data type    | Unique | Not Null | Default | Description                |
| ---------- | ------------ | ------ | -------- | ------- | -------------------------- |
| iso_code   | Varchar(3)   | PK     | +        | -       | International country code |
| alpha2     | Varchar(2)   | +      | +        | -       | Country code in alpha2     |
| alpha3     | Varchar(3)   | +      | +        | -       | Country code in  alpha3    |
| full_name  | Varchar(200) | -      | +        | -       | Full name                  |
| flag_url   | Varchar(255) | +      | -        | -       | Link on iamge of flag      |
*Relations*:

| Mapped table                                                                     | Column | Relation type | Fetch type | Cascade | Orhpan removal | Optional |
| -------------------------------------------------------------------------------- | ------ | ------------- | ---------- | ------- | -------------- | -------- |
| [[Autogeek/4 UX-projecting/Entities/Global/City/Tables/Cities\|Cities]]          | -      | One to many   | LAZY       | ALL     | true           | -        |
| [[Autogeek/4 UX-projecting/Entities/Autoprom/Concern/Tables/Сoncerns\|Сoncerns]] | -      | One to many   | LAZY       | ALL     | true           | -        |
| [[Autogeek/4 UX-projecting/Entities/Users/Account/Tables/Accounts\|Accounts]]    | -      | One to many   | LAZY       | ALL     | true           | -        |
