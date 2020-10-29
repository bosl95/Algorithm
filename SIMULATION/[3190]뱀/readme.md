# [[3190]뱀](https://www.acmicpc.net/problem/3190)

## Simulation을 이용한 풀이

<image src='https://user-images.githubusercontent.com/34594339/97620228-9bed3d00-1a64-11eb-88a6-bb1b81dfbd2b.png' width='70%'>

<br>

- ### 참고사항

    1. ### 현재 "뱀의 머리가 위치하고 있는 부분만" 한 방향으로 이동하면 되기 때문에 Stack을 굳이 써줄 필요가 없었다.
    2. ### 이 문제는 Deque()를 쓰지 않고 del arr[0]를 쓰는 것이 더 빠르다. (그러나 많은 시간 차이는 나지 않고, 데이터가 더 많아진다고 가정하에 Deque()를 쓰는 것이 맞는 방향이라고 본다.)
    3. ### mx, my를 계속 둘 다 이동 시킬 필요가 없이 구현가능하다.

            if idx == 0: y += 1
            elif idx == 1: x += 1
            elif idx == 2: y -= 1
            elif idx == 3: x -= 1

        
