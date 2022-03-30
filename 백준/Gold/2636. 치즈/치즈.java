import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[] dy = {-1, 1, 0, 0}; //상하좌우
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
	
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) ;
			}
		}
		
		
		
		
		int time = 0;
		int beforeCnt = 0;
		while(true) {
			int cheeseCnt = 0; // 치즈 수
			int airCnt = 0; // 공기랑 접촉한 치즈 수 
			// 노출된 공기만 표시 => 3으로
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 0 ) {
						boolean chk = false;
						for (int d = 0; d < 4; d++) {
							int ny = i + dy[d];
							int nx = j + dx[d];
							if(ny >= N || nx >= M || ny < 0 || nx<0) {
								chk = true;
								break;
							}
							if(map[ny][nx]==3) {
								chk = true;
								break;
							}
						}
						if(chk) bfs(i, j);
					}
				}
			}
	
			// 치즈 갯수, 공기랑 접촉한 치즈 수 세기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 3) {
						for (int d = 0; d < 4; d++) {
							int ny = i + dy[d];
							int nx = j + dx[d];
							if(ny >= N || nx >= M || ny <0 || nx<0) continue;
							if(map[ny][nx] == 1) {
								airCnt ++;
								map[ny][nx] = 2;
							}
						}
					}else if(map[i][j] == 1) cheeseCnt++;
				}
			}
			
//			for (int i = 0; i < N; i++) {
//				System.out.println();
//				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j]+ " ");
//				}
//			}

			if(cheeseCnt + airCnt== 0) { //총 치즈 수
				System.out.println(time);
				System.out.println(beforeCnt);
				break;
			}
			
//			System.out.println("==================");
//			System.out.println("time: "+time);
//			System.out.println("cheese: " + cheeseCnt);
//			System.out.println("air : " + airCnt);
//			System.out.println("before" + cheeseCnt);

			
			int tmpCnt = 0;
			// 공기랑 접촉한 치즈 없애기
			outer : for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 2) {
						map[i][j] = 3;
						if(++tmpCnt == airCnt) break outer;	
					}
				}
			}
			
			time++;
			beforeCnt = airCnt;
		}
	}
	
	public static void bfs(int y, int x) {
		map[y][x] = 3;
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(ny >= N || nx >= M || ny < 0 || nx< 0) continue;
			if(map[ny][nx] == 3 || map[ny][nx] == 1) continue;
			bfs(ny, nx);
		}
	}
}