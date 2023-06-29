import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] userInput = scanner.nextLine().split(" ");
        if (Integer.parseInt(userInput[1]) > userInput[0].length()){
            System.out.println(userInput[0]);
        }else {
            System.out.println(userInput[0].substring(Integer.parseInt(userInput[1]), userInput[0].length()) + userInput[0].substring(0,Integer.parseInt(userInput[1])));
        }
    }
}