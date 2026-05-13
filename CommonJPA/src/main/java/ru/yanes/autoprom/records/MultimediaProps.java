package ru.yanes.autoprom.records;

import lombok.Builder;

@Builder(toBuilder = true)
public record MultimediaProps(
		boolean aux,
		boolean androidAuto,
		boolean carplay,
		boolean usb,
		boolean voiceControl,
		boolean backseatMultimedia,
		boolean lcdScreen,
		boolean navigationSystem,
		boolean socket12v,
		boolean socket220v,
		boolean yandexAuto
) {
}
