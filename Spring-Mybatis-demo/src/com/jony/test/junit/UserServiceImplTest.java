package com.jony.test.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.jony.java.service.UserServiceImpl;

/****
 *  @Test 标识测试函数
 *  @Before 和 @After 指定每个测试函数执行之前和执行之后的动作
 * 	@BeforeClass 或 @AfterClass  所有测试函数执行前执行的动作，只执行一次，作用于测试类全局
 *	@Test(timeout  =   1000 ) 指定测试函数返回时间，常用于发现超时，死循环等问题
 *	@Test(expected  =  ArithmeticException. class )测试抛出异常
 *	 @RunWith(TestClassRunner. class )指定一个runner来跑测试代码
 *	 @Parameters 参数化测试，可以一次指定多个参数进行测试
 */
public class UserServiceImplTest {
	
	public static UserServiceImpl a= new UserServiceImpl();
	@Test
	public void add(){
		assertEquals (8,a.add(3, 5));
	}
}
