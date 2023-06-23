import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.next());

        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            int number = Integer.parseInt(scanner.next());
            numbers[i] = number;
        }

        int cusp = scanner.nextInt();

        int sum = 0;
        for (int number:numbers
             ) {
            if (number > cusp){
                sum += number;
            }
        }
        System.out.println(sum);


    }
}