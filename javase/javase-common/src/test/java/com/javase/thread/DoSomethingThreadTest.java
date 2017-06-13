package com.javase.thread;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;


public class DoSomethingThreadTest {

	@Test
	public void testCachedThreadPool() {
		System.out.println("Main: Starting at: " + new SimpleDateFormat("yyyy-mm-dd hh:MM:ss").format(new Date()));
		ExecutorService exec = Executors.newCachedThreadPool(); // 创建�?个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
		for (int i = 0; i < 10; i++) {
			exec.execute(new DoSomethingThread("线程"+String.valueOf(i)));
		}
		exec.shutdown(); // 执行到此处并不会马上关闭线程�?,但之后不能再�?线程池中加线程，否则会报�?
		System.out.println("Main: Finished all threads at " +new SimpleDateFormat("yyyy-mm-dd hh:MM:ss").format(new Date()));
	}
	@Test
	public void testSingleThreadPool() {
		System.out.println("主线程开�?: " + new SimpleDateFormat("yyyy-mm-dd hh:MM:ss").format(new Date()));
		ExecutorService exec = Executors.newSingleThreadExecutor() ;
		for (int i = 0; i < 10; i++) {
			exec.execute(new DoSomethingThread("线程"+String.valueOf(i)));
		}
		exec.shutdown();
		System.out.println("主线程结�?: " +new SimpleDateFormat("yyyy-mm-dd hh:MM:ss").format(new Date()));
	}
	@Test
	public void testFixedThreadPool() {
		System.out.println("主线程开?: " + new SimpleDateFormat("yyyy-mm-dd hh:MM:ss").format(new Date()));
		ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 5) ;
		for (int i = 0; i < 10; i++) {
			exec.execute(new DoSomethingThread("线程"+String.valueOf(i)));
		}
		exec.shutdown();
		System.out.println(": " +new SimpleDateFormat("yyyy-mm-dd hh:MM:ss").format(new Date()));
	}
	@Test
	public void testScheduleThreadPool() {
		System.out.println(": " + new SimpleDateFormat("yyyy-mm-dd hh:MM:ss").format(new Date()));
		ScheduledThreadPoolExecutor   exec = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10) ;
		for (int i = 0; i < 10; i++) {
			exec.schedule(new DoSomethingThread("线程"+String.valueOf(i)), 10, TimeUnit.SECONDS);
		}
		exec.shutdown();
		  while(!exec.isTerminated()){  
	            //wait for all tasks to finish  
	     }  
		System.out.println("主线程结�?: " +new SimpleDateFormat("yyyy-mm-dd hh:MM:ss").format(new Date()));
	}
}
