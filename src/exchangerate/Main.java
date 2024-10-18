package exchangerate;

import java.util.Scanner;

public class Main {
    private static final float rubToUsd = 97.15f;
    private static final float rubToEur = 105.76f;
    private static final float rubToKzt = 0.198697f;
    private static final float rubToCny  = 13.55f;
    private static final float rubToKgs = 1.14f;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float sum;
        do {
            System.out.print("Введите сумму в рублях (разделитель - запятая): ");
            sum = scanner.nextFloat();
        }
        while (sum < 0);

        System.out.println(sum + " Рублей = " + sum / rubToUsd + " Долларов");
        System.out.println(sum + " Рублей = " + sum / rubToEur + " Евро");
        System.out.println(sum + " Рублей = " + sum / rubToKzt + " Тенге");
        System.out.println(sum + " Рублей = " + sum / rubToCny + " Юаней");
        System.out.println(sum + " Рублей = " + sum / rubToKgs + " Киргизских сомов");
    }
}