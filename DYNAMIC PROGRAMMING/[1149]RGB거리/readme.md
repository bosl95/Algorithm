
# [[1149]RGB 거리](https://www.acmicpc.net/problem/1149)  
  
## Dynamic Programming을 이용한 풀이  
<image src="https://lh5.googleusercontent.com/SA0e8T4LWSoZIZaFXXZuxKkGeEy1f8UtkMnWZzBxtx7u6CdjmPgwe6McA8_omEX-T-PxKliy2OHGdCYBWhB9DFCxWdop-szLx9gDB9_OFi5JYiG4Yr-yMaUzZgdJULseBLit1rx4" width="80%">
  
- i번째 집을 기준으로 현재까지의 비용을 나타내는 배열 DP를 만들어줬다.  
- DP[i] = [ i번째 빨강집, i번째 초록집, i번째 파랑] 일때 최소 비용을 계속 구하는 방식.