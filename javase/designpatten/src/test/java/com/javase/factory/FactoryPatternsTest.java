package com.javase.factory;

import org.junit.Test;

public class FactoryPatternsTest {

	@Test
	public static void main(String[] args){
		Frute frute = Factory.getFrute("apple");
		if(frute!=null){
			System.out.println(frute.tell());
		}
		Frute frute2 = Factory.getFrute("banana");
		if(frute2!=null){
			System.out.println(frute2.tell());
		}
	}
}

