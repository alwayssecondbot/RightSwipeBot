Jsonb which contains filter body properties.

| Field name           | Data type | Not Null | Default | Description                                                                                                  |
| -------------------- | --------- | -------- | ------- | ------------------------------------------------------------------------------------------------------------ |
| body_length_range    | Small int | -        | -       | Body length (mm)                                                                                             |
| body_width_range     | Small int | -        | -       | Body width (mm)                                                                                              |
| body_heigth_range    | Small int | -        | -       | Body height (mm)                                                                                             |
| tank_capacity_range  | Small int | -        | -       | Tank capacity (l)                                                                                            |
| trunk_capacity_range | Small int | -        | -       | Min trunk capacity (l)                                                                                       |
| seats_quantity_range | Bytea     | -        | -       | Seats quantity                                                                                               |
| doors_quantity_range | Bytea     | -        | -       | Door quantity                                                                                                |
| empty_weight_range   | Small int | -        | -       | Empty weight (kg)                                                                                            |
| full_weight_range    | Small int | -        | -       | Full weight (kg)                                                                                             |
| wheel_base_range     | Small int | -        | -       | Wheel base (mm)                                                                                              |
| front_track_range    | Small int | -        | -       | Front track (mm)                                                                                             |
| back_track_range     | Small int | -        | -       | Back track (mm)                                                                                              |
| body_colors          | Bytea     | -        | -       | Body_colors                                                                                                  |
| color_types          | Bytea     | -        | -       | Color types from [[Autogeek/4 UX-projecting/Entities/Users/Offer/Tables/enums/BodyColorType\|body_color_types]] |

```
body_props: [
	body_length_range: [...],
	body_width_range: [...],
	body_heigth_range: [...],
	tank_capacity_range: [...],
	trunk_capacity_range: [...],
	seats_quantity_range: [...],
	doors_quantity_range: [...],
	empty_weight_range: [...],
	full_weight_range: [...],
	wheel_base_range: [...],
	front_track_range: [...],
	back_track_range: [...],
	body_colors: [...],
	color_types: [...],
]
```