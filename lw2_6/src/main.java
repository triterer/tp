import java.util.Arrays;
public class main {

	public static void main(String[] args) {
		System.out.println("Repeat me!   "+repeat("me", 6));
		int[] MM = {31,-223,12,78,3,54};
		System.out.println("MAX - min:" + differenceMM(MM));
		int[] nonwhole = {1,2,3,4};
		System.out.println("is average whole: "+ isavgWhole(nonwhole));
		System.out.println("CUMULATIVE: "+  Arrays.toString(cumulative(nonwhole)));
		System.out.println("After dot:" + getafterdot("231,1234"));
	}
	
	
	public static String repeat(String inp, int times) {
		String out="";
		for (int i=0; i<inp.length();i++) {
			for (int j=0; j < times; j++) {
				out = out +inp.substring(i,i+1);
			}
		}
		return out;
	}
	
	public static int differenceMM(int[] nums) {
		Arrays.sort(nums);
		return (nums[nums.length-1]-nums[0]);
		
	}
	
	public static boolean isavgWhole(int[] nums) {
		double sum=0;
		for (int i =0; i<nums.length;i++) {
			sum+=nums[i];
		}
		if (sum/nums.length%1==0) {
			return true;
		}
		return false;
	}
	
	public static int[] cumulative(int[] nums) {
		int sum = 0;
		for (int i = 0; i<nums.length; i++) {
			sum+=nums[i];
			nums[i]=sum;
		}
		return nums;
	}
	
	public static int getafterdot(String st){
		String[] heh = st.split(",");
		return heh[1].length();
	}
	
}