package com.javase.lock;
import java.util.concurrent.locks.ReadWriteLock;

public class Account {

	public Account(int monery, ReadWriteLock lock, String accountNo) {
		super();
		this.monery = monery;
		this.lock = lock;
		this.accountNo = accountNo;
	}
	private int monery;
	private ReadWriteLock lock;
	private String accountNo;
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public ReadWriteLock getLock() {
		return lock;
	}
	public void setLock(ReadWriteLock lock) {
		this.lock = lock;
	}
	public int getMonery() {
		return monery;
	}
	public void setMonery(int monery) {
		this.monery = monery;
	}
	
}
