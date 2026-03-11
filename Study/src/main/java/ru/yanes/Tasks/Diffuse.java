package ru.yanes.Tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Diffuse {
	public static void main(String[] args){
		List<Trade> trades = new ArrayList<>();
		TradeExtremes tradeExtremes = trades.stream()
				.collect(Collectors.teeing(
						Collectors.minBy(Comparator.comparingDouble(Trade::price)),
						Collectors.maxBy(Comparator.comparingDouble(Trade::price)),
						(min, max) -> new TradeExtremes(min.get(), max.get())
						)
				);
	}
}

record Trade(String ticker, double price) {}
record TradeExtremes(Trade minTrade, Trade maxTrade) {}