Jsonb which contains light properties.

| Field name                | Data type | Not Null | Default |
| ------------------------- | --------- | -------- | ------- |
| light_auto_correction     | boolean   | +        | False   |
| rain_sensor               | boolean   | +        | False   |
| light_sensor              | boolean   | +        | False   |
| daytime_light             | boolean   | +        | False   |
| light_washers             | boolean   | +        | False   |
| fog_lights                | boolean   | +        | False   |
| light_turning_correction  | boolean   | +        | False   |
| light_adaptation_system   | boolean   | +        | False   |
| high_light_control_system | boolean   | +        | False   |

```
light_props: [
	light_auto_correction: [true/false],
	rain_sensor: [true/false],
	light_sensor: [true/false],
	daytime_light: [true/false],
	light_washers: [true/false],
	fog_lights: [true/false],
	light_turning_correction: [true/false],
	light_adaptation_system : [true/false],
	high_light_control_system: [true/false]
] 
```