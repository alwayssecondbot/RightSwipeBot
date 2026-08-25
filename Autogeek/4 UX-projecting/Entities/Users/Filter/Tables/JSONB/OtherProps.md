Jsonb which contains filter offers properties.

| Field name         | Data type | Not Null | Default | Description                                                                                                                             |
| ------------------ | --------- | -------- | ------- | --------------------------------------------------------------------------------------------------------------------------------------- |
| full_tank_range    | Small int | -        | -       | Full tank range (km)                                                                                                                    |
| wheel_orientations | bytea     | -        | -       | Wheel orientation from [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/enums/WheelOrientationType\|WheelOrientationType]] |
| eco_classes        | bytea     | -        | -       | Eco class                                                                                                                               |


```
offer_props: [
	full_tank_range: [...],
	wheel_orientations: [...],
	eco_classes: [...]
]
```