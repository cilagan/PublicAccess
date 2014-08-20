package gov.research.publicaccess.driver;

import gov.research.publicaccess.service.DoePagesService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	public static String appContextLocation = "classpath*:src/main/webapp/WEB-INF/publicaccess-context.xml";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext(appContextLocation);
		/*
		   System.out.println("******CHILD - ApplicationContext *******");
           System.out.println("# of beans: " + ctx.getBeanDefinitionCount());
           String[] childBeansArray= ctx.getBeanDefinitionNames();
			for(String beanName: childBeansArray){
				System.out.println(beanName);
			}
		*/
		DoePagesService doeService = (DoePagesService)ctx.getBean("doePagesService", DoePagesService.class);
		
		doeService.testPages();
	}

}
