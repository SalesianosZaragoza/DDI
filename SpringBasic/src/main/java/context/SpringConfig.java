package context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.Printer;
import spring.Tecla;

@Configuration
public class SpringConfig {
	
	@Bean
	public Printer getPrinter() {
		Printer printer = new Printer();
		return printer;
	}
	
	@Bean(name="esc")
	public Tecla getEscTecla() {
		Tecla tecla = new Tecla("ESC");
		return tecla;
	}
	
	
	@Bean(name="space")
	public Tecla getSpaceTecla() {
		Tecla tecla = new Tecla("SPACE");
		return tecla;
	}
	
	@Bean(name="enter")
	public Tecla getEnterTecla() {
		Tecla tecla = new Tecla("ENTER");
		return tecla;

	}

}
