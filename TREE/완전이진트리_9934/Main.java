package TREE.완전이진트리_9934;

import java.io.*;

public class Main {

    static int k;
    static String[] nums;
    static StringBuffer[] ans;
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        k = Integer.parseInt(br.readLine());

        nums = br.readLine().split(" ");

        ans = new StringBuffer[k];
        for (int i = 0; i < k; i++) {
            ans[i] = new StringBuffer();
        }

        inorder(0);
        for (StringBuffer bf : ans) {
            bw.write(bf.toString());
            bw.write("\n");
        }
        bw.flush();
    }

    private static void inorder(int depth) {
        if (depth == k) return;

        inorder(depth + 1);
        ans[depth].append(nums[idx++]).append(" ");
        inorder(depth + 1);
    }
}
