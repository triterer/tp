import java.util.Arrays;
public class main {
	public static int current_squares = 0;
	public static void main(String[] args) {
		System.out.println("Repeat me!   "+repeat("me", 6));
		int[] MM = {31,-223,12,78,3,54};
		System.out.println("MAX - min:" + differenceMM(MM));
		int[] nonwhole = {1,2,3,4};
		System.out.println("is average whole: "+ isavgWhole(nonwhole));
		System.out.println("CUMULATIVE: "+  Arrays.toString(cumulative(nonwhole)));
		System.out.println("After dot:" + getafterdot("231,1234"));
		System.out.println("Fibonachi but strange7&" + Fibonacci(7));
		System.out.println("Post code is " + postindex("12412"));
		System.out.println("strange strings   ///" + Strangepair("asd dsa"));
		System.out.println("preffix? " + isPrefix("asdewc","asd"));
		System.out.println("suffix? " + isSuffix("dewdasd","afewd"));
		System.out.println("Stepping:  " + boxSeq(0) +" "+boxSeq(1)+" "+boxSeq(2));
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
	
	public static int Fibonacci(int num) {
		int first = 1;
		int second = 1;
		int sum = 0;
		for(int i = 1; i<num;i++) {
			sum = first+second;
			second = first;
			first = sum;
		}
		return first;
	}
	
	public static boolean postindex(String st) {
		try {
			int a = Integer.parseInt(st);
			if (st.length() == 5) {
				return true;
			}
			return false;
		}
		catch (Exception e){
			return false;
		}
	}
	
	public static boolean Strangepair(String st) {
		if (st.substring(0, 1).equals(st.substring(st.length()-1, st.length()))) {
			String[] splited = st.split(" ");
			if(splited[0].substring(splited[0].length()-1, splited[0].length()).equals(splited[1].substring(0, 1))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isPrefix(String st, String prefix) {
		if(st.substring(0, prefix.length()).equals(prefix)) {
			return true;
		}
		return false;
	}
	
	public static boolean isSuffix(String st, String suffix) {
		if(st.substring(st.length()-suffix.length(), st.length()).equals(suffix)) {
			return true;
		}
		return false;
	}
	
	public static int boxSeq(int step) {
		if (step == 0) {
			current_squares+=0;
		}
		else if(step == 1) {
			current_squares+=3;
		}
		else if(step == 2) {
			current_squares-=1;
		}
		return current_squares;
	}
	
}