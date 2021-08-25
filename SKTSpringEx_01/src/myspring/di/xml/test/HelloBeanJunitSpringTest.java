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

/*Spring-Test ������̼�*/
@RunWith(SpringJUnit4ClassRunner.class) //ApplicationContext�� �ڵ����� ����� ��������
										// ���� �׽�Ʈ���� ��ü�� �����ǵ� �̱����� ����
@ContextConfiguration(locations = "classpath:config/beans.xml") // ������ �� ���� ������ ��ġ�� �����ϴ� ������̼�
public class HelloBeanJunitSpringTest {
	
	@Autowired // �ڵ����� ���� �������ִ� ������̼�, GenericXmlApplicationContext�� ����� �ʿ䰡 ����.
	private ApplicationContext context;
	

	
	@Test
	public void test1() {
		
		//2.Hello Bean ��������
		Hello hello = (Hello)context.getBean("hello3"); // getBean���� �׳� ��ü �������� , ��ü Ÿ������ ���� ������ Ŭ���� Ÿ������ ĳ����
		
		//assertEquals�� static �޼ҵ� �̱� ������ �տ� �׻� Assert Ŭ�������� ��ߵ�����,
		// static�������� static org.junit.Assert.assertEquals;�� import�����μ� Ŭ���� ���� ����� �� �ִ�.
		assertEquals("HelloSpring",hello.sayHello()); 
		hello.print();
		
		assertEquals(3, hello.getNames().size());
		List<String> list = hello.getNames();
		for(String value : list) {
			System.out.println(value);
		}
		
		//3.StringPrinter Bean ��������
		Printer printer = context.getBean("printer",Printer.class); //getBean���� Ŭ���� Ÿ�� �����ؼ� ��������
		assertEquals("HelloSpring", printer.toString());
		
		
	} 
	
	
	@Ignore
	@Test
	public void test2() {
		Hello hello = (Hello)context.getBean("hello");
		
		Hello hello2 = (Hello)context.getBean("hello");
		
		// �ش�Ǵ� �� ��ü�� �̱������� ����
		assertSame(hello, hello2);
	}
}
