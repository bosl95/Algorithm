# [[9466]텀프로젝트](https://www.acmicpc.net/problem/9466)

## BFS/DFS를 이용한 풀이

<image src="https://lh6.googleusercontent.com/PcvK-bMLTB0eE17ytX6yf2GllpowznK74vd1knAExDGKh2AJmLf8XrWfgi84uJAolVXYNxl756ALifLLDBYE-7VAVwEqHYvQzZaySDT6GarFheBFlFgsuBrJY5VO_qberd2z3j_8" width="70%">

<br>

### 1차 풀이 (시간 초과) <br>

각 학생 노드를 모두 탐색하며 사이클이 완벽하게 생기는 경우만 체크해주었다.<br>
그러나 이 경우 **`시간 초과가 발생한다.`**

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int[] student;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            student = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                student[i] = Integer.parseInt(st.nextToken()) - 1;
            }
            int count = n;
            for (int i = 0; i < n; i++) {
                count -= makeTeam(i, n, student);
            }
            bw.write(String.valueOf(count)+'\n');
        }
        bw.flush();
        bw.close();
    }

    private static int makeTeam(int i, int n, int[] student) {
        boolean[] visit = new boolean[n];
        int start = i;

        while (true) {
            if (student[i] == start) {
                int count = 0;
                visit[i] = true;
                for (int k=0; k<n; k++) {
                    if (visit[k]) {
                        student[k] = -1;
                        count++;
                    }
                }
                return count;
            }

            if (visit[i] || student[i] == -1) return 0;
            visit[i] = true;
            i = student[i];
        }
    }
}
```

<br>

### 2차 풀이 (시간 초과) <br>

- 각 학생 노드를 탐색하는 중간에 발견되는 사이클도 체크해주었다.
- 이렇게 되는 경우 중간에 발견된 사이클은 뒤에서 다시 체크해줄 필요가 없기 때문에 시간이 단축되는 것을 확인할 수 있었다.
- 하지만 각 노드를 탐색 시 `visit` 배열을 계속해서 생성해주는데, 이 부분에서 시간초과가 발생하였다.

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int[] student;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            student = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                student[i] = Integer.parseInt(st.nextToken()) - 1;
            }
            int count = n;
            for (int i = 0; i < n; i++) {
                if (student[i] != -1) count -= makeTeam(i, n, student);
            }
            bw.write(String.valueOf(count) + '\n');
        }
        bw.flush();
        bw.close();
    }

    private static int makeTeam(int i, int n, int[] student) {
        boolean[] visit = new boolean[n];
        int start = i;

        while (true) {
            if (student[i] == start) {
                int count = 0;
                visit[i] = true;
                for (int k = 0; k < n; k++) {
                    if (visit[k]) {
                        student[k] = -1;
                        count++;
                    }
                }
                return count;
            }

            if (visit[i] || student[i] == -1) return 0;
            visit[i] = true;
            i = student[i];
        }
    }
}
```

<br>

### 3차 풀이 (통과)<br>

- 방문했던 배열인지 확인하는 `visit` 배열을 테스트 케이스마다 초기화해준다. (노드 탐색시는 초기화 되지 않는다.)
- 이미 사이클을 발견한 노드들은 `student` 배열에서 `-1로 설정`하여 체크해준다.


```java
import java.io.*;
import java.util.*;

public class Main {
    static int[] student;
    static boolean[] visit;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            student = new int[n];
            visit = new boolean[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                student[i] = Integer.parseInt(st.nextToken()) - 1;
            }
            count = 0;
            for (int i = 0; i < n; i++) {
                dfs(i);
            }
            bw.write(String.valueOf(n - count) + '\n');
        }
        bw.flush();
        bw.close();
    }

    private static void dfs(int now) {
        if (visit[now]) return;

        visit[now] = true;
        int next = student[now];

        if (!visit[next]) { // 아직 확인하지 않은 학생이라면 dfs
            dfs(next);
        } else if (student[next] != -1) {   // 아직 팀을 꾸리지 않은 학생이라면
            count++;
            for (int i=next; i!=now; i=student[i]) {    // 사이클을 도는(팀을 이루는) 학생들을 카운트
                count++;
            }
        }

        student[now] = -1;  // 현재 학생은 팀을 찾던, 찾지 못하던 방문이 끝났으므로 -1
    }
}
```