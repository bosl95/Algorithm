# [[2003]수들의 합](https://www.acmicpc.net/problem/2003)

## Two Pointer를 이용한 풀이

<image src="https://lh6.googleusercontent.com/8xe3ew9SDvr2BFd72MKZSSKRudGVDuD8G3yCu_9IDWIisgPtGGs4sqpN_DtorxqehZd4QdgavqF_ftgAxaCdHz7kQXYLCm43xrhdFn48KeMjxcnPluWOuokfbd0Aib8h6vXtUshr" width="70%">

### 투 포인터 : low, high을 두고 범위를 조정하여 수들의 합을 구해 카운트 해주었다.<br>
### 주의할 점은 high인데,  A[high]는 수들의 합인 s에 합쳐지지 않은 상태이다. 그렇기 때문에 high=n인 경우가 생기게 되는데 이때 s >=M 이라면 low +1 을 계속 진행할 수있다. <br>
### 그러나 s <M이라면 high를 조정해야 하므로 그때는 조건문을 통해 while문을 빠져나와야 한다. <br>
### 따라서 while 문의 조건문에 high<n을 쓰는 것이 아닌 if s>=m 조건문 뒤에 따로 elif 문을 생성하여 체크해주어야한다.

