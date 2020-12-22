package ARRAY.Backjoon_1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<String> str = new LinkedList<>(Arrays.asList(br.readLine().split("")));
        ListIterator<String> iter = str.listIterator(str.size());

        int n = Integer.parseInt(br.readLine());
        String command;

        while (n-- > 0) {
            command = br.readLine();
            if (command.equals("L")) {
                if (iter.hasPrevious()) {
                    iter.previous();
                }
            } else if (command.equals("D")) {
                if (iter.hasNext()) {
                    iter.next();
                }
            } else if (command.equals("B")) {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            } else {
                iter.add(command.split(" ")[1]);
            }
        }

        for (String s : str) {
            sb.append(s);
        }
        System.out.println(String.join("", str));
    }
}
