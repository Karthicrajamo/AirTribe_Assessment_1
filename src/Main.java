import entity.Course;
import entity.Enrollment;
import entity.Person;
import entity.Student;
import enums.CourseStatus;
import enums.EnrollmentStatus;
import exception.EntityNotFoundException;
import exception.InvalidInputException;
import service.CourseService;
import service.StudentService;
import util.IdGenerator;

public class Main {
    public static void main(String[] args) throws EntityNotFoundException, InvalidInputException {
        Person person = new Person(IdGenerator.getStudentId(),"Jhon","Bob","john@gmail.com");
        Student student = new Student(IdGenerator.getStudentId(),"Karthic","Raja","karthic@gmail.com","C18",true);

        student.getDisplayName();
        System.out.println("--------------------------------------------------");
        person.getDisplayName();


        System.out.println("--------------------------------------------------");
        System.out.println("-------------------Service Layer------------------");
        System.out.println("--------------------------------------------------");

        StudentService studentService = new StudentService();
        studentService.addStudent(student);
        Person createdStudent = studentService.addStudent("Karthic","Raja","karthic@gmail.com","C18",true);

        Person createdStudent2 = studentService.addStudent(new Student(IdGenerator.getStudentId(),"Dev","D","dev@gmail.com","C18",true));
        System.out.println("New Student:"+createdStudent.getFirstName());

        System.out.println("-------------------Remove User------------------");
        studentService.removeStudent(createdStudent.getId());

        System.out.println("-------------------Deactivate Student------------------");
        studentService.updateStudent(createdStudent2.getId(),false);

        System.out.println("-------------------List Students------------------");
        studentService.listStudent();
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("----------------------Courses---------------------");
        System.out.println("--------------------------------------------------");

        Course java = new Course(IdGenerator.getCourseId(),"Java","Spring Boot",5, CourseStatus.ACTIVE);
        Course node = new Course(IdGenerator.getCourseId(),"Node","Express",5, CourseStatus.ACTIVE);
        CourseService courseService = new CourseService();
        courseService.addCourses(java);
        courseService.addCourses(node);
        courseService.listAllCourses();

        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("---------------------Enrollment-------------------");
        System.out.println("--------------------------------------------------");

        Enrollment enrollment = new Enrollment(IdGenerator.getEnrollmentId(),createdStudent.getId(),java.getId(),"18-Mar-2026", EnrollmentStatus.COMPLETED);
    }
}