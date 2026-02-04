package Main;

import Service.StudentService;
import Model.Student;
import Util.Validator;
import Util.FileUtil;
import Exception.InvalidDataException;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static StudentService service = new StudentService();

    public static void main(String[] args) {

        while (true) {
            try {
                showMenu();
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        service.display();
                        break;
                    case 3:
                        service.sortByName();
                        break;
                    case 4:
                        FileUtil.writeFile("student.dat", service.getStudents());
                        break;
                    case 5:
                        service.setStudents(FileUtil.readFile("student.dat"));
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Chọn sai!");
                }
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
                sc.nextLine();   // dọn input rác để không crash
            }
        }
    }

    static void showMenu() {
        System.out.println("------ MENU ------");
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Hiển thị");
        System.out.println("3. Sắp xếp theo tên");
        System.out.println("4. Lưu file");
        System.out.println("5. Đọc file");
        System.out.println("0. Thoát");
    }

    static void addStudent() throws InvalidDataException {

        System.out.print("Mã: ");
        String id = sc.nextLine();
        Validator.validateId(id);


        if (service.existsById(id)) {
            System.out.println("❌ Mã sinh viên đã tồn tại: " + id);
            return;
        }

        System.out.print("Tên: ");
        String name = sc.nextLine();
        Validator.validateName(name);

        System.out.print("Tuổi: ");
        int age = Integer.parseInt(sc.nextLine());
        Validator.validateAge(age);

        System.out.print("Điểm: ");
        double score = Double.parseDouble(sc.nextLine());

        service.addStudent(new Student(id, name, age, score));
        System.out.println("✅ Thêm sinh viên thành công!");
    }
}