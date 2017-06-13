package com.javase.thread;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DoSomethingThread implements Runnable{
	private String threadNo ;
	public DoSomethingThread(String threadNo){
		this.threadNo = threadNo ;
	}
	@Override  
    public void run() {  
        System.out.println( threadNo +new SimpleDateFormat("	yyyy-mm-dd hh:MM:ss").format(new Date()) + " �?�?");
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println( threadNo +" End. Time = "+new Date());  
        //System.out.println( threadNo +new SimpleDateFormat("	yyyy-mm-dd hh:MM:ss").format(new Date()) + " 结束");  
    }
    @Override  
    public String toString(){  
        return this.threadNo;  
    }     
}

