package org.example;
import Exception.InvalidDataException;

public class Validator {

    public static void validateId(String id) throws InvalidDataException {
        if (id == null || !id.matches("SV[0-9]{3}")) {
            throw new InvalidDataException("Mã SV phải có dạng SV001");
        }
    }

    public static void validateName(String name) throws InvalidDataException {
        if (!name.matches("[A-Za-zÀ-ỹ ]{2,}")) {
            throw new InvalidDataException("Tên không hợp lệ");
        }
    }

    public static void validateAge(int age) throws InvalidDataException {
        if (age < 18 || age > 50) {
            throw new InvalidDataException("Tuổi phải từ 18–50");
        }
    }
}
