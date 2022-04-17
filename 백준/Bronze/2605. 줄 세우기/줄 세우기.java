import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static LinkedList<Integer> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		
		list = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			int num  = Integer.parseInt(st.nextToken());
			if(num == 0) {
				list.add(i);
			}else {
				list.add(i-1-num, i);
			}
		}
		
		for (int num : list) {
			sb.append(num + " ");
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}