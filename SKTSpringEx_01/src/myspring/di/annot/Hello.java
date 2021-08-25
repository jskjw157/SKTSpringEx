package myspring.di.annot;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // xml���� bean�ױ׿� ������ ����, bean���� �������ش�(�Ǿձ��ڴ� �ҹ��ڷ� ��������)
public class Hello {
	
	@Value("${myname}") // �ܼ��� ���� ����
	String name;
	
	/*x
	 * @Autowired // ������ü �ڵ� ����, �����Ҷ��� Type���� ã�� ������
	 * @Qualifier("stringPrinter") // ������ Ÿ���� Bean��ü�� �������� ���, Ư�� Bean�� ������ִ� annotation
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
