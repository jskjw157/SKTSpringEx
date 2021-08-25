package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jdk.nashorn.internal.ir.annotations.Ignore;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

/*Spring-Test 어노테이션*/
@RunWith(SpringJUnit4ClassRunner.class) //ApplicationContext를 자동으로 만들고 관리해줌
										// 각각 테스트별로 객체가 생성되도 싱글톤을 보장
@ContextConfiguration(locations = "classpath:config/beans.xml") // 스프링 빈 설정 파일의 위치를 지정하는 어노테이션
public class HelloBeanJunitSpringTest {
	
	@Autowired // 자동으로 빈을 주입해주는 어노테이션, GenericXmlApplicationContext를 사용할 필요가 없다.
	private ApplicationContext context;
	

	
	@Test
	public void test1() {
		
		//2.Hello Bean 가져오기
		Hello hello = (Hello)context.getBean("hello3"); // getBean으로 그냥 객체 가져오기 , 객체 타입으로 오기 때문에 클래스 타입으로 캐스팅
		
		//assertEquals는 static 메소드 이기 때문에 앞에 항상 Assert 클래스명을 써야되지만,
		// static구믄으로 static org.junit.Assert.assertEquals;를 import함으로서 클래스 없이 사용할 수 있다.
		assertEquals("HelloSpring",hello.sayHello()); 
		hello.print();
		
		assertEquals(3, hello.getNames().size());
		List<String> list = hello.getNames();
		for(String value : list) {
			System.out.println(value);
		}
		
		//3.StringPrinter Bean 가져오기
		Printer printer = context.getBean("printer",Printer.class); //getBean으로 클래스 타입 지정해서 가져오기
		assertEquals("HelloSpring", printer.toString());
		
		
	} 
	
	
	@Ignore
	@Test
	public void test2() {
		Hello hello = (Hello)context.getBean("hello");
		
		Hello hello2 = (Hello)context.getBean("hello");
		
		// 해당되는 빈 객체를 싱글톤으로 관리
		assertSame(hello, hello2);
	}
}
