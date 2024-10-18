package passwordgenerator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину пароля (8 до 12 вкл.) или нажмите ENTER, чтобы сделать ее случайной: ");

        String value = scanner.nextLine();

        int length;
        try {
            length = Integer.parseInt(value);
        } catch (Exception e) {
            length = -1;
        }

        String password;
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        if (length < 8 || length > 12) {
            System.out.println("Вы ввели некорректное число, поэтому длина будет сгенерирована случайным образом.");

            password = passwordGenerator.generatePassword();
        }
        else {
            password = passwordGenerator.generatePassword(length);
        }

        System.out.println("Сгенерированный пароль: " + password);
    }
}
