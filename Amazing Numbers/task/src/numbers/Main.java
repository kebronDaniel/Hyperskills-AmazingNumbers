package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        int number = scanner.nextInt();
        if (number <= 0){
            System.out.println("This number is not natural!");
        } else {
            if (number % 2 == 0){
                System.out.println("This number is Even");
                checkBuzz(number);
            } else{
                System.out.println("This number is Odd");
                checkBuzz(number);
            }
        }
    }

    public static void checkBuzz(int number){
        int lastDigit = number % 10;
        int remainingDigits = number / 10;

        int checker = ((remainingDigits - (lastDigit*2)) % 7);
        System.out.println(checker);

        if ((checker == 0) && (lastDigit == 7)){
            System.out.println("It is a Buzz number.");
            System.out.println("Explanation:");
            System.out.println(number + " is divisible by 7 and ends with 7.");
        } else if (checker == 0) {
            System.out.println("It is a Buzz number.");
            System.out.println("Explanation:");
            System.out.println(number + " is divisible by 7.");
        } else if (lastDigit == 7) {
            System.out.println("It is a Buzz number.");
            System.out.println("Explanation:");
            System.out.println(number + " ends with 7.");
        }else {
            System.out.println("It is not a Buzz number");
            System.out.println("Explanation:");
            System.out.println(number + " is neither divisible by 7 nor does it end with 7.");
        }
    }
}
