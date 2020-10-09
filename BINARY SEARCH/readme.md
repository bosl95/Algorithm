# Binary Search

## :pushpin: Concept
### 정렬되어 있는 배열에서 특정 데이터를 찾기 위하여 모든 데이터를 순차적으로 확인하는 대신 탐색 범위를 절반으로 줄여가며 찾는 탐색 방법.

	def BinarySearch(target, n):
		st, en = 0, n-1
		while st<=en:
		  mid = (st+en)//2
		  if a[mid] < target:
		    st = mid + 1
		   elif a[mid] > target:
		    en = mid - 1
		   else
		     return mid
		 
		 return -1

## :pushpin: Two Pointer
### Two Pointer는 양 끝단에서 한칸씩 이동하면서 알맞는 값을 찾는 방식을 사용하며, left와 right가 중간 어디서 만날 때까지 계속 탐색을 진행한다.<br>
### 이진 탐색은 *Log(N)* 을 보장하는 반면, two pointer는 최악의 경우 *N*의 시간복잡도를 가집니다.