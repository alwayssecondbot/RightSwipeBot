Jsonb which contains filter brake and suspencion properties.

| Field name  | Data type | Not Null | Default | Description                                                                                                                   |
| ----------- | --------- | -------- | ------- | ----------------------------------------------------------------------------------------------------------------------------- |
| susp_types  | Bytea     | -        | -       | Suspencion type ids from [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/enums/SuspensionType\|SuspensionType]] |
| brake_types | Bytea     | -        | -       | Brake type ids from [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/enums/BrakeType\|BrakeType]]                |

```
engine_props: [
	susp_types: [...],
	brake_types: [...]
]
```