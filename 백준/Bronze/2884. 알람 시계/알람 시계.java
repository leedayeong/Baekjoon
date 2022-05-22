import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		if (m >= 45) m -= 45;
		else {
			if(h==0) {
				m += 15;
				h = 23;
			}else {
				m += 15;
				h -= 1;
			}
		}
		
		System.out.println(h + " " + m);
	}

}