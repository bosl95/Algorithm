## [[1912]연속합](https://www.acmicpc.net/problem/1912)

> 입력

	10
	10 -4 3 1 5 6 -35 12 21 -1

> 출력

	33

> ### Dynamic Programming을 이용한 풀이
**![](https://lh6.googleusercontent.com/FFt-D88hCXkf57cFd4bE_xobkIsAOuG0nZDIHN9DjDZ-LBzVrHfglF5tTWGBL4vmiaEhOm0v5yECE1UpjTMfCEK77AKNOaYp0j-aawkLdtI-SPugfjm5bgzX6_3pTyCATh5wvYbB)**
- 규칙이 **연속되는 숫자들의 합**이다.
	- DP[k] : k번째 숫자를 기준으로 나올수 있는 최대 값이라 할때 둘 중 하나의 값을 가진다.
		1) DP[k-1] + arr[k] : k-1번째 기준으로 나올수 있는 최대값 + k번째 숫자
		2) arr[k] : 연속된 숫자이기에 k-1번째 숫자를 사용하지 않는 다면 k번째 숫자만 사용해야한다.
	- 처음에는 DP[k-1]까지 추가해줬었는데 그렇게 되면 연속되지 않은 숫자, 즉 연속되지 않는 숫자들의 합이 만들어질 수 있다. 