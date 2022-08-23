package testJava;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		
		LgTV tv = (LgTV)context.getBean("lgTV");
		//TV tv = (TV)context.getBean("samsungTV");
		
//		tv.powerOn();
//		tv.volumeDown();
//		tv.powerOff();

		tv.getTv().powerOn();
		
		LgTV tv1 = new LgTV((TV)context.getBean("samsungTV"));
		
		
		
		
		context.close();

	}

}
