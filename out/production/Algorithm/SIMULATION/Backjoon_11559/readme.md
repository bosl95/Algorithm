# [[11559]Puyo Puyo](https://www.acmicpc.net/problem/11559)

## Simulation을 이용한 풀이

<image src='https://lh4.googleusercontent.com/DpD0fEQRFGC7Op4XoerT8RwDPa8zATsJFQE4TuxvxgZxchKTs2GtKXTx1yxWsP68xipfFU82FFsNWiNn92G7UY3J_TcH6urQO_K2iqX4V4MYb7nJmo1k44i8kP0u5Pn_BzEALa4H' width='70%'>
<image src='https://lh6.googleusercontent.com/9ScSlHL34FUIN0n-B6tg-lKLEiHP8mRppyWp4Ia2SPcxhx-MBT3Qc-yZJDfbmQHyiiMZvWQUKVGHE8DM921vl_NpBsJWO2eQg-3kJWMYuRtynKSWZ2RSmY6fOCln6GgXrnxMEM-F' width='70%'>

### 뿌요뿌요가 4개 이상인지 확인하는 Check()함수 ⇒ BFS를 이용하였고, 터지는 뿌요뿌요들의 위치 배열 (pop 배열)과 어떤 열에서 뿌요뿌요가 터졌는지 체크하는 배열(chk 배열)을 반환한다.<br>
### delete() 함수를 통해 뿌요뿌요를 지우고 뿌요뿌요가 터지는 세로줄을 체크하는 ch에 chk 배열을 추가해준다. (ch, chk는 set()) <br>
### move() 함수를 통해 뿌요뿌요를 밑으로 내린다. 이때 ch 배열을 통해 내려야할 뿌요뿌요들이 있는 열만 체크하여준다.<br>

<br>

---

### 어려운 반례는 없었으나 move() 함수에서 실수한 부분. 항상 인덱스, 배열은 조심해서 사용해야한다.

	for i in range(len(tmp)):  
	    field[11-i][c] = tmp.pop()		# tmp[i]로 쓰면 안된다.

