
# [[1931]회의실 배정](https://www.acmicpc.net/problem/1931) 
  
### Greedy Algorithm을 이용한 풀이  
- 하나의 회의실에 최대 회의 개수를 구하는 문제.   
- 최대한 많은 회의를 배정하려면 회의가 **빨리 끝나는 회의를 먼저 배치**해주는 것이 좋다.  
- 회의가 빨리 끝나는 시간순으로 배정해준 이후에, 한 **회의가 끝남과 동시에 다음 회의가 최대한 빨리 시작될 수 있도록** 시작 시간을 기준으로 한번더 정렬해준다.