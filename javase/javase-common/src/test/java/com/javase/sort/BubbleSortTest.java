package com.javase.sort;

import org.junit.Test;

/**
 * 冒泡排序
 * @author spwang
 *
 */
public class BubbleSortTest {
	@Test
     public void BubbleSort(){
    	 int s[]={16,23,44,5,9,45,6,7,1,234};  
    	    int temp=0;
    	    for(int i=0;i<s.length;i++){
    	    	 for(int j=0;j<s.length-1;j++){
    	    		 if(s[i]<s[j]){
    	    			 temp=s[i];
    	    			 s[i]=s[j];
    	    			 s[j]=temp;
    	    		 }
    	    	 }
    	     }
    	    for(int i=0;i<s.length;i++){
    	    System.out.println(s[i]);
     }
	}
 }
