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