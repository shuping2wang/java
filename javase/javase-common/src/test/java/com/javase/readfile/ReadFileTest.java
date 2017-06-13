package com.javase.readfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;


public class ReadFileTest {
	/**
	 * 文件的复制以及打印到控制台
	 */
	@Test
	public void ReadFile(){
		try {
			InputStream inputStream =new FileInputStream(new File("D:\\devTools\\wok\\aaa.txt"));
			OutputStream outputStream =new FileOutputStream(new File("D:\\devTools\\wok\\bbb.txt"));
			byte[] length = new byte[1024] ;
			int count = 0;	
			//read返回 -1 时，证明已经遍历完
			while((count = inputStream.read(length)) != -1){
				//字符串型显示（从bt中的第0个字节开始遍历count个长度）
				//System.out.println(new String (length,0,count));
				outputStream.write(length,0,count);
			}
			inputStream.close();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
