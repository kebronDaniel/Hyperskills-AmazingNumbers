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
        int value = scanner.nextInt();
        boolean isValuePresent = false;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == value){
                isValuePresent = true;
                break;
            }
        }
        System.out.println(isValuePresent);

    }
}