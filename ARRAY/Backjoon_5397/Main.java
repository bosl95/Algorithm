package ARRAY.Backjoon_5397;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String pwd = br.readLine();
            System.out.println(getPwd(pwd));
        }
    }

    private static String getPwd(String pwd) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> pre = new Stack<>();
        Stack<Character> post = new Stack<>();

        for (int i = 0; i < pwd.length(); i++) {
            switch (pwd.charAt(i)) {
                case '<':
                    if (!pre.isEmpty()) post.push(pre.pop());
                    break;
                case '>':
                    if (!post.isEmpty()) pre.push(post.pop());
                    break;
                case '-':
                    if (!pre.isEmpty()) pre.pop();
                    break;
                default:
                    pre.push(pwd.charAt(i));
                    break;
            }
        }
        while (!post.isEmpty())  {
            pre.push(post.pop());
        }
        for (int i=0; i<pre.size(); i++) {
            sb.append(pre.elementAt(i));
        }

        return sb.toString();
    }
}
