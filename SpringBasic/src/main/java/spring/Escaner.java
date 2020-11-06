package spring;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component("scanner")
public class Escaner {
	
	public void scanScreen() {
		System.out.println("scanning");
	}

}
