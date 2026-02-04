package Service;

import Exception.InvalidDataException;
import Model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    // ✅ THÊM SINH VIÊN (đúng chuẩn Service)
    public void addStudent(Student s) throws InvalidDataException {
        if (existsById(s.getId())) {
            throw new InvalidDataException("Mã sinh viên đã tồn tại: " + s.getId());
        }
        students.add(s);
    }

    // ✅ Hiển thị danh sách
    public void display() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên đang trống!");
            return;
        }

        students.forEach(System.out::println);
    }

    // ✅ Tìm sinh viên theo mã
    public Student searchById(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    // ✅ Sắp xếp theo tên (A → Z)
    public void sortByName() {
        students.sort(Comparator.comparing(
                Student::getName,
                String.CASE_INSENSITIVE_ORDER
        ));
        System.out.println("Đã sắp xếp theo tên!");
    }

    // ✅ Lấy danh sách (để ghi file)
    public List<Student> getStudents() {
        return students;
    }

    // ✅ Gán danh sách (để đọc file)
    public void setStudents(List<Student> list) {
        this.students = list;
    }

    // ✅ KIỂM TRA TRÙNG MÃ (RẤT QUAN TRỌNG)
    public boolean existsById(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }
    }