package entity;

import enums.CourseStatus;

public class Course {
//    id, courseName, description, durationInWeeks, active
    private int id;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private CourseStatus active;

    public Course(int id, String courseName, String description, int durationInWeeks, CourseStatus active) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    public CourseStatus isActive() {
        return active;
    }

    public void setActive(CourseStatus active) {
        this.active = active;
    }

    public void displayCourseDetails(){
        System.out.println("Course Name: "+courseName+" | Description: "+description);
    }
}
