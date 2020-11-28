package SORT.Backjoon_1427;

import java.util.*;

public class backjoon_1427 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        String[] stringArray = String.valueOf(N).split("");
        ArrayList<Integer> intArray = new ArrayList<>();

        for (String s : stringArray) {
            intArray.add(Integer.parseInt(s));
        }

        intArray.sort(Comparator.reverseOrder());

        String answer = "";

        for (int x : intArray) {
            answer += String.valueOf(x);
        }

        System.out.println(answer);
    }
}
