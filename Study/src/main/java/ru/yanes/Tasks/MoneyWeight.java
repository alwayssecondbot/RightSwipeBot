package ru.yanes.Tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MoneyWeight {
	public static void  main(String[] args) {
		Transaction transaction1 = new Transaction("Dollar", 120);
		Transaction transaction2 = new Transaction("Dollar", 1);
		Transaction transaction3 = new Transaction("Ruble", 150);
		Transaction transaction4 = new Transaction("Ruble", 15);
		Transaction transaction5 = new Transaction("Som", 15);

		List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3, transaction4,  transaction5);

		Map<String,Double> transactionsAmount = transactions.parallelStream()
				.collect(Collectors.groupingBy(Transaction::currency,
						Collectors.collectingAndThen(Collectors.summarizingDouble(Transaction::amount),
								stat -> stat.getMax() - stat.getMin())));
		System.out.println(transactionsAmount);
	}

	record Transaction(String currency, double amount) {}
}
