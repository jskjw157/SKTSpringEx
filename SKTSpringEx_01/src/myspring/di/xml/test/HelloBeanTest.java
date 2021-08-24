package myspring.di.xml.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloBeanTest {

	public static void main(String[] args) {
		//1. IoC 컨테이너 생성
		ApplicationContext context = new GenericXmlApplicationContext("config/beans.xml");
		
		//2.Hello Bean 가져오기
		Hello hello = (Hello)context.getBean("hello"); // getBean으로 그냥 객체 가져오기 , 객체 타입으로 오기 때문에 클래스 타입으로 캐스팅
		System.out.println(hello.sayHello());
		hello.print();
		
		//3.StringPrinter Bean 가져오기
		Printer printer = context.getBean("printer",Printer.class); //getBean으로 클래스 타입 지정해서 가져오기
		System.out.println(printer.toString());
		
		//IoC 컨테이너가 스프링빈을 싱글통형태로 관리한다는 의미.
		Hello hello2 = context.getBean("hello",Hello.class);
		System.out.println(hello == hello2);//true
	} 

}
