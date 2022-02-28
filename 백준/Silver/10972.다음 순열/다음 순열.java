import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int [] nums;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean chk = np();
		if(chk) {
			for (int i = 0; i < N; i++) {
				System.out.print(nums[i] + " ");
			}
		}
		else {
			System.out.println(-1);
		}
		
		
	}
	static boolean np() {
		int i = N-1;
		while(i>0 && nums[i-1] > nums[i]) i--;
		
		if(i == 0) return false;
		
		int j = N-1;
		while(nums[i-1] >= nums[j]) j--;
		
		swap(i-1, j);
		
		int k = N-1;
		while(i<k) swap(i++,k--);
		return true;
		
	}
	static void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}