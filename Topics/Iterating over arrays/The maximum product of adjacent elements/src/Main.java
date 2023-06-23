import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int range = scanner.nextInt();

        int[] elements = new int[range];
        for (int i = 0; i < range; i++) {
            int element = scanner.nextInt();
            elements[i] = element;
        }

        int maxValue = 1;
        for (int i = 0; i < elements.length - 1; i++) {
            int accumulator = elements[i] * elements[i + 1];
            if (accumulator > maxValue){
                maxValue = accumulator;
            }
        }
        System.out.println(maxValue);
    }
}