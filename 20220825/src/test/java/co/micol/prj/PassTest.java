package co.micol.prj;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassTest {
	
	@Test
	public void passEnco() {
		BCryptPasswordEncoder enco = new BCryptPasswordEncoder(10); 
		String result = enco.encode("1234");
		Boolean login = enco.matches("1234", result);
		System.out.println(result);
		System.out.println(login);
		
	}

}
