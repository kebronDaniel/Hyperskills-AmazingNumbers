import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String subString = scanner.nextLine();
        int counter = 0;
        for (;;){
            if (word.contains(subString)){
                int index = word.indexOf(subString);
                word = word.replaceFirst(subString," ");
                counter++;
            }
            else {
                break;
            }
        }
        System.out.println(counter);
    }
}
