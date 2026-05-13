package ru.yanes.autoprom.records;

import lombok.Builder;

@Builder(toBuilder = true)
public record LightProps(
		boolean lightAutoCorrection,
		boolean rainSensor,
		boolean lightSensor,
		boolean daytimeLight,
		boolean lightWashers,
		boolean fogLights,
		boolean lightTurningCorrection,
		boolean lightAdaptationSystem ,
		boolean highLightControlSystem
){}
