Jsonb which contains offer complectation properties.

| Field name       | Data type | Not Null | Default | Description                                                                                                            |
| ---------------- | --------- | -------- | ------- | ---------------------------------------------------------------------------------------------------------------------- |
| complectation_id | Int       | +        | -       | id from [[Autogeek/4 UX-projecting/Entities/Autoprom/Complectation/Tables/Complectations\|Complectations]]             |
| linght_props     | JSONB     | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Autoprom/Complectation/Tables/JSONB/LightProps\|light props]]           |
| antitheft_props  | JSONB     | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Autoprom/Complectation/Tables/JSONB/AntitheftProps\|antitheft props]]   |
| interior_props   | JSONB     | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Autoprom/Complectation/Tables/JSONB/InteriorProps\|interior props]]     |
| safety_props     | JSONB     | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Autoprom/Complectation/Tables/JSONB/SafetyProps\|safety props]]         |
| multimedia_props | JSONB     | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Autoprom/Complectation/Tables/JSONB/MultimediaProps\|multimedia props]] |
| exterior_props   | JSONB     | -        | -       | Jsonb with [[Autogeek/4 UX-projecting/Entities/Autoprom/Complectation/Tables/JSONB/ExteriorProps\|exterior props]]     |

```
complectation : [
	complectation_id: ...,
	light_props: [
		light_auto_correction: true,
		rain_sensor: true,
		light_sensor: true,
		daytime_light: true,
		light_washers: true,
		fog_lights: true,
		light_turning_correction: true,
		light_adaptation_system : true,
		high_light_control_system: true
	],
	antitheft_props: [
		central_lock: true,
		immobilizer: true,
		intrusion_sensor: true
	],
	interior_props: [
		light_auto_correction: true,
		rain_sensor: true,
		light_sensor: true,
		daytime_light: true,
		light_washers: true,
		fog_lights: true,
		light_turning_correction: true,
		light_adaptation_system : true,
		high_light_control_system: true
	],
	safety_props: [
		abs: true,
		back_doors_lock: true,
		armored_body: true,
		tire_pressure_sensor: true,
		stabilization_system: true,
		ERA_GLONASS: true
	],
	multimedia_props: [
		aux: true,
		android_auto: true,
		carplay: true,
		usb: true,
		voice_control: true,
		backseat_multimedia: true,
		lcd_screen: true,
		navigation_system : true,
		socket_12v: true,
		socket_220v: true,
		yandex_auto: true
	],
	exterior_props: [
		aerography: true,
		body_kits: true,
		roof_rails: true
	]
]
```