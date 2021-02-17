# [[11727]2xn 타일링2](https://www.acmicpc.net/problem/11727)

## Dynamic Programming을 이용한 풀이

<image src='https://lh6.googleusercontent.com/X11oxVgnBzy52kPOfwynhVSmcAmgrORgVmeF6soUPrDKt2WV8X-C5HHexQ0ttkOEMUHYRNzcUdAjY2VXi3yqtVTwDKfWXxrCoYSwZ1WZ9Wtoxtmex2cligvJuvrN3m3uVjNXJFUr' width='70%'>

- dp의 규칙만 찾으면 쉽게 풀 수 있는 문제
- 여기서 n=4까지 구해보면 dp[i] = dp[i-1]+dp[i-2]*2 라는 규칙을 발견할 수 있다.
- 요번엔 JAVA를 이용하여 풀어보았다.