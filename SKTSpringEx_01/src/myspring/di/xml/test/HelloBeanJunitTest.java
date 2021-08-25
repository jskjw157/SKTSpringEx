package myspring.di.xml.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import jdk.nashorn.internal.ir.annotations.Ignore;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import static org.junit.Assert.*;


public class HelloBeanJunitTest {
	
	ApplicationContext context;
	
	@Before //테스트 메소드가 실행 되기 전 매번 먼저 실행 된다.
	public void init() {
		//1. IoC 컨테이너 생성
		context = new GenericXmlApplicationContext("config/beans.xml");
		
	}
	
	
	@Ignore
	@Test
	public void test1() {
		
		//2.Hello Bean 가져오기
		Hello hello = (Hello)context.getBean("hello"); // getBean으로 그냥 객체 가져오기 , 객체 타입으로 오기 때문에 클래스 타입으로 캐스팅
		
		//assertEquals는 static 메소드 이기 때문에 앞에 항상 Assert 클래스명을 써야되지만,
		// static구믄으로 static org.junit.Assert.assertEquals;를 import함으로서 클래스 없이 사용할 수 있다.
		assertEquals("HelloSpring",hello.sayHello()); 
		hello.print();
		
		//3.StringPrinter Bean 가져오기
		Printer printer = context.getBean("printer",Printer.class); //getBean으로 클래스 타입 지정해서 가져오기
		assertEquals("HelloSpring", printer.toString());
		
		
	} 
	
	
	@Test
	public void test2() {
		Hello hello = (Hello)context.getBean("hello");
		
		Hello hello2 = (Hello)context.getBean("hello");
		
		// 해당되는 빈 객체를 싱글톤으로 관리
		assertSame(hello, hello2);
	}
}
