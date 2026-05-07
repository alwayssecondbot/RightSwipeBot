package ru.yanes.autoprom.records;

import lombok.Builder;

@Builder(toBuilder = true)
public record ExteriorProps(
		boolean aerography,
		boolean body_kits,
		boolean roof_rails
) {
}
