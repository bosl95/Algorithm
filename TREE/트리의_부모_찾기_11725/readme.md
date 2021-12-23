# [[11725]트리의 부모 찾기](https://www.acmicpc.net/problem/11725)

## Tree를 이용한 알고리즘
### Tree + BFS를 이용하여 풀 수 있었다.<br>
### 각 정점이 가질 Tree[i]의 값들은 부모 노드 아니면 자식 노드라는 것에만 유의하면 쉽게 풀 수 있는 문제이다.<br>

  
   
## JAVA로 풀어보기

```java
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] parent = new int[n + 1];
        Map<Integer, List<Integer>> nodes = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            nodes.put(i, new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            nodes.get(node1).add(node2);
            nodes.get(node2).add(node1);
        }

        Deque<Integer> queue = new LinkedList<>();
        queue.addLast(1);
        while (!queue.isEmpty()) {
            int x = queue.pollFirst();
            for (int next : nodes.get(x)) {
                if (parent[x] == next) continue;
                queue.addLast(next);
                parent[next] = x;
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
}
```

- `1492ms` 


- 수정한 버전(Main.java 코드)은  Map 대신 ArrayList를 배열 형식으로 사용
- 사실 성능적인 면에서 큰 영향은 주지 않았다. (오히려 StringBuilder를 통해 출력하는 부분이 더 큰 성능 향상을 보였다.)