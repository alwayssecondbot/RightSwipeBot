package ru.yanes.autoprom.records;

import lombok.Builder;

@Builder(toBuilder = true)
public record LightProps(
		boolean light_auto_correction,
		boolean rain_sensor,
		boolean light_sensor,
		boolean daytime_light,
		boolean light_washers,
		boolean fog_lights,
		boolean light_turning_correction,
		boolean light_adaptation_system ,
		boolean high_light_control_system
){}
