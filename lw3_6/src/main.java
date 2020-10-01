import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
	
	public static void main(String[] args) {
		System.out.println("how many solutions " + discriminant(3,1,5));
		System.out.println("second place of zip " + zipplace("start zip two zip and"));
		System.out.println("check perfect " + checkperfect(323));
		System.out.println("FLIP " + flip("do a barrel roll"));
		System.out.println("hex code is^  " + isvalidhexcode("#847593"));
		
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
					.concat(str.substring(1, str.length()-2))
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
	
}