package chanlle;

import java.util.Objects;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
//        Solution1 solution1 = new Solution1();
//        System.out.println(solution1.solution("2x^5 + 3x^3 + 2x^1", "6x^6 + 4x^4 + 3x^3 + 2x^2"));

        Solution2 solution2 = new Solution2();
//        System.out.println(solution2.solution(
//                new int[][]{{1,2},{3,4},{5,6},{-1,7},{8,9},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}},
//                new int[][]{{1,2},{-1,-1},{-1,-1}}));
//        System.out.println(solution2.solution(new int[][]{{1,2},{3,4},{5,6},{-1,7},{8,9},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}},
//                new int[][]{{-1, 1}, {-1, -1}}));
//        System.out.println(solution2.solution(new int[][]{{-1, -1}}, new int[][]{{-1, -1}}));

//        Solution3 solution3 = new Solution3();
//        System.out.println(solution3.solution(new int[][]{{3, 9, 2, 7}, {10, 6, 8, 4}, {1, 4, 9, 10}, {5, 7, 8, 4}}));
        // 6
    }
}


class Solution {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[][] maxLength;
    static int answer;
    static int n, m;

    public int solution(int[][] R) {
        n = R.length;
        m = R[0].length;
        maxLength = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean[][] visit = new boolean[n][m];
                visit[i][j] = true;
                findMaxLength(i, j, R, visit, 1);
            }
        }

        return answer;
    }

    private void findMaxLength(int i, int j, int[][] r, boolean[][] visit, int length) {

        for (int k = 0; k < 4; k++) {
            int mx = dx[k] + i;
            int my = dy[k] + j;
            if (validIndex(mx, my) && !visit[mx][my] && r[mx][my] > r[i][j] && maxLength[mx][my] < length + 1) {
                visit[mx][my] = true;
                if (answer < length + 1) {
                    answer = length + 1;
                    maxLength[i][j] = length + 1;
                }
                findMaxLength(mx, my, r, visit, length + 1);
                visit[mx][my] = false;
            }
        }
    }

    private boolean validIndex(int mx, int my) {
        return 0 <= mx && mx < n && 0 <= my && my < m;
    }

}

class Solution1 {
    public String solution(String exp1, String exp2) {
        String sp = "x\\^";
        int[] num = new int[101]; // 지수
        String[] exp1_split = exp1.split(" \\+ ");
        String[] exp2_split = exp2.split(" \\+ ");

        split(sp, num, exp1_split);
        split(sp, num, exp2_split);

        StringJoiner sb = new StringJoiner(" + ");
        for (int i = 100; i > 0; i--) {
            if (num[i] != 0) {
                sb.add(num[i] + "x^" + i);
            }
        }

        return sb.toString();
    }

    private void split(String sp, int[] num, String[] exp1_split) {
        for (int i = 0; i < exp1_split.length; i++) {
            String s = exp1_split[i];
            String[] split = s.split(sp);
            int a = Integer.parseInt(split[0]); // 계수
            int b = Integer.parseInt(split[1]); // 지수
            num[b] += a;
        }
    }
}

class Solution2 {
    public int solution(int[][] t1, int[][] t2) {
        int answer = 0;

        Node[] nodes1 = new Node[t1.length + 1];
        for (int i = t1.length - 1; i >= 0; i--) {
            int leftIdx = t1[i][0];
            int rightIdx = t1[i][1];
            nodes1[i] = new Node((leftIdx == -1 ? null : nodes1[leftIdx]),
                    (rightIdx == -1 ? null : nodes1[rightIdx]));
        }

        Node[] nodes2 = new Node[t2.length + 1];
        for (int i = t2.length - 1; i >= 0; i--) {
            int leftIdx = t2[i][0];
            int rightIdx = t2[i][1];
            nodes2[i] = new Node((leftIdx == -1 ? null : nodes2[leftIdx]),
                    (rightIdx == -1 ? null : nodes2[rightIdx]));
        }

        for (int i = 0; i < t1.length; i++) {
            if (nodes1[i].equals(nodes2[0])) {
                answer++;
            }
        }

        return answer;
    }

    class Node {
        Node left;
        Node right;

        public Node(Node left, Node right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(left, node.left) && Objects.equals(right, node.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }
    }
}

class Solution3 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[][] maxLength;
    static int answer;
    static int n, m;

    public int solution(int[][] R) {
        n = R.length;
        m = R[0].length;
        maxLength = new int[n][m];

        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(R[i][j], max);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean[][] visit = new boolean[n][m];
                if ((max - R[i][j]) < maxLength[i][j]) continue;
                visit[i][j] = true;
                findMaxLength(i, j, R, visit, 1);
            }
        }

        return answer;
    }

    private void findMaxLength(int i, int j, int[][] r, boolean[][] visit, int length) {
        for (int k = 0; k < 4; k++) {
            int mx = dx[k] + i;
            int my = dy[k] + j;
            if (validIndex(mx, my) && !visit[mx][my] && r[mx][my] > r[i][j] && maxLength[mx][my] < length + 1) {
                visit[mx][my] = true;
                if (answer < length + 1) {
                    answer = length + 1;
                    maxLength[i][j] = length + 1;
                }
                findMaxLength(mx, my, r, visit, length + 1);
                visit[mx][my] = false;
            }
        }
    }

    private boolean validIndex(int mx, int my) {
        return 0 <= mx && mx < n && 0 <= my && my < m;
    }

}

class Solution3_new {

    public int solution(int[][] R) {
        return 0;
    }
}