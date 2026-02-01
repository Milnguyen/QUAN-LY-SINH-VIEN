package Util;

import Model.Student;
import Service.StudentService;

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
                        System.out.println("Đã lưu file.");
                        break;
                    case 5:
                        service.setStudents(FileUtil.readFile("student.dat"));
                        System.out.println("Đã đọc file.");
                        break;
                    case 0:
                        System.out.println("Thoát chương trình.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Chọn sai, vui lòng chọn lại!");
                }
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
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

        System.out.print("Tên: ");
        String name = sc.nextLine();
        Validator.validateName(name);

        System.out.print("Tuổi: ");
        int age = Integer.parseInt(sc.nextLine());
        Validator.validateAge(age);

        System.out.print("Điểm: ");
        double score = Double.parseDouble(sc.nextLine());

        service.addStudent(new Student(id, name, age, score));
        System.out.println("Thêm sinh viên thành công!");
    }
}
