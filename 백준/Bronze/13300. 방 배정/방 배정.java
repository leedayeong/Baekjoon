import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 성별 학년
// 여학생인 경우에 0, 남학생인 경우에 1로

public class Main {
	static int N, K, ans;
	static int[][] room;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		room = new int[6][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken()) -1 ;
			room[y][s] ++;
		}
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				if(room[i][j] > K) {
					if (room[i][j] % K ==0) {
						ans+= room[i][j] /K;
					}else {
						ans+= room[i][j] /K + 1;
					}
				}else if(room[i][j] > 0) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}