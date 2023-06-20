package numbers;

import org.w3c.dom.Attr;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);

        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter 0 to exit.");
        System.out.println();

        while (true){
            System.out.print("Enter a request: > ");

            String numberInput = scanner.nextLine();
            long number = Long.parseLong(numberInput);

            if (number == 0){
                System.out.println("Goodbye!");
                break;
            }

            if (checkNaturalNumber(number)){
                System.out.println();
                System.out.println("Properties of " + number);
                boolean even = numberIsEven(number);
                System.out.println("        even:   " + even);
                System.out.println("         odd:   " + !even);

                boolean buzz = checkBuzz(number);
                System.out.println("        buzz:   "+buzz);

                boolean duck = checkDuck(numberInput);
                System.out.println("        duck:   " + duck);

                boolean palindromic = checkPalindromic(numberInput);
                System.out.println(" palindromic:   " + palindromic);
                System.out.println();

            } else {
                System.out.println();
                System.out.println("The first parameter should be a natural number or zero.");
                System.out.println();
            }
        }

    }


    public static boolean checkNaturalNumber(long number){
        return (number <= 0) ? false : true;
    }
    public static boolean numberIsEven(long number){
        return number % 2 == 0 ? true:false;
    }

    public static boolean checkPalindromic(String number){
        StringBuilder stringBuilder = new StringBuilder(number);
        String reversedNumber = stringBuilder.reverse().toString();
        return (number.equals(reversedNumber)) ? true : false;
    }

    public static boolean checkDuck(String number){
        if (number.charAt(0) == '0'){
            return false;
        } else {
            if (number.contains("0")){
                return true;
            }
        }
        return false;
    }

    public static boolean checkBuzz(long number){

        long lastDigit = number % 10;
        long remainingDigits = number / 10;
        long checker = ((remainingDigits - (lastDigit*2)) % 7);

        if ((checker == 0) && (lastDigit == 7)){
//            System.out.println("It is a Buzz number.");
//            System.out.println("Explanation:");
//            System.out.println(number + " is divisible by 7 and ends with 7.");
            return true;
        } else if (checker == 0) {
//            System.out.println("It is a Buzz number.");
//            System.out.println("Explanation:");
//            System.out.println(number + " is divisible by 7.");
            return true;
        } else if (lastDigit == 7) {
//            System.out.println("It is a Buzz number.");
//            System.out.println("Explanation:");
//            System.out.println(number + " ends with 7.");
            return true;
        }else {
//            System.out.println("It is not a Buzz number");
//            System.out.println("Explanation:");
//            System.out.println(number + " is neither divisible by 7 nor does it end with 7.");
            return false;
        }
    }
}
