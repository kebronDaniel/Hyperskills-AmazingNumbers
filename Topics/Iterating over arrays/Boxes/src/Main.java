import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] box1 = scanner.nextLine().split(" ");
        String[] box2 = scanner.nextLine().split(" ");

        int[] box1Values = new int[box1.length];
        for (int i = 0; i < box1.length; i++) {
            box1Values[i] = Integer.parseInt(box1[i]);
        }

        int[] box2Values = new int[box2.length];
        for (int i = 0; i < box2.length; i++) {
            box2Values[i] = Integer.parseInt(box2[i]);
        }

        Arrays.sort(box1Values);
        Arrays.sort(box2Values);

        boolean box1isGreater = true;
        boolean box2isGreater = true;

        for (int i = 0; i < box2Values.length; i++) {
            if (box1Values [i] <= box2Values [i]){
                box1isGreater = false;
            }
            if (box2Values[i] <= box1Values[i]) {
                box2isGreater = false;
            }
        }

        if (box2isGreater){
            System.out.println("Box 1 < Box 2");
        } else if (box1isGreater) {
            System.out.println("Box 1 > Box 2");
        } else if ((!box1isGreater) && (!box2isGreater)){
            System.out.println("Incompatible");
        }
    }
}