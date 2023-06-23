import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        System.out.println(pieceOfAlphabet(userInput));
    }

    public static boolean pieceOfAlphabet(String userInput){
        int ascii = 0;
        for (int i = 0; i < userInput.length()-1; i++) {
            if ((int)userInput.charAt(i + 1) - (int)userInput.charAt(i) != 1){
                return false;
            }
        }
        return true;
    }
}
