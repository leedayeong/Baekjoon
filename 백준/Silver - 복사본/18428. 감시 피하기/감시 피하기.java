import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, cnt;
	static char[][] map;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'T') {
					for (int d = 0; d < 4; d++) {
						int ny = i;
						int nx = j;
						while(true) {
							ny += dy[d];
							nx += dx[d];
							
							if(ny <0 || nx <0 || ny >= N || nx >= N)break;
							if(map[ny][nx] == 'O') break;
							if(map[ny][nx] == 'S') {
								if(cnt>=3) {
									System.out.println("NO");
									return;
								}
								if(!(i == ny-dy[d] && j == nx-dx[d])) {
									cnt++;
									map[ny-dy[d]][nx-dx[d]] = 'O';
									break;
								}else {
									System.out.println("NO");
									return;
								}
							}
						}
					}
				}
			}
		}
		System.out.println("YES");
		
	}

}