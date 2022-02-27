import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, T, ans;
	static int [][] map;
	
	static int [] dy = {-1, 1, 0, 0};//상하좌우
	static int [] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		N = 100;
		map = new int[N][N];
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int i = y; i < y+10; i++) {
				for (int j = x; j < x+10; j++) {
					map[i][j] = 1;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					
					for (int d = 0; d < 4; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						
						if(ny<0 || nx<0 || ny>=N || nx>=N) {
							ans++;
							continue;
						}
						if(map[ny][nx]==1) continue;
						ans++;
					}
				}
			}
		}
		System.out.println(ans);
		
	}

}