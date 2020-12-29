# [[1012]유기농 배추](https://www.acmicpc.net/problem/1012)

## DFS/BFS를 이용한 풀이

- 첫번째 방법
  - 입력과 동시에 근처에 배추가 없으면 벌레 카운트
  - 근처에 배추가 있으면 이미 벌레가 카운트 되었으므로 패스
    
```java
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] arr = new int[m][n];
            int count = 0;
            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
                int i = -1;
                while (i++ < 3) {
                    int mx = x + dx[i];
                    int my = y + dy[i];
                    if (0 <= mx && mx < m && 0 <= my && my < n && arr[mx][my] == 1) {
                        break;
                    }
                }
                if (i == 4) count++;
            }
            bw.write(String.valueOf(count));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
```

- 반례 : 배추가 이어지는 순서대로 입력되지 않는 경우

```java
1
6 6 10
0 1
1 0
1 1
1 2
2 1
3 4
4 4
4 3
4 5
5 4
```

<br>

- 두번째 