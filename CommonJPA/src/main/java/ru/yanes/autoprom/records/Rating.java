package ru.yanes.autoprom.records;

import lombok.Builder;

@Builder(toBuilder = true)
public record Rating(
	byte interior_comfort,
	byte capacity,
	byte dynamic,
	byte for_family,
	byte for_offroads,
	byte representative,
	byte compactness,
	byte advancedness
) {
}
