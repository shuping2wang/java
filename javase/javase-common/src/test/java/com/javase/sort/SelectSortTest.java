package com.javase.sort;

import org.junit.Test;
/**
 * 选择排序
 * @author spwang
 *
 */
public class SelectSortTest {
	@Test
	public void SelectSort(){
		
		int s[]={16,23,44,5,9,45,6,7,1,234};  
		int temp=0;
		for(int i=0;i<s.length-1;i++){
			int k = i;
			for(int j=k+1;j<s.length;j++){
				if(s[k]>s[j]){
					k=j;
				}
			}
			if(i!=k){
				temp=s[i];
				s[i]=s[k];
				s[k]=temp;
			}
		}
		for(int k=0;k<s.length;k++){
			System.out.println(s[k]);
		}
	}
	

}
