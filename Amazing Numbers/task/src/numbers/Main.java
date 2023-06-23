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
                        showPropertyInMultipleLine(number);

                    } else {
                        System.out.println();
                        System.out.println("The first parameter should be a natural number or zero.");
                        System.out.println();
                    }
                }catch (NumberFormatException e){
                    System.out.println();
                    System.out.println("The property ["+ numberInput[0] +"] is wrong.");
                    System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY]");
                }

            }
            if (numberInput.length == 2){
                try {

                    long firstNumber = Long.parseLong(numberInput[0]);
                    long secondNumber = Long.parseLong(numberInput[1]);

                    if (checkNaturalNumber(firstNumber) && (checkNaturalNumber(secondNumber))){
//                        for (int i = 0; i < secondNumber; i++) {
//                            System.out.print(firstNumber+ " is ");
//
//                            if (checkBuzz(firstNumber)){
//                                System.out.print("Buzz,  ");
//                            }
//                            if (checkDuck(String.valueOf(firstNumber))){
//                                System.out.print("duck,  ");
//                            }
//                            if (checkPalindromic(String.valueOf(firstNumber))){
//                                System.out.print("palindromic, ");
//                            }
//                            if (checkGapfulNumbers(String.valueOf(firstNumber))){
//                                System.out.print("gapful,  ");
//                            }
//                            if (checkSpy(String.valueOf(firstNumber))){
//                                System.out.print("spy,  ");
//                            }
//                            if (numberIsEven(firstNumber)){
//                                System.out.println("even");
//                            }
//                            if (!numberIsEven(firstNumber)){
//                                System.out.println("odd");
//                            }
//                            System.out.println();
//                            firstNumber++;
//                        }
                        showPropertyInRange(firstNumber,secondNumber);
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
                        System.out.println("The property ["+ numberInput[0] +"] is wrong.");
                        System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY]");
                    }
                    try {
                        long secondNumber = Long.parseLong(numberInput[1]);
                    }catch (NumberFormatException x){
                        System.out.println();
                        System.out.println("The property ["+ numberInput[1] +"] is wrong.");
                        System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY]");
                    }
                }
            }
            if (numberInput.length == 3){

                try {
                    long firstNumber = Long.parseLong(numberInput[0]);
                    long secondNumber = Long.parseLong(numberInput[1]);
                    String property = numberInput[2].toLowerCase();

                    if (firstNumber <= 0){
                        System.out.println("The first parameter should be a natural number or zero.");
                        System.out.println();
                    } else if (secondNumber <= 0) {
                        System.out.println("The second parameter should be a natural number or zero.");
                        System.out.println();
                    } else {
                        getPropertyNTimes(firstNumber,secondNumber,property);
                    }



                }catch (NumberFormatException numberFormatException){
                    try {
                        long firstNumber = Long.parseLong(numberInput[0]);
                    }catch (NumberFormatException firstNumberException){
                        System.out.println();
                        System.out.println("The first parameter should be a natural number or zero.");
                    }
                    try {
                        long secondNumber = Long.parseLong(numberInput[1]);
                    }catch (NumberFormatException firstNumberException){
                        System.out.println();
                        System.out.println("The second parameter should be a natural number or zero.");
                    }
                }

            }
        }

    }

    private static void showPropertyInMultipleLine(long number) {
        System.out.println();
        System.out.println("Properties of " + number);

        boolean buzz = checkBuzz(number);
        System.out.println("        buzz:   "+buzz);

        boolean duck = checkDuck(String.valueOf(number));
        System.out.println("        duck:   " + duck);

        boolean palindromic = checkPalindromic(String.valueOf(number));
        System.out.println(" palindromic:   " + palindromic);

        boolean gapful = checkGapfulNumbers(String.valueOf(number));
        System.out.println("      gapful:   " + gapful);

        boolean spy = checkSpy(String.valueOf(number));
        System.out.println("         spy:   " + spy);

        boolean even = numberIsEven(number);
        System.out.println("        even:   " + even);
        System.out.println("         odd:   " + !even);
        System.out.println();
    }

    public static void showPropertyInOneLine(long number){
        System.out.print(number + " is ");
        if (checkBuzz(number)){
            System.out.print("buzz,  ");
        }
        if (checkDuck(String.valueOf(number))) {
            System.out.print("duck,  ");
        }
        if (checkPalindromic(String.valueOf(number))) {
            System.out.print("palindromic,  ");
        }
        if (checkGapfulNumbers(String.valueOf(number))) {
            System.out.print("gapful,  ");
        }
        if (checkSpy(String.valueOf(number))) {
            System.out.print("spy,  ");
        }
        if (numberIsEven(number)) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }

    public static void showPropertyInRange(long firstNumber, long secondNumber){
        for (int i = 0; i < secondNumber; i++) {
            showPropertyInOneLine(firstNumber);
            firstNumber++;
        }
    }

    public static void getPropertyNTimes(long firstNumber, long secondNumber, String property){
        long counter = 0;

        while (true){

            if (property.equals("buzz")){
                if (checkBuzz(firstNumber)){
                    showPropertyInOneLine(firstNumber);
                    counter++;
                }
                firstNumber++;
            } else if (property.equals("duck")) {
                if (checkDuck(String.valueOf(firstNumber))){
                    showPropertyInOneLine(firstNumber);
                    counter++;
                }
                firstNumber++;
            } else if (property.equals("palindromic")) {
                if (checkPalindromic(String.valueOf(firstNumber))){
                    showPropertyInOneLine(firstNumber);
                    counter++;
                }
                firstNumber++;
            } else if (property.equals("gapful")) {
                if (checkGapfulNumbers(String.valueOf(firstNumber))){
                    showPropertyInOneLine(firstNumber);
                    counter++;
                }
                firstNumber++;
            } else if (property.equals("spy")) {
                if (checkSpy(String.valueOf(firstNumber))){
                    showPropertyInOneLine(firstNumber);
                    counter++;
                }
                firstNumber++;
            } else if (property.equals("even")) {
                if (numberIsEven(firstNumber)){
                    showPropertyInOneLine(firstNumber);
                    counter++;
                }
                firstNumber++;
            } else if (property.equals("odd")) {
                if (!numberIsEven(firstNumber)){
                    showPropertyInOneLine(firstNumber);
                    counter++;
                }
                firstNumber++;
            } else {
                System.out.println();
                System.out.println("The property ["+property+"] is wrong");
                System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD]");
                break;
            }

            if(counter == secondNumber){
                break;
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
        System.out.println("- two natural numbers and a property to search for;");
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
        return ((userInput.length() >= 3) && (Long.parseLong(userInput) % Long.parseLong(firstAndLastDigit) == 0)) ? true : false;
    }

    public static boolean checkPalindromic(String number){
        StringBuilder stringBuilder = new StringBuilder(number);
        String reversedNumber = stringBuilder.reverse().toString();
        return (number.equals(reversedNumber)) ? true : false;
    }

    public static boolean checkSpy(String number){
        long sum = 0;
        long product = 1;
        for (int i = 0; i < number.length(); i++) {
            sum += Long.parseLong(String.valueOf(number.charAt(i)));
            product *= Long.parseLong(String.valueOf(number.charAt(i)));
        }
        return (sum == product) ? true: false;
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
