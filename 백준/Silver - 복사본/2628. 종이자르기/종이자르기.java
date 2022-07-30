import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, max;
	static List<Integer> Xcut;
	static List<Integer> Ycut;
	static List<Integer> list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(br.readLine());
		
		Xcut = new ArrayList<Integer>();
		Ycut = new ArrayList<Integer>();
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken()) == 0) {
				Ycut.add(Integer.parseInt(st.nextToken()));
			}else {
				Xcut.add(Integer.parseInt(st.nextToken()));
			}
		}
	
		Ycut.add(N);
		Xcut.add(M);
		
		Collections.sort(Ycut);
		Collections.sort(Xcut);
		
		int sx = 0;
		int sy = 0;
		
		int ysize = Ycut.size();
		int xsize = Xcut.size();
		
		for (int i = 0; i < ysize; i++) {
			int y = Ycut.get(i) - sy;
			sx = 0;
			for (int j = 0; j < xsize; j++) {
				int x = Xcut.get(j) - sx;
//				System.out.println(sy + " " + sx + " 넓이 = " + y*x);
				max = Math.max(max, y*x);
				sx = Xcut.get(j);
			}
			sy = Ycut.get(i);
		}
		System.out.println(max);
	}
}