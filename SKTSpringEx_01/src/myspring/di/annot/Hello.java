package myspring.di.annot;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // xml에서 bean테그와 동일한 역할, bean으로 설정해준다(맨앞글자는 소문자로 변경해줌)
public class Hello {
	
	@Value("${myname}") // 단순한 값을 주입
	String name;
	
	/*x
	 * @Autowired // 의존객체 자동 주입, 주입할때는 Type으로 찾기 때문에
	 * @Qualifier("stringPrinter") // 동일한 타입의 Bean객체가 여러개일 경우, 특정 Bean을 명시해주는 annotation
	 */	
	@Resource(name="${printer1}")
	Printer printer;
	
	List<String> names;
	


	
	
	public String sayHello() {
		return "Hello" + name;
	}
	
	public void print() {
		this.printer.print(sayHello());
	}
}
