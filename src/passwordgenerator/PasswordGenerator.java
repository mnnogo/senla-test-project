package passwordgenerator;

import java.util.Random;

public class PasswordGenerator {
    private final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}|;:,.<>?/`~";
    private final Random random = new Random();

    public String generatePassword(int length) {
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(characters.charAt(
                    random.nextInt(0, characters.length())
            ));
        }

        return password.toString();
    }

    public String generatePassword() {
        return generatePassword(
                random.nextInt(8, 13)
        );
    }
}
