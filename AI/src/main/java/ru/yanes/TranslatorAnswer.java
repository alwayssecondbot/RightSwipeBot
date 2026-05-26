package ru.yanes;

public record TranslatorAnswer(
		String originLang,
		String originMessage,
		String targetLang,
		String translatedMessage

) {
}
