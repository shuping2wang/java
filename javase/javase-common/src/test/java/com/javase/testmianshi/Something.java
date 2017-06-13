package com.javase.testmianshi;

/**
 * 笔试题
 * @author spwang
 *
 */
public class Something {
	
   /**
    * 判断题  显然是错误的，final固定的，修饰x 时，x不能改变值
    * @param x
    * @return
    */
	//public  int addOne(final int x) {
		//return ++x;
	//}
	/**
	 * 输出值
	 * s1.a=2
     *  s2.a=2
	 *  s1.b=3
	 *  s2.b=3
	 */
	public int a=1;
	public static int b=1;
	public static void main(String[] args){
		Something s1=new Something();
		Something s2=new Something();
		System.out.println(s1 == s2);//false
		System.out.println(s1.b == s2.b);//true
		s1.b=s1.b+1;
		System.out.println(s1.b +"	"+ s2.b);// 2 2
        s2.b=s2.b+1;
        System.out.println(s1.b +"	"+ s2.b);//3  3
		s1.a=s1.a+1;
		s2.a=s2.a+1;
		System.out.println("s1.a="+s1.a);
		System.out.println("s2.a="+s2.a);
        s1.b=s1.b+1;
        s2.b=s2.b+1;
        System.out.println("s1.b="+s1.b);
		System.out.println("s2.b="+s2.b);
	}
}
