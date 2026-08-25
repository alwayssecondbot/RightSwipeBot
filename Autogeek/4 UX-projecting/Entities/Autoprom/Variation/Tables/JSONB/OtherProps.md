Jsonb which contains other properties.

| Field name        | Data type    | Not Null | Default | Description                                                                                                                                  |
| ----------------- | ------------ | -------- | ------- | -------------------------------------------------------------------------------------------------------------------------------------------- |
| max_range         | Smallint     | -        | -       | Max range for full tank                                                                                                                      |
| wheel_orientation | Varchar(255) | -        | -       | Wheel orientation type from [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/enums/WheelOrientationType\|WheelOrientationType]] |
| eco_class         | Bytea        | -        |         | Eco class                                                                                                                                    |



```
other_props: [
	max_range: ...,
	wheel_orientation_id: ...,
	eco_class_id: ...,
	fuel_consumption: ...
```