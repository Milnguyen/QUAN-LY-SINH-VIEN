package org.example;
import Model.Student;
import java.util.*;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public void display() {
        students.forEach(System.out::println);
    }

    public Student searchById(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public void sortByName() {
        students.sort(Comparator.comparing(Student::getName));
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> list) {
        this.students = list;
    }
}

