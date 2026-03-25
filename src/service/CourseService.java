package service;

import entity.Course;
import enums.CourseStatus;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    List<Course> courses = new ArrayList<>();

    public void addCourses(Course course){
        if (course == null) return;
        courses.add(course);
    }

    public void listAllCourses(){
        for(Course c : courses) {
            if(c.isActive() == CourseStatus.ACTIVE)
                System.out.println("Course Name: " + c.getCourseName() + " | Description: " + c.getDescription());
        }
    }
}
