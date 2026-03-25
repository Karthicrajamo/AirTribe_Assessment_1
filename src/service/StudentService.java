package service;

import entity.Student;
import exception.EntityNotFoundException;
import exception.InvalidInputException;
import util.IdGenerator;
import util.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
//    addStudent, removeStudent, updateStudent, listStudents
    List<Student> students = new ArrayList<>();
    public Student addStudent(String firstName, String lastName, String email, String batch, boolean active) throws InvalidInputException{
        InputValidator.requireNonBlank(firstName,"First Name");
        InputValidator.requireNonBlank(lastName,"Last Name");
        InputValidator.requireValidEmail(email);
        Student student = new Student(IdGenerator.getStudentId(),firstName,lastName,email,batch,active);
        System.out.println("Student Added: "+student.getId());
        students.add(student);
        return student;
    }

    public Student addStudent(Student student){
        students.add(student);
        System.out.println("Student added in Student List");
        return student;
    }

    public boolean removeStudent(int id){
        boolean remove = students.removeIf(s -> s.getId() == id);
        if(remove){
            System.out.println("Removed Student Id: "+id);
        }else{
            System.out.println("Student Id "+id+" not found");
        }
        return remove;
    }

    public Student updateStudent(int id,boolean active) throws EntityNotFoundException {
        Student s = findStudentById(id);
        if(s == null){
            return null;
        }
        s.setActive(active);
        System.out.println("Student details updated: "+s.isActive());
        return s;
    }

    public void listStudent(){
        for(Student s:students){
            System.out.println("Id: "+s.getId()+" Name: "+s.getFirstName()+" "+s.getLastName()+" | Email: "+s.getEmail()+" | Batch: "+s.getBatch()+" | Active: "+s.isActive());
        }
    }

    public Student findStudentById(int id) throws EntityNotFoundException {
        for(Student s:students){
            if(s.getId() == id) return s;
        }
        throw new EntityNotFoundException("Student with id="+id+" Not Found");
    }

    public Student deactivateStudent(int studentId)
            throws EntityNotFoundException {
        Student s = findStudentById(studentId);
        s.setActive(false);
        return s;
    }
}
