package net.bigmir;

import java.math.BigInteger;

public class Factorial implements Runnable{
	private int n;

	public Factorial(int n) {
		super();
		this.n = n;
	}

	public Factorial() {
		super();
	}

	public BigInteger getFactorial(int n) {
		BigInteger f = new BigInteger("1");
		for (int i = 1; i <= n; i++) {
			f = f.multiply(new BigInteger("" + i));
		}
		return f;
	}
	@Override
	public void run() {
		System.out.println("Thread " + n + ": " + getFactorial(n));

	}
}
