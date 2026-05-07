package ru.yanes.autoprom.records;

import lombok.Builder;

@Builder(toBuilder = true)
public record AntitheftProps(
		boolean central_lock,
		boolean immobilizer,
		boolean intrusion_sensor
) {}
