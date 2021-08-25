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
	
	@Before //�׽�Ʈ �޼ҵ尡 ���� �Ǳ� �� �Ź� ���� ���� �ȴ�.
	public void init() {
		//1. IoC �����̳� ����
		context = new GenericXmlApplicationContext("config/beans.xml");
		
	}
	
	
	@Ignore
	@Test
	public void test1() {
		
		//2.Hello Bean ��������
		Hello hello = (Hello)context.getBean("hello"); // getBean���� �׳� ��ü �������� , ��ü Ÿ������ ���� ������ Ŭ���� Ÿ������ ĳ����
		
		//assertEquals�� static �޼ҵ� �̱� ������ �տ� �׻� Assert Ŭ�������� ��ߵ�����,
		// static�������� static org.junit.Assert.assertEquals;�� import�����μ� Ŭ���� ���� ����� �� �ִ�.
		assertEquals("HelloSpring",hello.sayHello()); 
		hello.print();
		
		//3.StringPrinter Bean ��������
		Printer printer = context.getBean("printer",Printer.class); //getBean���� Ŭ���� Ÿ�� �����ؼ� ��������
		assertEquals("HelloSpring", printer.toString());
		
		
	} 
	
	
	@Test
	public void test2() {
		Hello hello = (Hello)context.getBean("hello");
		
		Hello hello2 = (Hello)context.getBean("hello");
		
		// �ش�Ǵ� �� ��ü�� �̱������� ����
		assertSame(hello, hello2);
	}
}
