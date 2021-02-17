# [[15684]사다리 조작](https://www.acmicpc.net/problem/15684)

## Simulation을 이용한 풀이

- 로직을 생각해보았으나, 어떻게 구현해야할 지 한참을 고민해봐도 떠오르지 않아 [[한 블로그]](https://rebas.kr/790)를 참조하여 풀었다.

<br>

### 문제 해결 방식 <br>
- 사다리 개수를 하나씩 추가해주면서 가장 최소의 개수를 구해준다.

1.  사다리 추가하기

		for i in range(x, h):
	        k = y if i == x else 0			
	        for j in range(k, n-1):			# 가로줄이 가능한 세로줄을 탐색하기
	            if a[i][j]:							# 현재 탐색하고 있는 세로줄에 이미 가로줄이 있다면 
	                j += 1							# 다음 세로줄로 이동한다.
	            else:								# 현재 탐색하고 있는 세로줄에 이미 가로줄이 없다면
	                a[i][j] = 1						# 현재 세로줄에 가로줄을 넣어주고
	                solve(cnt+1, i, j+2)		# j와 j+1의 세로줄에 가로줄이 생겼으므로 j+2의 세로줄로 이동하여 탐색한다. (재귀)
	                a[i][j] = 0						# 탐색이 끝나면 다시 가로줄을 없애준다.

2. 재귀 탐색 중 최소 사다리 개수인 ans보다 큰 값을 가지는 경우는 제외해준다.
	
		if ans <= cnt:
	        return
 
3. 현재 사다리가 각자의 자리에 들어가있는지 검사해주고, 참이라면 ans에 업데이트 해준다.(최소 비교)
	
	   if ladder():
	        ans = min(ans, cnt)
	        return

4. cnt가 3이라면 이후 가로줄을 추가해도 최소값을 넘어가므로 더이상 탐색하지 않는다.

	   if cnt == 3:
          return
  
 5. 현재 사다리가 어떤 곳으로 가는지 확인하는 ladder() 함수]

		def ladder():
		    for i in range(n):		# 세로줄을 탐색
		        k = i						# 현재 세로줄의 번호를 저장
		        for j in range(h):	
		            if a[j][k]:			#	만약 가로줄이 있다면  
		                k += 1			# 오른쪽으로 이동
		            elif k > 0 and a[j][k-1]:		# 만약 가로줄이 현재 위치-1 에 있다면
		                k -= 1								# 왼쪽으로 이동
		        if i != k:				# 모든 탐색이 끝나고, 현재 위치가 처음 저장해놓은 세로줄 번호가 아니면
		            return False	
		    return True

<br>

### 채점 결과<br>

<image src='https://user-images.githubusercontent.com/34594339/98462409-9a0b4280-21f7-11eb-8327-860905a88939.png' width='70%'>

- PyPy3로 풀리지만 python으로는 시간초과가 발생한다.

<br>

### 내가 만들었던 로직 <br>
  
<image src='https://lh5.googleusercontent.com/OUc2bEIyHbDJRC5EjD9NHPEfCUiPRoblBtYhpfBexyVosW8UTGBD6P7uDb-sylg7bYrOc-F-rVMAWTrqAzPByplpNJ8EFFolGokDzW4WUiVm3XfiYJieXUEgxSdnThQhEXO4BsuF' width='70%'>
	
- 어떻게 재귀함수로 만들어야할 지 고민하다가 결국 실패했다.
- 내 로직을 이용해서 구현을 시도 해봐야겠다.