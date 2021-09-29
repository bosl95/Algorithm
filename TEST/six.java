public class four {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(
                new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}},
                new int[][]{{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2,1,0,3,1,2}, {1, 0, 1, 3, 3, 1}}
        ));
//        System.out.println(solution.solution(new int[][]{{2, 1, 1, 1}, {1, 1, 1, 1}}, new int[][]{{1, 0, 0, 1, 3, 1}}));
    }

    static class Solution {
        public int solution(int[][] board, int[][] skill) {
            int n = board.length;
            int m = board[0].length;
            int answer = n * m;

            for (int i = 0; i < skill.length; i++) {
                int lx = skill[i][3];
                int ly = skill[i][4];
                int crash = skill[i][5];
                for (int x = skill[i][1]; x <= lx; x++) {
                    for (int y = skill[i][2]; y <= ly; y++) {
                        if (skill[i][0] == 1) {
                            if (board[x][y] > 0 && board[x][y] - crash <= 0) answer--;
                            board[x][y] -= crash;
                        } else {
                            if (board[x][y] <= 0 && board[x][y] + crash > 0) answer++;
                            board[x][y] += crash;
                        }
                    }
                }
            }

            return answer;
        }
    }
}
