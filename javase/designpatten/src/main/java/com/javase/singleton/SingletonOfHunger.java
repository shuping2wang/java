package com.javase.singleton;
/**
 * 饿汉式
 * @author spwang
 *
 */
public class SingletonOfHunger {

	private SingletonOfHunger(){}
	
	private static SingletonOfHunger singleton = new SingletonOfHunger();
	
	public static SingletonOfHunger getInstance(){
		return singleton;
	}
	
}
