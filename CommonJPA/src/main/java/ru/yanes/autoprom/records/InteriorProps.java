package ru.yanes.autoprom.records;

import lombok.Builder;

@Builder(toBuilder = true)
public record InteriorProps(
		boolean sunroof,
		boolean wheelHeaters,
		boolean wheelLeatherTrim,
		boolean gearboxLeverLeatherTrim,
		boolean panoramicRoof,
		boolean frontCentralArmrest,
		boolean foldingBackSeat,
		boolean sportFrontSeat ,
		boolean tintedWindows,
		boolean thirdSeatsRow
) {}
