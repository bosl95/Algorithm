package Programmers.거리두기확인하기;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] results = solution.solution(
                new String[][]{
                        {
                                "POOOP",
                                "OXXOX",
                                "OPXPX",
                                "OOXOX",
                                "POXXP"
                        },
                        {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                        {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                        {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                        {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
                }
        );
        for (int result : results) {
            System.out.print(result + " ");
        }
    }
}

class Solution {

    public static final int SIZE = 5;

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            answer[i] = check(places[i]);
        }

        return answer;
    }

    private int check(String[] place) {
        char[][] newPlace = new char[SIZE][SIZE];
        for (int i = 0; i < place.length; i++) {
            newPlace[i] = place[i].toCharArray();
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (newPlace[i][j] == 'P') {
                    if (bfs(i, j, newPlace) != 1) return 0;
                }
            }
        }

        return 1;

    }

    int[][] mv = new int[][]{
            {-1, 0}, {0, -1}, {1, 0}, {0, 1}
    };

    private int bfs(int i, int j, char[][] place) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        int[][] visit = new int[SIZE][SIZE];
        visit[i][j] = 1;

        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            for (int k = 0; k < 4; k++) {
                int mx = xy[0] + mv[k][0];
                int my = xy[1] + mv[k][1];
                if (validIndex(mx, my) && visit[mx][my] == 0 && place[mx][my] != 'X') {
                    if (place[mx][my] == 'P') return 0;

                    visit[mx][my] = visit[xy[0]][xy[1]] + 1;
                    if (visit[mx][my] <= 2) queue.offer(new int[]{mx, my});
                }
            }
        }
        return 1;
    }

    private boolean validIndex(int mx, int my) {
        return 0 <= mx && mx < 5 && 0 <= my && my < 5;
    }
}