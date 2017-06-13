package com.javase.lock;
public class ReadWriteLockOfLock implements Runnable{

	private Account account;
	private String type;
	
	public ReadWriteLockOfLock(Account account, String type) {
		super();
		this.account = account;
		this.type = type;
	}

	@Override
	public void run() {
		if("take".equals(type)){
			//获取写锁
			account.getLock().writeLock().lock();
			account.setMonery(account.getMonery()-100);
			System.out.println(account.getAccountNo()+"取走100"+"还剩"+account.getMonery());
			account.getLock().writeLock().unlock();
		}else if("save".equals(type)){
			account.getLock().writeLock().lock();
			account.setMonery(account.getMonery()+100);
			System.out.println(account.getAccountNo()+"存取100"+account.getMonery());
			account.getLock().writeLock().unlock();
		}else if("query".equals(type)){
			account.getLock().writeLock().lock();
			System.out.println(account.getAccountNo()+"查询账号还有"+account.getMonery());
			account.getLock().writeLock().unlock();
			
		}
		
	}

	
}
