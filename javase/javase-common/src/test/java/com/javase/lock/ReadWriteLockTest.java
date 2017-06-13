package com.javase.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

	public static void main (String args[]) {
		//设置一个读写锁
		ReadWriteLock lock=new ReentrantReadWriteLock(false);
		//启动一个线程池
		ExecutorService pool=Executors.newCachedThreadPool();
		//新建一个银行账户
		Account account=new Account(10000, lock, "123456");
		
		for (int i = 0; i < 10; i++) {
			ReadWriteLockOfLock lockSave=new ReadWriteLockOfLock(account, "save");
			ReadWriteLockOfLock lockQuery=new ReadWriteLockOfLock(account, "query");
			ReadWriteLockOfLock lockTake=new ReadWriteLockOfLock(account, "take");
			ReadWriteLockOfLock lockToQuery=new ReadWriteLockOfLock(account, "query");
			pool.execute(lockSave);
			pool.execute(lockQuery);
			pool.execute(lockTake);
			pool.execute(lockToQuery);
		}
		pool.shutdown();
		while (!pool.isTerminated()) {
			
		}
		System.out.println(account.getAccountNo()+"?后账号金额为"+account.getMonery());
	}
}
