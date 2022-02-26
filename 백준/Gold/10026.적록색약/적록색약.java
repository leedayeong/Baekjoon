import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	
	static int N;
	static char[][] map;
	
	// 아닌 사람
	static int cnt1;
	static boolean[][] visit1;
	
	// 적록색약
	static int cnt2;
	static boolean[][] visit2;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		 
		 map = new char[N][N];
		 visit1 = new boolean[N][N];
		 visit2 = new boolean[N][N];
		 
		 for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		 }
		 
		 for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit1[i][j]) {
					cnt1 ++;
					bfs1(i, j);
				}
				if (!visit2[i][j]) {
					cnt2 ++;
					bfs2(i, j);
				}
			}
		}
		System.out.println(cnt1 + " " + cnt2);
		 
	}
	static void bfs1(int y, int x) {
		visit1[y][x] = true;
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit1[ny][nx]) continue;
			if(map[ny][nx] == map[y][x]) bfs1(ny, nx);
		}
	}
	static void bfs2(int y, int x) {
		visit2[y][x] = true;
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit2[ny][nx]) continue;
			if((map[ny][nx] == 'R' && map[y][x] == 'G') || (map[ny][nx] == 'G' && map[y][x] == 'R') || map[ny][nx] == map[y][x] ) bfs2(ny,nx);
		}
	}
}