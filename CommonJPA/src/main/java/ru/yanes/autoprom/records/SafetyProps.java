package ru.yanes.autoprom.records;

import lombok.Builder;

@Builder(toBuilder = true)
public record SafetyProps(
		boolean abs,
		boolean back_doors_lock,
		boolean armored_body,
		boolean tire_pressure_sensor,
		boolean stabilization_system,
		boolean ERA_GLONASS
) {
}
