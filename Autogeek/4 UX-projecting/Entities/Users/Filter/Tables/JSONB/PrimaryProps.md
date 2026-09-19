Jsonb which contains filter primary properties.

| Field name            | Data type | Not Null | Default | Description                                                                                                        |
| --------------------- | --------- | -------- | ------- | ------------------------------------------------------------------------------------------------------------------ |
| car_models            | JSONB     | -        | -       | List of jsons with [[Autogeek/4 UX-projecting/Entities/Users/Filter/Tables/JSONB/CarModel\|CarProps]]              |
| price_range           | Big int   | -        | -       | Price range                                                                                                        |
| product_years_range   | Small int | -        | -       | Production years range                                                                                             |
| dirve_types           | Bytea     | -        | -       | Drive ids type from [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/enums/DriveType\|DriveType]]     |
| body_types            | Bytea     | -        | -       | Body type ids from [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/enums/BodyType\|BodyType]]        |
| product_country_codes | Small int | -        | -       | Country of manufacture codes from [[Autogeek/4 UX-projecting/Entities/Global/Country/Tables/Countries\|countries]] |
| acl_to_100            | Bytea     | -        | -       | Acceleration to 100                                                                                                |
| fuel_per_100          | Bytea     | -        | -       | Fuel consumption per 100 km                                                                                        |
```
primary_props: [
	car_models: [
		car_model1,
		car_model2,
		...
	],
	price_range: [...],
	product_years_range: [...],
	dirve_types: [...],
	body_types: [...],
	product_country_codes: [...],
	acl_to_100: [...],
	fuel_per_100: [...]
]
```