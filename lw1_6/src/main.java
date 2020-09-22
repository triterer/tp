public class main {

	public static void main(String[] args) {
		System.out.println("Hellow world!");
		System.out.println("remain of 10/3: " + remainder(10,3));
		System.out.println("remain of 3/5:" + remainder(3,5));
		System.out.println("area of triangle: " + triArea(3,8));
		System.out.println("number of legs: "+ animals(3,4,1));
		System.out.println("are U lucky? "+ profitableGamble(0.4, 60, 20));
		System.out.println("What to do with 13 and 4 to get 17?" + operation(17, 13, 4));
		System.out.println("ASCII code of M: " + ctoa('M'));
		System.out.println("Summ of nums up to 11: "+addUpto(11));
		System.out.println("third side: "+ nextEdge(11,3));
		int[] for_cubes = {12,11,4};
		System.out.println("Cubes of list: " + sumofCubes(for_cubes));
		System.out.println("abc is : " + abcmath(32,3,9));
		

	}
	
	public static int remainder(int num_up, int num_down) {
		return num_up%num_down;
	}
	
	public static double triArea(double num1, double num2) {
		return 0.5*num1*num2;
	}
	
	public static int animals(int chickens, int cows, int pigs) {
		return chickens*0+cows*4+pigs*4;
	}
	
	public static boolean profitableGamble(double prob, double prize, double pay) {
		if (prob*prize>pay) {
			return true;
		}
		return false;
	}
	
	public static String operation(int N, int a, int b) {
		if (a+b==N) {
			return "added";
		}
		else if(a-b==N) {
			return "substracted";
		}
		else if(a*b==N) {
			return "multiplied";
		}
		else if(a/b==N) {
			return "splited";
		}
		return "none";
	}
	
	public static int ctoa(char inp) {
		return (int)inp;
	}
	
	public static int addUpto(int cap) {
		int sum = 0;
		for(int i = 1; i<=cap; i++) {
			sum += i;
		}
		return sum;
	}
	
	public static int nextEdge(int side1, int side2) {
		//since max length of input is sum we need to substruct 1 for enable angle and because all sides are not decimals
		return side1+side2-1;
	}
	
	public static int sumofCubes(int[] listofnums) {
		int cubes=0;
		for(int i = 0; i< listofnums.length;i++) {
			cubes += listofnums[i]^3;
		}
		return cubes;
	}
	
	public static boolean abcmath(int a, int b, int c) {
		if (a*b%c==0) {
			return true;
		}
		return false;
	}
}
