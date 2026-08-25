Jsonb which contains filter engine properties.

| Field name                | Data type | Not Null | Default | Description                                                                                                                           |
| ------------------------- | --------- | -------- | ------- | ------------------------------------------------------------------------------------------------------------------------------------- |
| power_range               | Smallint  | -        | -       | Engine power (h.p.)                                                                                                                   |
| engine_types              | bytea     | -        | -       | Engine type from [[Autogeek/4 UX-projecting/Entities/Autoprom/Engine/Tables/enums/EngineType\|EngineType]]                            |
| boost_types               | bytea     | -        | -       | Boost type from [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/enums/BoostType\|BoostType]]                            |
| torque_range              | Smallint  | -        | -       | Torque (N\*m)                                                                                                                         |
| engine_capacity_range     | Smallint  | -        | -       | Engine capacity                                                                                                                       |
| engine_positions          | bytea     | -        | -       | Engine position type from [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Tables/enums/EnginePosition\|EnginePosition]]        |
| fuel_types                | bytea     | -        | -       | Fuel type from [[Autogeek/4 UX-projecting/Entities/Autoprom/Engine/Tables/enums/FuelType\|FuelType]]                                  |
| engine_power_systems      | bytea     | -        | -       | Engine power system type from [[Autogeek/4 UX-projecting/Entities/Autoprom/Engine/Tables/enums/EnginePowerSystem\|EnginePowerSystem]] |
| compression_range         | bytea     | -        | -       | Compression ratio                                                                                                                     |
| co2_emission_range        | Smallint  | -        | -       | СО2 emission (g/km)                                                                                                                   |
| cylinders_positions       | bytea     | -        | -       | Cylinders position from [[Autogeek/4 UX-projecting/Entities/Autoprom/Engine/Tables/enums/CylindersPosition\|CylindersPosition]]       |
| cylinders_quantity_range  | bytea     | -        | -       | Cylingers_quantity                                                                                                                    |
| valves_per_cylinder_range | bytea     | -        | -       | Valves per cylinder                                                                                                                   |
| cylinders_diameter_range  | Smallint  | -        | -       | Cylinders diameter                                                                                                                    |
| piston_stroke_range       | Smallint  | -        | -       | Piston stroke                                                                                                                         |

```
engine_props: [
	power_range: [...],
	engine_types: [...],
	boost_types: [...],
	torque: [...],
	engine_capacity_range: [...],
	engine_positions: [...],
	fuel_types: [...],
	engine_power_systems: [...],
	compression_range: [...],
	co2_emission: [...],
	cylinders_positions: [...],
	cylingers_quantity_range: [...],
	valves_per_cylinder_range: [...],
	cylinders_diameter_range: [...],
	piston_stroke_range: [...]
]
```
