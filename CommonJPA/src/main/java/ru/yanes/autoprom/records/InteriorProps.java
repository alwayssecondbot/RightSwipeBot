package ru.yanes.autoprom.records;

import lombok.Builder;

@Builder(toBuilder = true)
public record InteriorProps(
		boolean sunroof,
		boolean wheel_heaters,
		boolean wheel_leather_trim,
		boolean gearbox_lever_leather_trim,
		boolean panoramic_roof,
		boolean front_central_armrest,
		boolean folding_back_seat,
		boolean sport_front_seat ,
		boolean tinted_windows,
		boolean third_seats_row
) {}
