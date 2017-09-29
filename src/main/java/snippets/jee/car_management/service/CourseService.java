package snippets.jee.car_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseService {

    @Autowired
    private CourseDTO courseDTO;

    public CourseDTO getCourseDTO() {
        return courseDTO;
    }
}
