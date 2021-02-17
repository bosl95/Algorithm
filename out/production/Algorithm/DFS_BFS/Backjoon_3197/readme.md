# [[3197]백조의 호수](https://www.acmicpc.net/problem/3197)

## BFS/DFS를 이용한 풀이

- 처음 나의 풀이는 두 백조의 위치를 모두 체크하고, 강을 녹이면서 두 백조가 만나는 경우를 찾아주었다.
- 하지만, 시간 초과가 발생했다.

```java
public class Main {
    static int[][] ice, visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] swan = new int[2][2];
    static Deque<Point> lake = new LinkedList<>(), search = new LinkedList<>();
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        ice = new int[r][c];
        visit = new int[r][c];
        // -1 : 빙판
        // 0 : 강
        // 1 : 첫번째 백조
        // 2 : 두번째 백조

        // '물공간과 접촉한 모든 빙판 공간은 녹는다.'
        String str;
        int count = 1;
        for (int i = 0; i < r; i++) {
            str = br.readLine();
            for (int j = 0; j < c; j++) {
                char c = str.charAt(j);
                if (c == 'X') {
                    ice[i][j] = -1;
                } else {
                    if (c == 'L') {
                        swan[count - 1][0] = i;
                        swan[count - 1][1] = j;
                        visit[i][j] = 1;
                        ice[i][j] = count++;
                    }
                    lake.add(new Point(i, j, ice[i][j]));
                }
            }
        }

        System.out.println(melt());
    }

    private static int melt() {
        search.add(new Point(swan[0][0], swan[0][1], 1));
        search.add(new Point(swan[1][0], swan[1][1], 2));
        int time = 0;

        while (true) {
            Deque<Point> next = new LinkedList<>();
            while (!search.isEmpty()) {
                Point p = search.poll();
                for (int i = 0; i < 4; i++) {
                    int mx = p.x + dx[i];
                    int my = p.y + dy[i];
                    if (0 <= mx && mx < r && 0 <= my && my < c) {
                        if (visit[mx][my] == 0) {
                            if (ice[mx][my] == 0) {
                                ice[mx][my] = ice[p.x][p.y];
                                search.add(new Point(mx, my, ice[mx][my]));
                            } else {
                                next.add(new Point(mx, my, p.count));
                            }
                            visit[mx][my] = 1;
                        } else {
                            if (ice[p.x][p.y] + ice[mx][my] == 3) {
                                return time;
                            }
                        }
                    }
                }
            }

            search = next;

            int n = lake.size();
            while (n-- > 0) {
                Point p = lake.poll();
                for (int i = 0; i < 4; i++) {
                    int mx = p.x + dx[i];
                    int my = p.y + dy[i];
                    if (0 <= mx && mx < r && 0 <= my && my < c && ice[mx][my] == -1) {
                        lake.add(new Point(mx, my, p.count));
                        ice[mx][my] = ice[p.x][p.y];
                        visit[mx][my] = 1;
                    }
                }
            }

            time++;
        }
    }

    static class Point {
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
```

<br>

- 그리고 다른 사람의 풀이를 찾아본 결과, 아래와 같이 생각할 수 있었다.
- ### 하나의 백조만을 탐색하며 물을 녹이다가 다른 백조를 만날 경우 종료 시킨다.
   - 백조는 물이 녹으면 그 위치를 탐색하러 갈 수 있다.
   - 따라서 한 마리의 백조만 탐색하다가 다른 물을 만나면 계속 이동하도록 해주고, 다른 백조를 만나면 종료시킨다.
  
<br>

### 탐색 과정<br>

1. 첫번째 백조를 탐색 큐에 넣는다.
2. 물인 곳을 lake 큐에 넣는다.
3. 탐색큐를 돌리면서 첫번째 백조가 갈 수 있는 경로를 탐색한다. (방문체크 하기)
  - 만약 다른 백조를 발견하면 종료시킨다.
  - 만약 물을 발견하면 탐색 큐에 넣는다.
  - 만약 벽을 발견하면 다음 큐에 넣는다.
  - 탐색큐가 완료되면 다음큐를 모두 탐색 큐에 넣는다.
4. lake 큐에 있는 애들을 물로 바꿔준다.
5. 하루가 지난다.
6. 3번 반복
