
> ### [[10807]개수 세기](https://www.acmicpc.net/problem/10807)

> #### 입력
	11
	1 4 1 2 4 2 4 2 3 4 4
	2
> #### 출력
	3
> #### code
	import sys; input=sys.stdin.readline  
	n = int(input())  
	arr = list(map(int, input().split()))  
	v = int(input())   # search number  
	count = 0  
	print(arr.count(v))  
	# for a in arr:  
	#     if a==v:  
	#         count += 1  
	# print(count)