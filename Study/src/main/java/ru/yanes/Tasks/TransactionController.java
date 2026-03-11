package ru.yanes.Tasks;

import java.util.*;
import java.util.stream.Collectors;

public class TransactionController {

	record Transaction(
			String id,
			TransactionType type,
			Status status,
			double amount,
			String currency
	) {}

	record Account(
			String accountNumber,
			String ownerName,
			List<Transaction> transactions // ВНИМАНИЕ: может быть null!
	) {}

	public static void main(String[] args) {
		List<Account> accounts = new ArrayList<Account>();
		record AuditUnit(Transaction transaction, String infoLine) {
			public Transaction getTransaction() {
				return this.transaction;
			}
		}

		Map<TransactionType, Double> auditReport = accounts.parallelStream()
				.flatMap(account -> Optional.ofNullable(account.transactions()).orElse(Collections.emptyList())
						.stream()
						.filter(transaction -> transaction.currency().equals("USD"))
						.filter(transaction -> transaction.status().equals(Status.COMPLETED))
						.filter(transaction -> transaction.amount() > 10000)
						.map(transaction -> new AuditUnit(
								transaction,"[%s] - %s".formatted(transaction.id(), account.ownerName()))
						))
				.collect(Collectors.groupingBy(unit -> unit.getTransaction().type(), Collectors.summingDouble(unit -> unit.getTransaction().amount())));
	}
}

enum TransactionType { DEPOSIT, WITHDRAWAL, TRANSFER }
enum Status { COMPLETED, PENDING, FAILED }

