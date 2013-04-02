package id.ac.pcr.springjdbc.provider;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: Deny Prasetyo
 * Date: 4/2/13
 * Time: 11:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationContextProvider {
    private static ApplicationContextProvider staticObject = null;
    private ApplicationContext applicationContext;

    private ApplicationContextProvider() {
        applicationContext = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/**/applicationContext*.xml");
    }

    public static ApplicationContextProvider getInstance() {
        if (staticObject == null) {
            staticObject = new ApplicationContextProvider();
        }
        return staticObject;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
