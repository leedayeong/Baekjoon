import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static boolean[][] map = new boolean[100][100];
	
	static int [] dy = {-1, 1, 0, 0}; //상하 좌우
	static int [] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			
			for (int j = sy; j < sy + 10; j++) {
				for (int k = sx; k < sx + 10; k++) {
					map[j][k] = true;
				}
			}
		}

		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j]){
						for (int d = 0; d < 4; d++) {
							int ny = i + dy[d];
							int nx = j + dx[d];
							if (ny < 0 || nx <0 || ny >=100 || nx >= 100 || map[ny][nx] == false) ans++; // 여기서는 오히려 범위의 끝에 있을때 둘레를 구해줘야함! 

					}
				}
			}
		}
		System.out.println(ans);
	}
}