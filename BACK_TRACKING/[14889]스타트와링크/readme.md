## [[14889] 스타트와 링크](https://www.acmicpc.net/problem/14889)

> 입력

	4
	0 1 2 3
	4 0 5 6
	7 1 0 2
	3 4 5 0

> 출력

	0

> ### Backtracking을 이용한 풀이

**![](https://lh5.googleusercontent.com/y10pPCRE8dOl1DMHqJOeHVGhVWqs69knDHG7Dvw3RuhPrtFtva9ITXOA0CKyAwXpBnBlNQhGBVwkAamngAZJUUQ71q_tnfem5RxePngfISJYoncs5lPIU7SkwuCV-vEU88NvyNlv)**

+) 두 팀의 능력치 차이를 계산해주는 함수

	def calc(a, b, stats):  
	    resA, resB = 0, 0  
	    for a1, b1 in zip(a, b):  
	        for a2, b2 in zip(a, b):  
	            if a1 != a2:  
	                resA += stats[a1][a2]  
	            if b1 != b2:  
	                resB += stats[b1][b2]  
	  
	    return abs(resA-resB)
