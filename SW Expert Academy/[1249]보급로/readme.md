## [[1249]보급로](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD&categoryId=AV15QRX6APsCFAYD&categoryType=CODE)

> 알고리즘

문제는 BFS로 풀리는 단순한 알고리즘이었으나,
다음 방문할 칸의 인덱스를 가지는 stack에 추가를 하는 경우에서
visit을 0으로 초기값을 설정해 0인 경우 반드시 재방문하게 설정해놓았다.
그러나 반드시 초기값만 0이 아니라 방문한 결과가 0일수도 있다는 점을 간과했다.
visit을 -1로 설정해주고, 조건을 제대로 넣어주니 통과