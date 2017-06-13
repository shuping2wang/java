package com.javase.singleton;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.javase.factory.Apple;

/**
 * 单例模式测试类
 * @author spwang
 *
 */
public class SingletonPatternsTest {
	
	@Test
	public void testHunger(){
		List<SingletonOfHunger> listClass = new ArrayList<>() ;
		for(int i=0;i<100000;i++){
			listClass.add(SingletonOfHunger.getInstance());
		}
		int count = 0 ;
		for(int i=0;i<100000;i++){
			for(int j=i;j<100000;j++){
				if(listClass.get(i) != listClass.get(j)){
					count ++ ;
				}
			}
		}
		System.out.println(count);
	}
	@Test
	public void testLazy(){
		List<SingletonOfLazy> listClass = new ArrayList<>() ;
		for(int i=0;i<100000;i++){
			listClass.add(SingletonOfLazy.getInstance());
		}
		int count = 0,times = 0;
		for(int i=0;i<100000;i++){
			for(int j=i;j<100000;j++){
				if(listClass.get(i) != listClass.get(j)){
					count ++ ;
				}
				times ++ ;
			}
		}
		System.out.println(count+"	"+times);
		
		Apple aa = new Apple() ;
		Apple bb = new Apple() ;
		System.out.println(aa == bb);
	}
}
