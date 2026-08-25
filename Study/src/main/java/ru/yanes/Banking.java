package ru.yanes;

import java.util.Arrays;
import java.util.Objects;

class Banking {
	public static void main(String[] args) {

	}
}

class Bank {
	private long[] balance;
	private int n;

	public Bank(long[] balance) {
		if (Objects.nonNull(balance) && balance.length > 0) {
			this.balance = Arrays.copyOf(balance, balance.length);
			this.n = balance.length;
		} else {
			throw new IllegalArgumentException("balance is null");
		}
	}

	public boolean transfer(int account1, int account2, long money) {
		if (checkAccount(account1) && checkAccount(account2)) {
			if (balance[account1 - 1] >= money) {
				balance[account1 - 1] -= money;
				balance[account2 - 1] += money;
				return true;
			}
		}
		return false;
	}

	public boolean deposit(int account, long money) {
		if (checkAccount(account)) {
			balance[account - 1] += money;
			return true;
		}
		return false;
	}

	public boolean withdraw(int account, long money) {
		if (checkAccount(account)) {
			if (balance[account - 1] >= money) {
				balance[account - 1] -= money;
				return true;
			}
		}
		return false;
	}

	private boolean checkAccount(int account) {
		return n >= account && account > 0;
	}
}