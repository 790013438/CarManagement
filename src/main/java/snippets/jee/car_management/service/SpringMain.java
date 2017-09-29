package snippets.jee.car_management.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

    public static void main (String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        CourseService courseService = (CourseService) applicationContext.getBean("courseService");
        System.out.println(courseService.getCourseDTO());
    }
}
