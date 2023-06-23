import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String keyWord = "The";
        if (word.contains(keyWord)){
            System.out.println(word.indexOf(keyWord));
        } else if (word.contains(keyWord.toLowerCase())){
            System.out.println(word.indexOf(keyWord.toLowerCase()));
        }else {
            System.out.println(word.indexOf(keyWord));
        }
    }
}
