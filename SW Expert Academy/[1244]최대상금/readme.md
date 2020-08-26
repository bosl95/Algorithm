## [[1244]최대상금](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15Khn6AN0CFAYD&categoryId=AV15Khn6AN0CFAYD&categoryType=CODE)

> 알고리즘

- 처음 시도한 알고리즘(오답)
	![](https://lh5.googleusercontent.com/QfYmeSe7rmHT-4t0ziecW2nKKcYH2W4zn5kpnyHqlroyymy_6VSEnqS1v_PAiIl-NFFsmZxwTUHMOYCv1WJm2iIQ_xF1LV7uOoM87lrXgx6xxEE1Jg2MVq1A9rCkTouyxIjlVZkQ)
	
	이 알고리즘을 이용하면 아래의 예외가 발생한다.
	
		32888 교환횟수 2	===> 88823
		정답 : 88832
	
	앞의 숫자들과 뒤에서 바꿀 수 있는 '8'과 같은 최대값이 여러개 있을때 
	앞의 숫자들도 큰 숫자가 최대한 앞쪽으로 오게끔 바꿔주어야하는 까다로운 조건이 생긴다.

- 2번째 시도한 알고리즘
	시간초과가 날 것이라고 예상해 하지 않았던 DFS로 푸는 경우가 상당히 많아
	DFS를 이용해 문제를 풀어보니 대부분의 답은 제대로 출력되었다.
	이것도 마찬가지로 예외가 발생하였는데
	
		21 1 ⇒ 0
		정답 : 1 2
	
	DFS에서 swap을 시도하는 부분은 당연히 뒤에가 더 큰 경우만 고려하기 때문에 이미 앞에 큰 값이 들어가 있는 경우는 바뀌지 않고 result의 초기값인 0을 리턴한다.
	따라서 마지막에  result 값이 바뀌지 않고 0인 경우는 
	**교환 횟수가 홀수일때는 맨 뒤에 두자리수를 바꿔서, 짝수는 숫자 그대로** 리턴한다.