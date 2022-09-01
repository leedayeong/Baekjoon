import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N = 20;
	static int[][] map;
	
	static int[] dy = {-1, 0, 1, 1}; // 우상, 우, 우하, 하
	static int[] dx = {1, 1, 1, 0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		map = new int[N][N];
		
		for (int i = 1; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if(map[i][j] != 0) {
					int num = map[i][j];
					boolean chk = false;
					for (int d = 0; d < 4; d++) {
						int y = i;
						int x = j;
						for (int k = 0; k <= 5; k++) {
							if(k==0) {
								int ny = y - dy[d];
								int nx = x - dx[d];
								
								if(ny < 1 || nx < 1 || ny >=N || nx >=N) continue;
								if(map[ny][nx] == num) break;
							}
							else if(k==5) {
								int ny = y + dy[d]*k;
								int nx = x + dx[d]*k;
								if(ny < 1 || nx < 1 || ny >=N || nx >=N) {
									chk = true;
									break;
								}
								if(map[ny][nx] == num) break;
								else chk = true;
							}
							else {
								int ny = y + dy[d]*k;
								int nx = x + dx[d]*k;
								if(ny < 1 || nx < 1 || ny >=N || nx >=N) break;
								if(map[ny][nx] != num) break;
							}
						}
						if(chk) {
							System.out.println(num);
							System.out.println(i + " " + j);
							return;
						}
					}
				}
			}
		}
		System.out.print(0);
	}
}