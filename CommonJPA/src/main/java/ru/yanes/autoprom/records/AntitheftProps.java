package ru.yanes.autoprom.records;

import lombok.Builder;

@Builder(toBuilder = true)
public record AntitheftProps(
		boolean centralLock,
		boolean immobilizer,
		boolean intrusionSensor
) {}
