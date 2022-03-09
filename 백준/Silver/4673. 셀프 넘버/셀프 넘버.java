public class Main {
	static int[] nums;
	public static void main(String[] args) throws Exception{
		nums = new int[10001];
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < 10001; i++) {
			int sum = 0;
			int num = i;
			sum += num;
			sum += (num / 1000);
			num %= 1000;
			sum += (num / 100);
			num %= 100;
			sum += (num / 10);
			sum += (num % 10);
			
			if(sum == i) continue;
			else if(sum <= 10000) nums[sum]++;
		}
		
		for (int i = 1; i < 10001; i++) {
			if(nums[i] == 0 )sb.append(i).append("\n");
		}
		System.out.println(sb);

	}

}