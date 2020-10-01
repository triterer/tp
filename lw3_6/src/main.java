import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
	
	public static void main(String[] args) {
		System.out.println("how many solutions " + discriminant(3,1,5));
		System.out.println("second place of zip " + zipplace("start zip two zip and"));
		System.out.println("check perfect " + checkperfect(323));
		System.out.println("FLIP " + flip("do a barrel roll"));
		System.out.println("hex code is^  " + isvalidhexcode("#847593"));
		int[] arr1 = {1,2,5};
		int[] arr2 = {3,3,3,1,4};
		System.out.println("same amount?  " + same(arr1, arr2));
		System.out.println("kapregar  " + kapregar(3));
		System.out.println("trailing zeros^ " + how_many_zero("00010100110011010000"));
		System.out.println("closePrime " + closePrime(22));
		System.out.println("phigore " + righttriag(4,1,2));
		
	}
	
	public static int discriminant(int a, int b, int c) {
		double d = b*b-4*a*c;
		if (d> 0) {
			return 2;
		}
		else if (d == 0) {
			return 1;
		}
		return 0;
		}
	
	public static int zipplace(String in) {
		int pos = in.indexOf("zip");
		if(pos!=-1) {
			pos = in.indexOf("zip", pos+1);
		}
		return pos;
	}
	
	public static boolean checkperfect(int in) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i<=in/2;i++) {
			if(in%i == 0) {
				list.add(i);
			}
		}
		int sum = 0;
		
		for(int i = 0; i<list.size();i++) {
			sum+=list.get(i);
		}
		if(in == sum) {
			return true;
		}
		return false;
		
	}
	
	public static String flip(String str) {
		if(str.length()<3) {
			return "incompatible";
		}
		else if(str.charAt(0)==str.charAt(str.length()-1)) {
			return "pair";
		}
		else {
			return str.substring(str.length()-1, str.length())
					.concat(str.substring(1, str.length()-1))
					.concat(str.substring(0,1));
		}
	}
	
	public static boolean isvalidhexcode(String hex) {
		Pattern regex = Pattern.compile("#[\\w]{6}");
		Matcher match = regex.matcher(hex);
		if(match.find()) {
			return true;
		}
		return false;
	}
	
	public static boolean same(int[] arr1, int[] arr2) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		for(int i = 0; i<arr1.length;i++) {
			set1.add(arr1[i]);
		}
		for(int i = 0; i<arr2.length;i++) {
			set2.add(arr2[i]);
		}
		if (set1.size()==set2.size()) {
			return true;
		}
		return false;
	}
	
	public static boolean kapregar(Integer tst) {
		Integer in = tst*tst;
		String st = in.toString();
		try {
		if(Integer.parseInt(st.substring(0, st.length()/2))+Integer.parseInt(st.substring(st.length()/2, st.length())) == tst) {
			return true;
		}}
		catch(Exception e) {}
		return false;
	}
	
	private static String buff(String in) {
		return in.concat("0");
	}
	
	public static String how_many_zero(String st) {
		int num = 0;
		String cont = "";
		while(st.contains(cont)){
			st = buff(st);
		}
		return st;
	}
	
	private static boolean isnotprime(int i) {
		for(int j = 0; j<i;j++) {
			if(i%j == 0) {
				return true;
			}
		}
		return false;
	}
	
	public static int closePrime(int i) {
		int incr = 1;
		while((incr<i)|(isnotprime(incr))){
			incr++;
		}
		return incr;
	}
	
	public static boolean righttriag(int a, int b, int c) {
		int[] list = {a, b, c};
		Arrays.sort(list);
		if(Math.pow(list[0],2)+Math.pow(list[1], 2) == Math.pow(list[2], 2))
			return true;
		return false;
	}
}