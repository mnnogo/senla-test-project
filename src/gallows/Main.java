package gallows;

import java.util.Scanner;

public class Main {
    private static final String[] hangmanAscii =
            {
                    """
*----*
     |
     |
     |
   =====""",
                    """
 *----*
 O    |
      |
      |
    =====\
""",
                    """
*----*
 O    |
 |    |
      |
    =====""",
                    """
 *----*
 O    |
/|    |
      |
    =====""",
                    """
*----*
 O    |
/|\\   |
      |
    =====""",
                    """
*----*
 O    |
/|\\   |
 |    |
    =====""",
                    """
*----*
 O   |
/|\\  |
/    |
    =====""",
                    """
*----*
 O   |
/|\\  |
/ \\  |
    ====""",
                    """
*----*
[O   |
/|\\  |
/ \\  |
    ====""",
                    """
*----*
[O]  |
/|\\  |
/ \\  |
    ===="""
            };

    public static void main(String[] args) {
        Gallows gallows = new Gallows();
        gallows.setRandomWord();

        while (!gallows.isGuessed() && gallows.isAlive()) {
            System.out.println(gallows.getCurrentField());
            System.out.print("Введите букву: ");

            Scanner scanner = new Scanner(System.in);
            char c = scanner.next().toLowerCase().charAt(0);

            gallows.tryCharacter(c);

            displayHangmanState(gallows.getLifesCount());
        }

        if (gallows.isGuessed()) {
            System.out.println(gallows.getCurrentWord());
            System.out.println("Поздравляю! Вы отгадали слово.");
        } else {
            System.out.println("Вы проиграли. Загаданное слово было '" + gallows.getCurrentWord() + "'.");
        }
    }

    private static void displayHangmanState(int lifesCount) {
        System.out.println(hangmanAscii[
                hangmanAscii.length - 1 - lifesCount
                ]);
    }
}