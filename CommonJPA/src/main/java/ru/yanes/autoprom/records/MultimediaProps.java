package ru.yanes.autoprom.records;

import lombok.Builder;

@Builder(toBuilder = true)
public record MultimediaProps(
		boolean aux,
		boolean android_auto,
		boolean carplay,
		boolean usb,
		boolean voice_control,
		boolean backseat_multimedia,
		boolean lcd_screen,
		boolean navigation_system,
		boolean socket_12v,
		boolean socket_220v,
		boolean yandex_auto
) {
}
