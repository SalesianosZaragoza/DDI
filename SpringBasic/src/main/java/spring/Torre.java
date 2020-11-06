package spring;

import java.util.List;
import java.util.stream.Stream;

import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StreamUtils;

public class Torre {

	@Autowired
	private Raton raton;
	
	@Autowired
	@Qualifier("tecladoES")
	private Teclado teclado;
	
	@Autowired
	private Escaner escaner;
	
	@Autowired
	private Monitor monitor;
	
	@Autowired
	private Printer printer; 

	@Autowired
	private Printer printer1; 

	public static void main(String[] args) {
		new Torre();
	}

	public Torre() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		AutowireCapableBeanFactory acbFactory = context.getAutowireCapableBeanFactory();
		acbFactory.autowireBean(this);
		// raton = (Raton) context.getBean("raton");
//			raton = (Raton) context.getBean("raton");
//			Escaner scanner = (Escaner) context.getBean("scanner");
//			Teclado teclado = (Teclado) context.getBean("tecladoFR");
		getEscaner().scanScreen();
		getRaton().hacerClickDerecho();
		System.out.println(getTeclado().getIdioma());
		System.out.println(getTeclado().getLetras());
		getMonitor().getAltavoces().escucharIzquierdo();
		getPrinter().imprimirHoja();
		List<Tecla> letras = getTeclado().getLetras();
		letras.stream().forEach(System.out::println);
	}

	public Escaner getEscaner() {
		return escaner;
	}

	public void setEscaner(Escaner escaner) {
		this.escaner = escaner;
	}

	public Teclado getTeclado() {
		return teclado;
	}

	public void setTeclado(Teclado teclado) {
		this.teclado = teclado;
	}

	public Raton getRaton() {
		return raton;
	}

	public void setRaton(Raton raton) {
		this.raton = raton;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

}
