package synch;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

	private final double[] accounts;
	private Lock bankLock;
	private Condition sufficientFunds;
	

	public Bank(int n, double initialBalance) {

		this.accounts = new double[n];
		Arrays.fill(this.accounts, initialBalance);
		this.bankLock = new ReentrantLock();
		this.sufficientFunds = bankLock.newCondition();
	}

	public void transfer(int from, int to, double amount)throws InterruptedException {
		bankLock.lock();
		try {

			while(this.accounts[from] < amount) {
			this.sufficientFunds.await();
			}
			System.out.print(Thread.currentThread());
			this.accounts[from] -= amount;
			System.out.printf("%10.2f from %d to %d", amount, from, to);
			this.accounts[to] += amount;
			System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
			this.sufficientFunds.signalAll();
			
		} finally {
			bankLock.unlock();
		}
	}

	public double getTotalBalance() {
		bankLock.lock();
		try {
			double sum = 0;
			for (double a : this.accounts) {
				sum += a;
			}
			return sum;
		}finally {
			bankLock.unlock();
		}

	}

	public int size() {
		return this.accounts.length;
	}
}
