# [[14891]톱니바퀴](https://www.acmicpc.net/problem/14891)

## Simulation을 이용한 풀이

<image src='https://lh5.googleusercontent.com/-s_5AU_AsMimpUa5ygMSPmuXFlyru9kDiX1WmNGobg_JMmiOELM3LxGV_9tKj9nIGGrfIO_68aeZ9N9O37RxOl2nae5CfODNoomFs-YBXHsmvn7GJw_teHuIxpLt4g-zhQqDsNQ3' width='70%'>

### 그냥 if문을 통해서 i번 톱니바퀴마다 체크해주었는데 이 방법은 톱니바퀴가 4개라서 가능했고, 더 많은 톱니바퀴라면 좋은 코드는 아니라고 판단했다.<br>

<br>

### 다른 사람의 풀이

	def solution(gear, turn):

	    while turn:
	        num, dir = turn.popleft()
	        num -= 1    # num은 인덱스로 -1해주기

	        # 백업
	        tmp_right = gear[num][2]
	        tmp_left= gear[num][6]
	        tmp_dir = dir
	        gear[num].rotate(dir)

	        # 톱니 왼쪽
	        for i in range(num-1, -1, -1):
	            if gear[i][2] != tmp_left:
	                tmp_left = gear[i][6]
	                gear[i].rotate(dir*-1)
	                dir *= -1
	            else:
	                break

	        # 톱니 오른쪽
	        dir = tmp_dir
	        for i in range(num+1, 4):
	            if gear[i][6]!=tmp_right:
	                tmp_right = gear[i][2]
	                gear[i].rotate(dir*-1)
	                dir *= -1
	            else:
	                break

	    ans = 0
	    for i in range(4):
	        if gear[i][0]==1:
	            ans += (2**i)
	    return ans

### deque()를 사용할 때 rotate 함수가 있다는 것을 참고하자.<br>
- `deque.rotate(n)` : n이 양수면 오른쪽으로, n이 왼쪽으로 회전한다.