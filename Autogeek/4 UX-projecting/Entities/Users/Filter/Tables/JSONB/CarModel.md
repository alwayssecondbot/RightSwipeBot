Json with car properties

| Field name       | Data type | Not Null | Default | Description                                                                                                               |
| ---------------- | --------- | -------- | ------- | ------------------------------------------------------------------------------------------------------------------------- |
| brand_id         | Int       | -        | -       | Brand ids from [[Autogeek/4 UX-projecting/Entities/Autoprom/Brand/Tables/Brands\|brands]]                                 |
| model_id         | Int       | -        | -       | Model ids from [[Autogeek/4 UX-projecting/Entities/Autoprom/Model/Tables/Models\|models]]                                 |
| generation_id    | Int       | -        | -       | Generation ids from [[Autogeek/4 UX-projecting/Entities/Autoprom/Generation/Tables/Generations\|generations]]             |
| variation_id     | Int       | -        | -       | Variation ids from [[Autogeek/4 UX-projecting/Entities/Autoprom/Generation/Tables/Generations\|generations]]              |
| complectation_id | Int       | -        | -       | Complectation ids from [[Autogeek/4 UX-projecting/Entities/Autoprom/Complectation/Tables/Complectations\|complectations]] |

```
car_model: [
	brand_id: ...,
	model_id: ...,
	generation_id: ...,
	variation_id: ...,
	complectation_id: ...
]
```