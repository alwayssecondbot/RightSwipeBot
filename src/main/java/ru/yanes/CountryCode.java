package ru.yanes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum CountryCode {
    RU("Russia", "643", "RUS"),
    US("United States", "840", "USA"),
    GB("United Kingdom", "826", "GBR"),
    DE("Germany", "276", "DEU"),
    CN("China", "156", "CHN"),
    FR("France","250","FRA"),
    JP("Japan", "392", "JPN"),
    ES("Spain", "724", "ESP"),
    IT("Italy", "380", "ITA"),
    KR("South Korea", "410", "KOR");

    private final String name;
    private final String numeric;
    private final String alpha3;
}
