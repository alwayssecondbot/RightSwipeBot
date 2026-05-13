package ru.yanes.autoprom.records;

import lombok.Builder;

@Builder(toBuilder = true)
public record Rating(
	byte interiorComfort,
	byte capacity,
	byte dynamic,
	byte forFamily,
	byte forOffroad,
	byte representative,
	byte compactness,
	byte advancedness
) {
}
