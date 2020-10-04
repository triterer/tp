import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
public class main {
	
	public static void main(String[] args) {
		bessie(10,7,"hello my name is Bessie and this is my essay");
		String[] st = spliter("()()((()))");
		System.out.println("bracets! "+ Arrays.toString(st));
		System.out.println("snake "+ toSnake("helloEdabit"));
		System.out.println("camel "+ toCamel("is_modal_open"));
		System.out.println("do you know what time it is $"+overtime(9, 17, 30, 1.5));
		System.out.println(" BIM " + BMI("55 kilos", "1.65 meters"));
		System.out.println("Cycle " + bugger(39));
		System.out.println("star " + toStar("abbccc"));
		System.out.println("Rhymes " + Rhymes("Sam I am!", "Green eggs and ham."));
		System.out.println("trouble "+ trouble(451999277, 411772899));
		System.out.println("books; "+ countUniq("AZYWABBCATTTA","A"));
	}
	
	public static void bessie(int word_num, int str_len, String unsliced) {
		int current_out = 0;
		int word_len = 0;
		String word_sum = "";
		int  i;
		for (i = 0;i<unsliced.length();i++) {
			if(unsliced.codePointAt(i)!=32) {
				word_len+=1;
			}
			else {
				if(current_out+word_len>str_len) {
					System.out.println(word_sum.substring(0, word_sum.length()-1));
					word_sum=unsliced.substring(i-word_len,i).concat(" ");
					current_out = word_len;
				}
				else {
					word_sum+=(unsliced.substring(i-word_len,i)).concat(" ");
					current_out+=word_len;
					
				}
				word_len=0;
			}
			
		}
		if(current_out+word_len>str_len) {
			//word_sum=unsliced.substring(i-word_len,i);
			System.out.println(word_sum.substring(0, word_sum.length()-1));
			System.out.println(unsliced.substring(i-word_len,i));
		}
		else {
			word_sum+=" ".concat(unsliced.substring(i-word_len,i));
			System.out.println(word_sum);
		}
	}
	
	public static String[] spliter(String bracets) {
		int stack = 0;
		int lastend = 0;
		ArrayList<String> retur = new ArrayList<>();
		int position = 0;
		String stackb="";
		for(int i = 0;i<bracets.length();i++) {
			if (bracets.codePointAt(i)==40) 
				stack+=1;	
			else
				stack-=1;
			if (stack == 0) {
				retur.add(bracets.substring(lastend, i+1));
				position+=1;
				lastend = i+1;
			}
			
		}
		String[] sumArray = retur.toArray(new String[0]); 
		return sumArray;
	}
	
	public static String toSnake(String st) {
		String start, middle,end;
		
		for (int i = 0;i<st.length();i++) {
			if(st.codePointAt(i)<90 & st.codePointAt(i)>65) {
				start = st.substring(0, i);
				middle = "_".concat(st.substring(i, i+1).toLowerCase());
				end = st.substring(i+1, st.length());
				st = start.concat(middle).concat(end);
			}
		}
		return st;
	}
	public static String toCamel(String st) {
		String start, middle,end;
		
		for (int i = 0;i<st.length();i++) {
			if(st.codePointAt(i)==95) {
				start = st.substring(0, i);
				middle = st.substring(i+1, i+2).toUpperCase();
				end = st.substring(i+2, st.length());
				st = start.concat(middle).concat(end);
			}
		}
		return st;
	}
	
	public static double overtime(double start, double end, double perhour, double multiplier) {
		double normal = 0;
		double overtime = 0;
		if (start<17)
			normal = (17-start)*perhour;
		if (end>=17)
			overtime = ((end-17)*perhour*multiplier);
		return (normal+overtime);
	}
	
	public static String BMI(String weight, String height) {
		double weight_num = 0;
		double height_num = 0;
		String num="";
		for (int i = 0;i<weight.length();i++) {
			if(weight.codePointAt(i) == 32) {
				weight_num = Double.parseDouble(num);
				num = "";
			}
			num = num.concat(weight.substring(i,i+1));
			
		}
		num = "";
		for (int i = 0;i<height.length();i++) {
			if(height.codePointAt(i) == 32) {
				height_num = Double.parseDouble(num);
				num = "";
			}
			num = num.concat(height.substring(i,i+1));
		}
		if(weight.contains("pounds")) {
			weight_num = weight_num*0.45;
		}
		if(height.contains("inches"))
			height_num = height_num*0.025;
		
		double index = weight_num/(height_num*height_num)/0.1;
		if (index<=18.5)
			return String.valueOf(index).concat(" Underweight");
		if (index>18.5 & index<=24.9)
			return String.valueOf(index).concat(" normal");
		return String.valueOf(index).concat(" Overweight");
	}
	
	public static int bugger(int num) {
		int stack = 0;
		while(true) {
			if(num<10 & stack == 0)
				break;
			else if(num>0) {
				stack = stack*num%10;
				num = num/10;
			}
			else {
				num = stack;
				stack = 0;
			}
		}
		return num;
	}
	
	public static String toStar(String st) {
		String res = "";
		int len = 0;
		int i = 0;
		for(i = 0;i<st.length();i++) {
			try {
			if(st.codePointAt(i) == st.codePointAt(i+1))
				len+=1;
			else {
				if (len == 0)
					res = res.concat(st.substring(i,i+1));
				else {
					res = res.concat(st.substring(i,i+1)).concat("*").concat(String.valueOf(len+1));
					len = 0;
				}
			}
			}catch (Exception e){
				if (len>0)
					res = res.concat(st.substring(i,i+1)).concat("*").concat(String.valueOf(len+1));
				else
					res = res.concat(st.substring(st.length()-1));
			}
		}
		return res;
	}
	
	public static boolean isVow(char c) {
		  return "AEIOUaeiou".indexOf(c) != -1;
	}
	
	public static boolean Rhymes(String first, String second) {
		String[] first_words = first.split(" ");
		String[] second_words = second.split(" ");
		ArrayList<Object> vowels = new ArrayList<>();
		String last_word_1 = first_words[first_words.length-1];
		String last_word_2 = second_words[second_words.length-1];
		for(int i = 0; i<last_word_1.length();i++) {
			if (isVow(last_word_1.charAt(i)))
				vowels.add(last_word_1.charAt(i));
		}
		
		for(int i = 0; i<last_word_1.length();i++) {
			if (isVow(last_word_1.charAt(i)))
				if(vowels.contains(last_word_1.charAt(i)))	
					vowels.remove(vowels.indexOf(last_word_1.charAt(i)));
			
				else
					
					return false;
		}
		
		if (vowels.isEmpty())
			return true;
		return false;
		
	}
	
	public static boolean trouble(long num2, long num1) {
		String st1 = String.valueOf(num1);
		String st2 = String.valueOf(num2);
		ArrayList<Object> for_test = new ArrayList<>();
		int row = 0;
		for(int i = 0;i<st1.length()-1;i++) {
			if (st1.charAt(i)==st1.charAt(i+1))
				row+=1;
			else if(i==st1.length()-2){
				if(row>2)
					for_test.add(st1.charAt(i));
				row = 0;
			}
			
			if(row>2) {
				for_test.add(st1.charAt(i));
				row = 0;
			}
		}
		String num = "";
		
		for(int i = 0; i<for_test.size();i++) {
			num = String.valueOf(for_test.get(i));
			if(st2.contains(num.concat(num)))
				return true;
		}
		return false;
	}
	
	public static int countUniq(String books, String key) {
		//books = books.substring( books.indexOf(key),books.length()-1);
		//try {
		//books = books.substring(0, books.lastIndexOf(key));
		//}
		//catch (Exception e) {
			
		//}
		//String[] splited_books = books.split(key);
		boolean seq = false;
		String a = "";
		HashSet<String> set = new HashSet<String>();
		for(int i = 0;i<books.length();i++) {
			a = books.substring(i, i+1);
			
			
			if(a.codePointAt(0) == key.codePointAt(0)&&seq ) 
				seq = false;
			else if(a.codePointAt(0) == key.codePointAt(0) && !seq)
				seq = true;
			else if(seq)
				set.add(books.substring(i, i+1));
			
		}
		
		set.remove(key);
		
		return set.size();
	}
}