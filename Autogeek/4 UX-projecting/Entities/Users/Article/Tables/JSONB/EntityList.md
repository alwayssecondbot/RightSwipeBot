Jsonb with entities list markers

| Field name     | Data                               | Unique | Not Null | Default |
| -------------- | ---------------------------------- | ------ | -------- | ------- |
| countries      | codes and cities                   | -      | -        | -       |
| cities         | ids                                | -      | -        | -       |
| concerns       | ids                                | -      | -        | -       |
| brands         | ids and models                     | -      | -        | -       |
| models         | ids and generations                | -      | -        | -       |
| generations    | ids, variations and complectations |        |          |         |
| variations     | ids                                | -      | -        | -       |
| complectations | ids                                | -      | -        | -       |
| gearboxes      | ids                                | -      | -        | -       |
| engines        | ids                                | -      | -        | -       |
```
entities_list: [
	countries: [...],
	cities: [...],
	concerns: [...],
	brands: [...],
	models: [...],
	generations: [...],
	variations: [...],
	complectations: [...],
	gearboxes: [...],
	engines: [...]
]
```