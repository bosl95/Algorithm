# [[17472]다리만들기2](https://www.acmicpc.net/problem/17472)

## MST를 이용한 풀이
<image src="https://lh5.googleusercontent.com/iKka-lHO3AvxPDET_zAOpO6Nxqnfd5m5Evi5si7lPl369F13oS8IsYkL-6ZEHv4O84IfhN8TA9ltt7jFXPHWB4bRkeGS50-xpl0Tdt0C1xO3xaRIgNC1x574grJ0s0PT30NlgEZ2" width="70%">
<image src="https://lh6.googleusercontent.com/OyPzonK_lSTlZkLUIqhGlAxcEfkx5T0L2xt-ggRhQCZRwdJCF-jrOjIZoVr3jsABUDtra1JDNKsKUa_BVlLHEIpjZHEowOBMGPugMHjLieEOVHjSrTjTjIRa3m4zLNK9l5rAOu4D" width="70%">
<br>

### 1. 섬을 먼저 찾는다.<br>
### 2. 각 섬끼리의 거리를 구한다. <br>
### 3. MST를 이용하여 최소 거리를 구한다.<br>
### 구조는 어렵지 않으나 bfs,  bfs2 구현하는 과정에서 조건들이 헷갈릴 수 있으니 주의하자. 