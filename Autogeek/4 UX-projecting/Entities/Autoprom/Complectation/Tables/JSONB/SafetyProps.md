Jsonb which contains safety properties.

| Field name           | Data type | Not Null | Default |
| -------------------- | --------- | -------- | ------- |
| abs                  | boolean   | +        | False   |
| back_doors_lock      | boolean   | +        | False   |
| armored_body         | boolean   | +        | False   |
| tire_pressure_sensor | boolean   | +        | False   |
| stabilization_system | boolean   | +        | False   |
| era_glonass          | boolean   | +        | False   |

```
safety_props: [
	abs: [true/false],
	back_doors_lock: [true/false],
	armored_body: [true/false],
	tire_pressure_sensor: [true/false],
	stabilization_system: [true/false],
	era_glonass: [true/false]
] 
```