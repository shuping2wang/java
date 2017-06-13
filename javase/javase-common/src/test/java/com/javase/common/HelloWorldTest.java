package com.javase.common;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldTest {

	Logger logger = LoggerFactory.getLogger(this.getClass())  ;
	@Before
	public void before(){
		logger.info("测试类加载之前调用");
	}
	@Test
	public void test() {
		logger.info("hello word");
	}

	@After
	public void after(){
		logger.info("测试类加载之后调用");
	}
}
