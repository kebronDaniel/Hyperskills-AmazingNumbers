package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Enter a natural number:");

        String numberInput = scanner.nextLine();
        int number = Integer.parseInt(numberInput);

        if (checkNaturalNumber(number)){
            System.out.println("Properties of " + number);
            boolean even = numberIsEven(number);
            System.out.println("        even:   " + even);
            System.out.println("        odd:   " + !even);

            boolean buzz = checkBuzz(number);
            System.out.println("        buzz:   "+buzz);

            boolean duck = checkDuck(numberInput);
            System.out.println("        duck:   " + duck);
        } else {
            System.out.println("This number is not natural!");
        }
    }


    public static boolean checkNaturalNumber(int number){
        return (number <= 0) ? false : true;
    }
    public static boolean numberIsEven(int number){
        return number % 2 == 0 ? true:false;
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

    public static boolean checkBuzz(int number){

        int lastDigit = number % 10;
        int remainingDigits = number / 10;
        int checker = ((remainingDigits - (lastDigit*2)) % 7);

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
