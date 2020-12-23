package ARRAY.Backjoon_5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        LinkedList<String> key_logger = new LinkedList<>();

        int num = Integer.parseInt(br.readLine());
        int cursor;

        while (num-- > 0) {
            key_logger.clear();
            cursor = 0;
            for (String word : br.readLine().split("")) {
                if (word.equals("<")) {
                    cursor = !key_logger.isEmpty() ? --cursor : cursor;
                } else if (word.equals(">")) {
                    cursor = cursor < key_logger.size() ? ++cursor : cursor;
                } else if (word.equals("-")) {
                    if (cursor > 0) {
                        key_logger.remove(--cursor);
                    }
                } else {
                    key_logger.add(cursor++, word);
                }
            }
            sb.append(String.join("", key_logger));
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
