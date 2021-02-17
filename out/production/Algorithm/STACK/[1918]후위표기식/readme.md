# [[1918]후위표기식](https://www.acmicpc.net/problem/1918)

## Stack을 이용한 풀이

<image src='https://lh4.googleusercontent.com/lb7luk7JxjTQshGsz892hNmTPNFy7ePB6oaxoWwIu01EjT3C9K8mpL9lhLOdRNRa_ViA9obgQwy9UR4Kl57iweelpg1X2PFVcNDy8O6HOvDWmAzFY4tSSrbRQPZ7IvvTtNI0kRpQ' width='70%'>

- 괄호와 연산 기호를 차례로 스택에 push/pop 해주면 되는 문제
- +, -, /, *의 우선순위를 dictionary를 통해 지정해주고 비교해준다.

### 주의할 점 <br>

- 맨 처음 시작할 때 괄호를 양 끝에 추가해주어야한다.