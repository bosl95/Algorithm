package TREE.트리_순회_1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        char[] lc = new char[n];
        char[] rc = new char[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char s1 = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            if (l != '.') lc[(s1 - 'A')] = l;
            char r = st.nextToken().charAt(0);
            if (r != '.') rc[(s1 - 'A')] = r;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(preorder(lc, rc, 'A')).append("\n");
        sb.append(inorder(lc, rc, 'A')).append("\n");
        sb.append(postorder(lc, rc, 'A')).append("\n");
        System.out.println(sb);
    }

    private static String preorder(char[] lc, char[] rc, char node) {
        String result = String.valueOf(node);
        if (lc[node - 'A'] != 0) result += preorder(lc, rc, lc[node - 'A']);
        if (rc[node - 'A'] != 0) result += preorder(lc, rc, rc[node - 'A']);
        return result;
    }

    private static String inorder(char[] lc, char[] rc, char node) {
        String result = String.valueOf(node);
        if (lc[node - 'A'] != 0) result = inorder(lc, rc, lc[node - 'A']) + result;
        if (rc[node - 'A'] != 0) result += inorder(lc, rc, rc[node - 'A']);
        return result;
    }

    private static String postorder(char[] lc, char[] rc, char node) {
        String result = String.valueOf(node);
        String left = "", right = "";
        if (lc[node - 'A'] != 0) left = postorder(lc, rc, lc[node - 'A']) ;
        if (rc[node - 'A'] != 0) right = postorder(lc, rc, rc[node - 'A']);
        return left + right + result;
    }
}


