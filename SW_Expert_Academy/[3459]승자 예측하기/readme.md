## [[3459]승자 예측하기](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWFPoj1qANoDFAV0&categoryId=AWFPoj1qANoDFAV0&categoryType=CODE)

> 입력

	5  
	1  
	5  
	7  
	10  
	123456789123456789

> 출력
	
	#1 Bob  
	#2 Alice  
	#3 Bob  
	#4 Alice  
	#5 Bob

> ###  알고리즘
**![](https://lh3.googleusercontent.com/sBjRNe8OwOC3rkLDhCb0FBLZ5F9GGgxfIxC-Tz_r_BhexyTuqnXEQ3GTWugTt1HQAyAIFhl4MmJ27MiwIRHcbOKolUodXxf-Mp_J2pyALiae9dVFXwQSFb4UH3qOGOUi0awVcD63)**
규칙을 찾는 것에서 시간을 많이 소요했다.
DP를 이용하는 방법도 생각해 보았으나 결과가 제대로 출력되지않았다. 
승부를 결정하는 과정에서 각자 본인이 승리할 수 있는 방향을 예측해서 숫자를 선택하기 때문에 그 경우를 생각하면 그냥 순차적으로 탐색하는 방법은 조건이 부족하다.
1~30까지 승자를 나열하고 나니 규칙이 보였다.
1 / 4 / 4/ 16 / 16 / ... 순으로 승자가 번갈아가면서 나타난다는 것이다.  