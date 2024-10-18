package gallows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gallows {
    private final String[] wordsList =
            {
                    "яблоко",
                    "банан",
                    "вишня",
                    "виноград",
                    "апельсин",
                    "персик",
                    "арбуз",
                    "ананас",
                    "клубника",
                    "черника",
                    "киви",
                    "манго",
                    "слива",
                    "груша",
                    "лимон"
            };

    private final Random random = new Random();
    private String currentWord = "";
    private String currentField = "";
    private int lifesCount;

    public void setRandomWord() {
        currentWord = wordsList[random.nextInt(0, wordsList.length)];
        currentField = "_".repeat(currentWord.length());
        lifesCount = 9;
    }

    public void tryCharacter(char c) {
        if (!currentWord.contains(String.valueOf(c))) {
            lifesCount--;
            return;
        }

        List<Integer> correctIndexes = getCorrectIndexes(c);

        openLettersByIndexes(correctIndexes);
    }

    private List<Integer> getCorrectIndexes(char c) {
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) == c) {
                indexes.add(i);
            }
        }

        return indexes;
    }

    private void openLettersByIndexes(List<Integer> correctIndexes) {
        StringBuilder sb = new StringBuilder(currentField);

        for (Integer correctIndex : correctIndexes) {
            sb.setCharAt(correctIndex, currentWord.charAt(correctIndex));
        }

        currentField = sb.toString();
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public String getCurrentField() {
        return currentField;
    }

    public int getLifesCount() {
        return lifesCount;
    }

    public boolean isGuessed() {
        return !currentField.contains("_");
    }

    public boolean isAlive() {
        return lifesCount > 0;
    }
}
