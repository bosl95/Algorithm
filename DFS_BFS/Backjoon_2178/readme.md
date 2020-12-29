# [[2178]미로 탐색]()

## BFS/DFS를 이용한 풀이

- stack을 활용하기 ==> 스택은 List에서 상속받은 `add()`와 스택 내에서 제공하는`push()`가 있는데,<br>의미를 명확하게 하기 위하여 `push()`를 사용하자

- DFS를 사용해서 빠른 길을 찾아주려고 했으나 `예제 4`와 같이 먼저 찾는다고 최소 길이가 아니기 때문에 탐색이 필요하다.

```java
7 7
1011111
1110001
1000001
1000001
1000001
1000001
1111111
```

<br>

- DFS : Stack을 활용한 나의 첫번째 풀이  `시간 : 1376ms`

```java
public class Main {
    static String[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new String[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().split("");
        }

        // DFS
        bw.write(String.valueOf(DFS(n, m)));
        bw.flush();
        bw.close();
    }

    private static int DFS(int n, int m) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0});

        int[][] visit = new int[n][m];
        visit[0][0] = 1;

        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            for (int i = 0; i < 4; i++) {
                int mx = dx[i] + pos[0];
                int my = dy[i] + pos[1];
                if (0 <= mx && mx < n && 0 <= my && my < m && arr[mx][my].charAt(0) == '1') {
                    if (visit[mx][my] == 0 || visit[mx][my] > visit[pos[0]][pos[1]] + 1) {
                        visit[mx][my] = visit[pos[0]][pos[1]] + 1;
                        if (mx == n - 1 && my == m - 1) continue;
                        stack.push(new int[]{mx, my});
                    }
                }
            }
        }

        return visit[n - 1][m - 1];
    }
}
```

<br>

- BFS : Queue를 활용하여 풀기  `시간 : 184ms`

```java
public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = temp[j].charAt(0) - '0';
            }
        }

        // BFS
        System.out.print(BFS(n, m));
    }

    private static int BFS(int n, int m) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        int[][] visit = new int[n][m];
        visit[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int mx = dx[i] + pos[0];
                int my = dy[i] + pos[1];
                if (0 <= mx && mx < n && 0 <= my && my < m && arr[mx][my] == 1 && visit[mx][my] == 0) {
                    visit[mx][my] = visit[pos[0]][pos[1]] + 1;
                    queue.offer(new int[]{mx, my});
                }
            }
        }
        return visit[n - 1][m - 1];
    }
}
```

<br>

- BFS : Queue를 배열 형태로 풀기 : `시간 : 136ms`

```java
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                if (temp.charAt(j) == '0') visit[i][j] = true;
            }
        }

        int[][] queue = new int[n * m][3];
        int now = 0;
        int last = 1;

        queue[now][2] = 1;
        visit[0][0] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (now <= last) {
            for (int i = 0; i < 4; i++) {
                int mx = queue[now][0] + dx[i];
                int my = queue[now][1] + dy[i];
                if (0 <= mx && mx < n && 0 <= my && my < m) {
                    if (!visit[mx][my]) {
                        queue[last][0] = mx;
                        queue[last][1] = my;
                        queue[last][2] = queue[now][2] + 1;
                        visit[mx][my] = true;
                        if (mx == n - 1 && my == m - 1) {
                            System.out.println(queue[last][2]);
                            return;
                        }
                        last++;
                    }
                }
            }
            now++;
        }
    }
}
```

  - 큐 배열이 방문할 수 있는 경우는 총 `n*m` 이므로, queue 배열의 크기를 `queue[n*m][3]`으로 설정 (x, y, 거리 순으로 저장)
  - 움직일 수 있는 방향이 존재할 때마다 queue에 넣어주고 마지막 인덱스인 `last`를 하나씩 증가시켜준다.
  - (n, m) 좌표를 방문하면 종료시키고, 만약 (n, m)을 방문하지 못한다면 `while(now <= last)` 조건을 통해서 반복문을 빠져나올 수 있다. (문제는 예외가 발생하지 않는다.)