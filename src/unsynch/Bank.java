package unsynch;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Bank {
	
	private final double[] accounts;
	private Lock bankLock = new ReentrantLock(); 
	
	public Bank(int n, double initialBalance) {
		
		this.accounts = new double[n];
		Arrays.fill(this.accounts, initialBalance);
	}
	
	public void transfer(int from, int to, double amount) {
		bankLock.lock();
		try {
			
		
		if(this.accounts[from] < amount) return;
		System.out.print(Thread.currentThread());
		this.accounts[from] -= amount;
		System.out.printf("%10.2f from %d to %d", amount, from, to );
		this.accounts[to] += amount;
		System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
		}finally {
			bankLock.unlock();
		}
	}
	
	
	public double getTotalBalance() {
		double sum = 0;
		for(double a: this.accounts) {
			sum+=a;
		}
		return sum;
	}
	
	public int size() {
		return this.accounts.length;
	}
}
