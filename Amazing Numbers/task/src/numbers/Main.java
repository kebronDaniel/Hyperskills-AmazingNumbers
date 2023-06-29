package numbers;

import org.w3c.dom.Attr;

import java.lang.reflect.Method;
import java.util.*;

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
                        showPropertyInRange(firstNumber,secondNumber);
                        System.out.println();
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
                    errorMessageForNumberInputs(numberInput);
                }
            }
            if (numberInput.length == 3){

                try {
                    long firstNumber = Long.parseLong(numberInput[0]);
                    long secondNumber = Long.parseLong(numberInput[1]);
                    String property = numberInput[2].toLowerCase();

                    if (!checkNaturalNumber(firstNumber)){
                        System.out.println("The first parameter should be a natural number or zero.");
                        System.out.println();
                    } else if (!checkNaturalNumber(secondNumber)) {
                        System.out.println("The second parameter should be a natural number or zero.");
                        System.out.println();
                    } else {
                        getPropertyNTimes(firstNumber,secondNumber,property);
                    }

                }catch (NumberFormatException numberFormatException){
                    errorMessageForNumberInputs(numberInput);
                }

            }
            if (numberInput.length == 4){
                try {
                    long firstNumber = Long.parseLong(numberInput[0]);
                    long secondNumber = Long.parseLong(numberInput[1]);
                    String[] properties = new String[]{numberInput[2].toLowerCase(), numberInput[3].toLowerCase()};

                    if (!checkNaturalNumber(firstNumber)){
                        System.out.println("The first parameter should be a natural number or zero.");
                        System.out.println();
                    } else if (!checkNaturalNumber(secondNumber)) {
                        System.out.println("The second parameter should be a natural number or zero.");
                        System.out.println();
                    } else {
                        getTwoPropertiesNTimes(firstNumber,secondNumber,properties);
                    }

                }catch (NumberFormatException numberFormatException){
                    errorMessageForNumberInputs(numberInput);
                }
            }
        }

    }

    private static void errorMessageForNumberInputs(String[] numberInput) {
        try {
            long firstNumber = Long.parseLong(numberInput[0]);
        }catch (NumberFormatException firstNumberException){
            System.out.println();
            System.out.println("The property ["+ numberInput[0] +"] is wrong.");
            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY]");
        }
        try {
            long secondNumber = Long.parseLong(numberInput[1]);
        }catch (NumberFormatException secondNumberException){
            System.out.println();
            System.out.println("The property ["+ numberInput[1] +"] is wrong.");
            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY]");
        }
    }

    public static void showPropertyInMultipleLine(long number) {
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

        boolean square = checkSquare(number);
        System.out.println("      square:   " + square);

        boolean sunny = checkSquare(number + 1);
        System.out.println("       sunny:   " + sunny);

        boolean even = numberIsEven(number);
        System.out.println("        even:   " + even);
        System.out.println("         odd:   " + !even);
        System.out.println();
    }


    public static void showPropertyInOneLine(long number){

        String[] properties = returnPropertyOfNumber(number);

        System.out.print(number + " is ");

        for (String property: properties
             ) {
            if (property != null){
                System.out.print(property+ ",  ");
            }
        }
    }

    public static String[] returnPropertyOfNumber(long number){
        String[] properties = new String[9];

        if (checkBuzz(number)){
            properties[0] = "buzz";
        }
        if (checkDuck(String.valueOf(number))) {
            properties[1] = "duck";
        }
        if (checkPalindromic(String.valueOf(number))) {
            properties[2] = "palindromic";
        }
        if (checkGapfulNumbers(String.valueOf(number))) {
            properties[3] = "gapful";
        }
        if (checkSpy(String.valueOf(number))) {
            properties[4]="spy";
        }
        if (checkSquare(number)){
            properties[5] = "square";
        }
        if (checkSquare(number + 1)){
            properties[6] = "sunny";
        }
        if (numberIsEven(number)) {
            properties[7] = "even";
        } else {
            properties[8] = "odd";
        }
        return properties;
    }

    public static void showPropertyInRange(long firstNumber, long secondNumber){
        for (int i = 0; i < secondNumber; i++) {
            showPropertyInOneLine(firstNumber);
            System.out.println();
            firstNumber++;
        }
    }

    public static void getPropertyNTimes(long firstNumber, long secondNumber, String property){

        String[] namesOfProperties = new String[]{
                "buzz","duck","palindromic","gapful","spy","square","sunny","even","odd"
        };

        List<String> propertiesList = new ArrayList<>(Arrays.asList(namesOfProperties));

        long counter = 0;

        if (propertiesList.contains(property.toLowerCase())){

            while (true){

                int index = propertiesList.indexOf(property.toLowerCase());
                String[] result = returnPropertyOfNumber(firstNumber);

                if (result[index] != null){
                    showPropertyInOneLine(firstNumber);
                    System.out.println();
                    counter++;
                }
                firstNumber++;

                if (counter == secondNumber){
                    System.out.println();
                    break;
                }
            }

        } else {
            System.out.println();
            System.out.println("The property ["+ property +"] is wrong.");
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD]");
        }

    }

    public static void getTwoPropertiesNTimes(long firstNumber, long secondNumber, String[] properties){

        List<String> props = Arrays.asList(properties);

        String[] namesOfProperties = new String[]{
                "buzz","duck","palindromic","gapful","spy","square","sunny","even","odd"
        };

        List<String> propertiesList = new ArrayList<>(Arrays.asList(namesOfProperties));

        long counter = 0;

        if ((props.contains("even") && props.contains("odd")) ||
                (props.contains("duck") && props.contains("spy")) ||
                (props.contains("sunny") && props.contains("square"))){

            System.out.println();
            System.out.println("The request contains mutually exclusive properties: [" + properties[0].toUpperCase()+",  " + properties[1].toUpperCase() + "]");
            System.out.println("There are no numbers with these properties.");
            System.out.println();

        } else if ((!propertiesList.contains(properties[0]) && (!propertiesList.contains(properties[1])))){
            System.out.println("The properties [" + properties[0]+",  " + properties[1] + "] are wrong.");
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD]");

        } else if (!propertiesList.contains(properties[0])) {
            System.out.println();
            System.out.println("The property ["+ properties[0] +"] is wrong.");
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD]");
        } else if (!propertiesList.contains(properties[1])) {
            System.out.println();
            System.out.println("The property ["+ properties[1] +"] is wrong.");
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD]");
        } else {
            if ((propertiesList.contains(properties[0].toLowerCase())) && (propertiesList.contains(properties[1].toLowerCase()))){

                while (true){
                    List<String> numProp = Arrays.asList(returnPropertyOfNumber(firstNumber));
                    if (numProp.contains(properties[0]) && numProp.contains(properties[1])){
                        counter++;
                        showPropertyInOneLine(firstNumber);
                        System.out.println();
                    }
                    firstNumber++;
                    if (counter == secondNumber){
                        System.out.println();
                        break;
                    }
                }
            }
        }
    }

    public static void showInfo() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and two properties to search for;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
        System.out.println();
    }

    public static boolean checkSqrt(long number){
        double sqrt = Math.sqrt(number);
        double floorNumber = Math.floor(sqrt);
        return (sqrt == floorNumber)? true : false;
    }

    public static boolean checkNaturalNumber(long number){
        return (number <= 0) ? false : true;
    }
    public static boolean numberIsEven(long number){
        return number % 2 == 0 ? true:false;
    }

    public static boolean checkSquare(long number){
        double sqrt = Math.sqrt(number);
        double floorNumber = Math.floor(sqrt);
        return (sqrt == floorNumber) ? true : false;
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
