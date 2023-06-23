package numbers;

import org.w3c.dom.Attr;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);

        showInfo();

        while (true){
            System.out.print("Enter a request: > ");

            String[] numberInput = scanner.nextLine().split(" ");

            if (numberInput.length == 1){

                try {
                    long number = Long.parseLong(numberInput[0]);

                    if (number == 0){
                        System.out.println();
                        System.out.println("Goodbye!");
                        break;
                    }

                    if (checkNaturalNumber(number)){
                        System.out.println();
                        System.out.println("Properties of " + number);

                        boolean buzz = checkBuzz(number);
                        System.out.println("        buzz:   "+buzz);

                        boolean duck = checkDuck(numberInput[0]);
                        System.out.println("        duck:   " + duck);

                        boolean palindromic = checkPalindromic(numberInput[0]);
                        System.out.println(" palindromic:   " + palindromic);

                        boolean gapful = checkGapfulNumbers(numberInput[0]);
                        System.out.println("      gapful:   " + gapful);

                        boolean even = numberIsEven(number);
                        System.out.println("        even:   " + even);
                        System.out.println("         odd:   " + !even);
                        System.out.println();

                    } else {
                        System.out.println();
                        System.out.println("The first parameter should be a natural number or zero.");
                        System.out.println();
                    }
                }catch (NumberFormatException e){
                    System.out.println();
                    System.out.println("The first parameter should be a natural number or zero.");
                    System.out.println();
                }

            }
            if (numberInput.length == 2){
                try {

                    long firstNumber = Long.parseLong(numberInput[0]);
                    long secondNumber = Long.parseLong(numberInput[1]);

                    if (checkNaturalNumber(firstNumber) && (checkNaturalNumber(secondNumber))){
                        for (int i = 0; i < secondNumber; i++) {
                            System.out.print(firstNumber+ " is ");

                            if (checkBuzz(firstNumber)){
                                System.out.print("Buzz,  ");
                            }
                            if (checkDuck(String.valueOf(firstNumber))){
                                System.out.print("duck,  ");
                            }
                            if (checkPalindromic(String.valueOf(firstNumber))){
                                System.out.print("palindromic, ");
                            }
                            if (checkGapfulNumbers(String.valueOf(firstNumber))){
                                System.out.print("gapful,  ");
                            }
                            if (numberIsEven(firstNumber)){
                                System.out.println("even");
                            }
                            if (!numberIsEven(firstNumber)){
                                System.out.println("odd");
                            }
                            System.out.println();
                            firstNumber++;
                        }
                    }else {
                        if (!checkNaturalNumber(firstNumber)){
                            System.out.println();
                            System.out.println("The first parameter should be a natural number or zero");
                            System.out.println();
                        }else {
                            System.out.println();
                            System.out.println("The second parameter should be a natural number or zero.");
                            System.out.println();
                        }
                    }


                }catch (NumberFormatException e){
                    try {
                        long firstNumber = Long.parseLong(numberInput[0]);
                    }catch (NumberFormatException x){
                        System.out.println();
                        System.out.println("The first parameter should be a natural number or zero.");
                        System.out.println();
                    }
                    try {
                        long secondNumber = Long.parseLong(numberInput[1]);
                    }catch (NumberFormatException x){
                        System.out.println();
                        System.out.println("second parameter should be a natural number.");
                        System.out.println();
                    }
                }
            }

        }

    }

    private static void showInfo() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
        System.out.println();
    }


    public static boolean checkNaturalNumber(long number){
        return (number <= 0) ? false : true;
    }
    public static boolean numberIsEven(long number){
        return number % 2 == 0 ? true:false;
    }

    public static boolean checkGapfulNumbers(String userInput){
        String firstAndLastDigit = Character.toString(userInput.charAt(0)) + Character.toString(userInput.charAt(userInput.length() - 1));
        return ((userInput.length() > 3) && (Long.parseLong(userInput) % Long.parseLong(firstAndLastDigit) == 0)) ? true : false;
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
