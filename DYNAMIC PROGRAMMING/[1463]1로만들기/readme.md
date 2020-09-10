
# [[1463]1로만들기](https://www.acmicpc.net/problem/1463)  
  
## Dynamic Programming을 이용한 풀이  
  
<image src="https://lh5.googleusercontent.com/r_bu-peWl_WAAFTmM9NrqI8cRi3SCufWnXyh88mgAD-r5MdPVvnBIabG5DNC7evxyCej2wJGm3-T3UnNJfHPDMVKuEY3bzcqqO0UQ3zvlBzNWlRmCp655VQyZUigBSl-Ufh93S3J" width="80%">
  
처음에 DP[1], DP[2], DP[2]를 모두 1로 초기화해주었는데 DP[1]를 0으로 설정해줘야했다.  <br>
  

### 다른 풀이

	l = [int(input())]; n=0
	while 1 not in l:
	    t=set(); n+=1
	    for i in l:
	        if i%3==0: t.add(i//3)
	        if i%2==0: t.add(i//2)
	        t.add(i-1)
	    l=t
	print(n)

⇒ set() + 반복문을 통해서 구해주는 방법. 메모리나 시간 측면에서 DP 방식으로 푼 내 코드보다 훨씬 빨랐다.

![image](https://user-images.githubusercontent.com/34594339/89611163-71517500-d8b7-11ea-8931-f6423a36c4c7.png)
![image](https://user-images.githubusercontent.com/34594339/89611186-80d0be00-d8b7-11ea-97d1-c62653ac0be0.png)
