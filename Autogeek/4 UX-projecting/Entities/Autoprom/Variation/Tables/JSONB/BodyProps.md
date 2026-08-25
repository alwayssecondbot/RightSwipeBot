Jsonb which contains data about car body.

| Field name         | Data type | Default | Description            |
| ------------------ | --------- | ------- | ---------------------- |
| body_length        | Smallint  | -       | Body length (mm)       |
| body_width         | Smallint  | -       | Body width (mm)        |
| body_height        | Smallint  | -       | Body height (mm)       |
| wheel_base         | Smallint  | -       | Wheel base (mm)        |
| ground_clearance   | Smallint  | -       | Ground Clearanse (mm)  |
| front_track        | Smallint  | -       | Front track (mm)       |
| back_track         | Smallint  | -       | Back track (mm)        |
| doors_quantity     | Bytea     | -       | Doors quantity         |
| seats_quantity     | Bytea     | -       | Seats quantity         |
| curb_weight        | Smallint  | -       | Curb weight (kg)       |
| gross_weight       | Smallint  | -       | Gross weight (kg)      |
| min_trunk_capacity | Smallint  | -       | Min trunk capacity (l) |
| max_trunk_capacity | Smallint  | -       | Max trunk capacity (l) |
| tank_capacity      | Smallint  | -       | Tank capacity (l)      |
```
body_props: [
	body_length: ...,
	body_width: ...,
	body_height: ...,
	ground_clearance: ...,
	wheel_base: ...,
	front_track: ...,
	back_track: ...,
	doors_quantity: ...,
	seats_quantity: ...,
	curb_weight: ...,
	gross_weight: ...,
	min_trunk_capacity: ...,
	max_trunk_capacity: ...,
	tank_capacity: ...
]
```