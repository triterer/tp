import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class main {
	
	public static void main(String[] args) {
		System.out.println("bell: "+ Formula(4));
		System.out.println("word oink: "+ wordOink("apple"));
		System.out.println("sentence oink: "+ manyWords("Do you think it is going to rain today"));
		System.out.println("color: "+ color("rgb(0,0,0)"));
		String[] del = {"b"};
		System.out.println("url clan: "+urlparse("https://edabit.com?a=1&b=2&a=2", del));
		System.out.println("tags: "+ Arrays.toString(get_tags("Hey Parents, Surprise, Fruit Juice Is Not Fruit")));
		System.out.println("ulan ude: "+ ulan(4));
		System.out.println("non rep: "+ nonrepeat("abcabcbb"));
		System.out.println("ROM:  "+ toRom(15));
		System.out.println("formula:  "+ Formula("6 * 4 =24"));
		System.out.println("palindrome:  "+ isPalindromeDesc(11211230));
	}
	
	public static int Formula(int n) {
		int sum=0;
		for(int m = 1; m<=n; m++) {
			sum+=S(n-1, m-1)+m*S(n-1, m);
		}
		return sum;
	}
	
	public static int S(int n, int m) {
		if((n==0)&(m==0))
			return 1;
		else if((n>0)&(m==0))
			return 0;
		else if(n<m)
			return 0;
		return S(n-1, m-1)+m*S(n-1, m);
	}
	
	public static String isVowel(char c) {
		switch(c) {
		 case'a':return (""+c);
		 case'u':return(""+c);
		 case'o':return(""+c);
		 case'i':return(""+c);
		 case'e':return(""+c);
		 }
		return "no";
	}
	
	public static String wordOink(String word) {
		char first_letter = word.charAt(0);
		char ch_for_test;
		if(word.indexOf(isVowel(first_letter))!=-1) 
			return word.concat("yay");
		for(int i = 0; i<word.length();i++) {
			ch_for_test = word.charAt(i);
			if(isVowel(ch_for_test)!="no") {
				String first_part = word.substring(0, word.indexOf(ch_for_test));
				String ret = word.substring(word.indexOf(ch_for_test), word.length()).concat(first_part).concat("ay");
				return ret;
			}
				
		}
		return "bug";
		
		
	}
	
	public static String manyWords(String sentence) {
		String[] words = sentence.split(" ");
		String res="";
		for(String word : words) {
			res = res.concat(wordOink(word)).concat(" ");
		}
		return res;
	}
	
	public static boolean color(String color) {
		color = color.substring(0, color.length()-1);
		String[] splited = color.split("\\(");
		String[] colors = splited[1].split(",");
		
		if ((splited[0].equals("rgb"))&(colors.length==3)) {
			System.out.println(Arrays.toString(splited));
			System.out.println(Arrays.toString(colors));
			if((check_color(colors[0]))&(check_color(colors[1]))&(check_color(colors[2])))
					return true;
		}
		if ((splited[0].equals("rgb"))&(colors.length==4)) {
			if(((check_color(colors[0]))&(check_color(colors[1]))&(check_color(colors[2]))&(check_alpha(colors[3]))))
					return true;
		}
			
		return false;
	}
	
	private static boolean check_color(String st) {
		int num = Integer.parseInt(st);
		if((num<=255)&(num>=0))
			return true;
		return false;
	}
	
	private static boolean check_alpha(String st) {
		double num= Double.parseDouble(st);
		if((num>=0)&(num<=1))
			return true;
		return false;
	}
	
	public static String urlparse(String full, String[]...exclude) {
		String[] splited = full.split("\\?");
		String[] params = splited[1].split("&");
		HashSet<String> soled_params = new HashSet();
		for(int i = 0; i<params.length;i++)
			soled_params.add(""+params[i].charAt(0));
		
		for(String[] st : exclude) {
			soled_params.remove(st[0]);
		}
		
		String result_url = splited[0].concat("?");
		Iterator<String> iter = soled_params.iterator();
		while (iter.hasNext()) {
			
			
			String for_insert = get_name(iter.next(), params);
			
			result_url = result_url.concat(for_insert).concat("&");
		}
		return result_url.substring(0, result_url.length()-1);
	}
	
	public static String get_name(String reg, String[] params) {
		for(int i =params.length-1;i>0;i--) {
			
			if(params[i].charAt(0)==reg.charAt(0))
				return params[i];
		}
		return "bug";
	}
	
	public static String[] get_tags(String head) {
		String[] for_remove = {",",".","?","!"};
		
		String[] words = head.split(" ");
		
		String[] longest = {"","",""};
		for(String word: words) {
			for(int i = 0; i<longest.length;i++) {
				for(String rem : for_remove) {
					if(word.lastIndexOf(rem)!=0) {
						try {
							word = word.substring(0,word.lastIndexOf(rem));
						}
						catch (Exception e){}
					}
				}
				if(longest[i].length()<word.length()) {
					String bubble = longest[i];
					longest[i] = word;
					word = bubble;
				}
			}
		}
		for(int i = 0; i<longest.length;i++) {
			longest[i] = "#".concat(longest[i]);
			
		}
		
		return longest;
	}
	
	public static int ulan(int place) {
		boolean found = false;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(2);
		int next_num=3;
		int[] minus= {-1,-1};
		while(!found) {
			int[] first_pair = get_first_pair(nums, next_num);
			int[] second_pair = get_second_pair(nums, next_num, first_pair);
			
			if(second_pair[0]!=-1)
				nums.add(next_num);
			if(nums.size()==place)
				return next_num;
			next_num++;
			
			
			
		}
		return 000000;
	}
	
	public static int[] get_first_pair(ArrayList list, int target) {
		for(int i = 0; i<list.size();i++) {
			for(int j = 0 ;j<list.size();j++) {
				
				
				int num1 = (int) list.get(i);
				int num2 = (int) list.get(j);
				
				if ((i!=j)&((num1+num2)==target)) {
					int[] ret = {num1, num2};
					return ret;
				}
			}
		}
		int[] ret = {-1, -1};
		return ret ;
	}
	
	public static int[] get_second_pair(ArrayList list, int target, int[] first_pair) {
		for(int i = 0; i<list.size();i++) {
			for(int j = 0 ;j<list.size();j++) {
				int num1 = (int) list.get(i);
				int num2 = (int) list.get(j);
				if ((i!=j)&((num1+num2)==target)) {
					if((num2!=first_pair[1])|(num1!=first_pair[0])) {
						int[] ret = {num1, num2};
						return ret;
					}
				}
			}
		}
		int[] ret = {-1, -1};
		return ret ;
	}
	
	public static String nonrepeat(String in) {
		String saved = "";
		String current = "";
		for (char c:in.toCharArray()) {
			if(!current.contains(""+c)) {
				current+=""+c;
			}
			else {
				if (current.length()>saved.length()) {
					saved = current;
					current = "";
				}
			}
		}
		if (current.length()>saved.length())
			saved = current;
		return saved;
	}
	
	public static String toRom(int in) {
		String ret = "";
		ret = ret.concat(repeat(in/1000, "M"));
		ret = ret.concat(chooser((in/100)%10, "D","C"));
		ret = ret.concat(chooser((in/10)%10, "L","X"));
		ret = ret.concat(chooser(in%10, "V","I"));
		
		return ret;	
	}
	
	public static String chooser(int num, String high, String low) {
		String ret = "";
		if(num>5)
			ret = ret.concat(high).concat(repeat(num-5, low));
		else if(num==5)
			ret = ret.concat(high);
		else if(num==4)
			ret = ret.concat(low).concat(high);
		else
			ret = ret.concat(repeat(num, low));
		
		return ret;
	}
	
	public static String repeat(int num, String letter) {
		String ret = "";
		
		for(int i = 1;i<=num;i++)
			ret = ret.concat(letter);
		
		return ret;
	}
	
	public static boolean Formula(String form) {
		String[] blocks = form.split("=");
		int[] block_result = new int[blocks.length];
		int current_block = 0;
		String next_action = "+";
		for(int i = 0; i<blocks.length;i++) {
			block_result[i]=0;
		}
		for(String block : blocks) {
			String[] elements = block.split(" ");
			for(String element : elements) {
				if(isDigit(element)) {
					if(next_action.equals("+")) 
						block_result[current_block] = block_result[current_block]+Integer.parseInt(element);
					else if(next_action.equals("-"))
						block_result[current_block] = block_result[current_block]-Integer.parseInt(element);
					else if(next_action.equals("*"))
						block_result[current_block] = block_result[current_block]*Integer.parseInt(element);
					else if(next_action.equals("/"))
						block_result[current_block] = block_result[current_block]/Integer.parseInt(element);
					else
						return false;
					//next_action = "";
				}
				else 
					next_action = element;
				
			}
			current_block++;
			next_action = "+";
		}
		
		for(int i = 0; i<blocks.length-1;i++) {
			if(block_result[i]!=block_result[i+1])
				return false;
		}
		return true;
	}
	
	public static boolean isDigit(String st) {
		try {
			int num = Integer.parseInt(st);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public static boolean isPalindromeDesc(long num) {
		String num_str = String.valueOf(num);
		if (isPalindrome(num)){
			return true;
		}
		else if(num_str.length()>1) {
			String next_num = "";
			for(int i = 0; i<num_str.length()-1;i+=2) {
				int fir = Integer.parseInt(num_str.substring(i,i+1));
				int sec = Integer.parseInt(num_str.substring(i+1,i+2));
				next_num = next_num.concat(String.valueOf(fir+sec));
			}
			return isPalindromeDesc(Long.parseLong(next_num));
		}
		return false;
	}
	
	public static boolean isPalindrome(long num) {
		int nl = String.valueOf(num).length();
		String first_part = String.valueOf(num).substring(0, nl/2);
		String second_part = String.valueOf(num).substring(nl/2, nl);
		String revert = "";
		if (num < 2)
			return false;
		for(int i = nl/2-1; i>0; i--)
			revert = revert.concat(""+second_part.charAt(i));
		if(first_part.equals(revert))
			return true;
		return false;
	}
}