## [[15649] N과 M (1)](https://www.acmicpc.net/problem/15649)

> 입력

	4 4

> 출력

	1 2 3 4
	1 2 4 3
	1 3 2 4
	1 3 4 2
	1 4 2 3
	1 4 3 2
	2 1 3 4
	2 1 4 3
	2 3 1 4
	2 3 4 1
	2 4 1 3
	2 4 3 1
	3 1 2 4
	3 1 4 2
	3 2 1 4
	3 2 4 1
	3 4 1 2
	3 4 2 1
	4 1 2 3
	4 1 3 2
	4 2 1 3
	4 2 3 1
	4 3 1 2
	4 3 2 1

> #### backtracking을 이용한 풀이

어렵지 않은 backtracking 문제
1 ⇒ 2 ⇒ 3 ⇒ 4
다음 다시 3으로 돌아가
1 ⇒ 2 ⇒ 4 ⇒ 3
그다음 '2'로 돌아가서
1 ⇒ 3 ⇒ ... 
이런식으로 백트래킹을 진행해주는 알고리즘을 구현하였다.
 
 처음 풀었던 나의 풀이는 itertools 모듈에서 permutations을 이용한 풀이였는데,
 내가 직접 짠 코드와 차이를 비교해보았다.
 
 
|| 나의 코드| 모듈 |
|--|--|--|
|코드 길이| 469B | 147B |
|메모리|29380kb | 34356kb|
|시간|180ms|240ms|

전체적으로 메모리면에서는 나의 코드가 좋지만 길이나 시간은 itertools  모듈이 더 좋았다.

<br>

### JAVA 버전 <br>

- 스택 사용하기 : 매번 스택에 숫자를 담아 중복을 체크해주면서 탐색한다.

```java
    private static void backtracking(int i, Stack<Integer> list, int num) throws IOException {
        if (num == m) {
            for (int x : list) {
                bw.write(String.valueOf(x));
                bw.write(" ");
            }
            bw.write("\n");
            return;
        }

        for (int k=1; k<=n; k++) {
            if (list.contains(k)) continue;
            list.push(k);
            backtracking(k, list, num + 1);
            list.pop();
        }
    }
```

<br>

- `char[] path`를 이용해서 출력값을 미리 데이터에 저장해두기

  - 특이한 점은 짝수번째 자리에 미리 공백인 ' '를 넣어두고 시작한다.
  - `path[i]`에 방문되는 좌표를 담아두고 마지막에 총 출력한다.

```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];
        path = new char[m * 2];

        for (int i = 1; i < 2 * m; i += 2) {
            path[i] = ' ';
        }

        backtracking(0);
        System.out.println(sb);
    }

    private static void backtracking(int depth) {
        if (depth == m) {
            sb.append(path).append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                path[2 * depth] = (char) (i + '0');
                backtracking(depth + 1);
                visit[i] = false;
            }
        }
    }
```