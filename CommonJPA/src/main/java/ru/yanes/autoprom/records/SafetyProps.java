package ru.yanes.autoprom.records;

import lombok.Builder;

@Builder(toBuilder = true)
public record SafetyProps(
		boolean abs,
		boolean backDoorsLock,
		boolean armoredBody,
		boolean tirePressureSensor,
		boolean stabilizationSystem,
		boolean eraGlonass
) {
}
