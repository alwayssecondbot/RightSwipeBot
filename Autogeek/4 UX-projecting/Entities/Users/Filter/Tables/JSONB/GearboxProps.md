Jsonb which contains filter gearbox properties.

| Field name          | Data type | Not Null | Default | Description                                                                                                    |
| ------------------- | --------- | -------- | ------- | -------------------------------------------------------------------------------------------------------------- |
| gearbox_types       | Bytea     | -        | -       | Gearbox type from [[Autogeek/4 UX-projecting/Entities/Autoprom/Gearbox/Tables/enums/GearboxType\|GearboxType]] |
| gear_quantity_range | Bytea     | -        | -       | Quantity of gears                                                                                              |

```
engine_props: [
	gearbox_type: [...],
	gear_quantity_range: [...]
]
```