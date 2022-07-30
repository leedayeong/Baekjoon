import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
	static int N;
	static int K;
	
	static HashSet<Integer>set = new HashSet<Integer>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		
		List<Integer> arr = new ArrayList<>();
		
		for (int n = 0; n < N; n++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		List<Integer> result = new ArrayList<>();
		
		reculsion(arr, result, N, K);
		
		System.out.println(set.size());
		

	}
	
	public static void reculsion(List<Integer>arr, List<Integer>result, int n, int k) {
		
		if (k==0) {
			String str = "";
			for (int i = 0; i < K; i++) {
				str += String.valueOf(result.get(i));
			}
			set.add(Integer.parseInt(str));
			return;
		}
		
		for (int i = 0; i < n; i++) {
			result.add(arr.remove(i));
			reculsion(arr, result, n-1, k-1);
			arr.add(i, result.remove(result.size()-1));
		}
	}
}
