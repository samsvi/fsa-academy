package sk.posam.fsa.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sk.posam.fsa.spring.domain.Address;
import sk.posam.fsa.spring.domain.City;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context/application-context.xml");
        Address obj = (Address) context.getBean("address");
        System.out.println(obj.getCity().getCountry().getCountry());

        City objC = (City) context.getBean("cityConstructor");
        System.out.println(objC.getNumberOfPeople());
    }
}
