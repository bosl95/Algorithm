# [[2467]용액](https://www.acmicpc.net/problem/2467)

## Binary Search를 이용하지 않은 풀이
### [[2003]수들의 합2](https://github.com/bosl95/Algorithm/tree/master/BINARY%20SEARCH/%5B2003%5D%EC%88%98%EB%93%A4%EC%9D%98%ED%95%A92)의 풀이를 참고하여 유사한 방식으로 투 포인터 알고리즘을 이용하였다.<br>

<image src="https://lh6.googleusercontent.com/azJ6JvDYjj7D0d0raalGbNZXQNcYATRPhHXceDO43f3_EDGQYYqP4HVsjN81Vr3jmvsA5TjSfG0xmXOx-pKnRKuBBl8GcqC7o0YgOGDAAhV7dyf9y43CIBAQxONU9UYoyN9bbgJ2" width="70%">

### 처음 손으로 쓴 알고리즘은 위와 같고, <br>
### 수정해준 부분은 ans 배열에 Arr[low], Arr[high]를 가지고 있다가 만약 low>=high가 되는 경우 리턴해주거나<br>
### Arr[low]+Arr[high]==0이 되는 경우 바로 리턴해주면 되기 때문에 return Arr[low] Arr[high]를 리턴해준다.<br>
### 그리고 low, high가 변경되는 조건문 바로 밑에 low>=high가 되는 경우를 체크해주는 방식으로 작성했다.