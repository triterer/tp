import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class main {
	
	public static void main(String[] args) {
		int[] crypt = encrypt("Hello");
		System.out.println("cypted^ "+ Arrays.toString(crypt));
		System.out.println("decrypted^ "+ decrypt(crypt));
		System.out.println("chess "+ chess("rook", "A8", "H8"));
		System.out.println("bleatifull: " + cancomplite("butl", "beautiful"));
		System.out.println("nums to one: "+ sumDigProd(1, 2, 3, 4, 5, 6));
		System.out.println("vows "+sameVowelGroup("hoops", "chuff", "bot", "bottom").toString());
		long num = Long.parseLong("1234567890123452");
		System.out.println("credit card:  "+validate_card(num));
		System.out.println("num:  "+numtoEnd(234));
		System.out.println("sha256:  "+sha256("adefwefe"));
		System.out.println("thrones:  "+correctTitle("TYRION LANNISTER, HAND OF THE QUEEN."));
		System.out.println("hex\n"+hex(19));
	}
	
	public static int[] encrypt(String tocrypt) {
		int[] crypt = new int[tocrypt.length()];
		crypt[0] = tocrypt.codePointAt(0);
		for(int i = 1; i<tocrypt.length();i++) {
			crypt[i] = tocrypt.codePointAt(i)-tocrypt.codePointAt(i-1);;
		}
		return crypt;
	}
	
	public static StringBuilder decrypt(int[] crypt) {
		StringBuilder decrypt = new StringBuilder();
		int currchar = 0;
		for(int el: crypt) {
			currchar +=el;
			decrypt.append((char) currchar);
		}
		return decrypt;
	}
	
	public static boolean chess(String fig, String start, String finish) {
		int sv = start.codePointAt(0);
		int sh = start.charAt(1);
		int fv = finish.codePointAt(0);
		int fh = finish.charAt(1);
		if((fig=="pawn")&&(Math.abs(sv-fv)<1)&&(sh-fh==0)) {return true;}
		if((fig)=="rook"&&vertical(sv,sh,fv,fh)) {return true;}
		if((fig=="knight")&&(Math.abs(sv-fv)==3)&&(Math.abs(sh-fh)==1)) { return true;}
		if((fig=="knight")&&(Math.abs(sh-fh)==3)&&(Math.abs(sv-fv)==1)) { return true;}
		if((fig=="bishop")&&diagonal(sv,sh,fv, fh)) {return true;}
		if((fig=="queen")&&(vertical(sv,sh,fv,fh)||diagonal(sv,sh,fv, fh))) {return true;}
		if((fig=="king")&&(Math.abs(sv-fv)<1)&&(Math.abs(sh-fh)<1)) {return true;}
		return false;
		}
		
	 private static boolean vertical(int sv, int sh, int fv, int fh) {
		 if ((Math.abs(sv-fv)>0)&&(sh-fh==0)) {return true;}
		 if ((Math.abs(sh-fh)>0)&&(sv-fv==0)) {return true;}
		 return false;
	 }
	 private static boolean diagonal(int sv, int sh, int fv, int fh) {
		 if(Math.abs(sv-fv)==Math.abs(sh-fh)) {return true;}
		 return false;
	 }
	 
	 public static boolean cancomplite(String defect, String idela) {
		 int lastindex = 0;
		 for(int i=0;i<defect.length();i++) {
			 int res = idela.substring(lastindex, idela.length()).indexOf(defect.charAt(i));
			 if(res==-1) {
				 return false;
			 }
		 }
		 return true;
	 }
	 
	 public static int sumDigProd(int...nums) {
		 
		 int sum=0;
		 int iter=0;
		 for(int i = 0;i<nums.length;i++) {
			 sum+=nums[i];
		 }
		 int prod =1;
		 while(sum>9) {
			 
			 iter=0;
			 while(sum>0) {
				 prod*=sum%10;
				 sum=sum/10;
				 iter++;
			 }
			 sum = prod;
			 
		 }
		 return sum;
	 }
	 
	 public static ArrayList<String> sameVowelGroup(String...words) {
		 String first = words[0];
		 ArrayList<String> strarr = new ArrayList<>();
		 ArrayList<String> strarr1 = new ArrayList<>();
		 
		 for(char c : first.toCharArray()) {
			 switch(c) {
			 case'a':strarr.add(""+c);break;
			 case'u':strarr.add(""+c);break;
			 case'o':strarr.add(""+c);break;
			 case'i':strarr.add(""+c);break;
			 case'e':strarr.add(""+c);
			 }
		 }
		 
		 for(String word :words) {
			 int counter = 0;
			 for(String c : strarr) {
				 if(word.contains(c)) {
					 counter+=1;
				 }
			 }
			 
			 if(counter==strarr.size()) {
				 strarr1.add(word);
			 }
		 }
		 return strarr1;
	 }
	 
	 public static boolean validate_card(long code) {
		 int last_num = (int) (code%10);
		 code = code/10;
		 ArrayList<Long> reversed = new ArrayList<>();
		 long to_add;
		 for(int i = 0; code>0;i++) {
			 reversed.add(code%10);
			 code = code/10;
		 }
		 
		 int sum=0;
		 for(int i = 0; i<reversed.size();i++) {
			 if(i%2!=0) {
				 to_add = reversed.get(i)*2;
				 if(to_add/10>0)
					 reversed.set(i, to_add%10+to_add/10);
				 else
					 reversed.set(i, to_add);
			 }
			 sum+=reversed.get(i);
		 }
		 if(10-sum%10==last_num)
			 return true;
		 return false;
		 

	 }
	 
	 public static String numtoEnd(int num) {
		 if(num ==0)
			 return "zero";
		 String last_num="";
		 String middle_num = "";
		 String first_num = "";
		 switch(num%10) {
		 case 1:last_num = "one";break;
		 case 2:last_num = "two";break;
		 case 3:last_num = "three";break;
		 case 4:last_num = "four";break;
		 case 5:last_num = "five";break;
		 case 6:last_num = "six";break;
		 case 7:last_num = "seven";break;
		 case 8:last_num = "eight";break;
		 case 9:last_num = "nine";break;
		 }
		 switch(num/10%10) {
		 case 1:middle_num = "ten ";break;
		 case 2:middle_num = "twelve ";break;
		 case 3:middle_num = "thirty ";break;
		 case 4:middle_num = "fourty ";break;
		 case 5:middle_num = "fifty ";break;
		 case 6:middle_num = "sixty ";break;
		 case 7:middle_num = "seventy ";break;
		 case 8:middle_num = "eightty ";break;
		 case 9:middle_num = "ninety ";break;
		 }
		 switch(num/10) {
		 case 11:middle_num = "eleven";last_num="";break;
		 case 12:middle_num = "twelve";last_num="";break;
		 case 13:middle_num = "thirteen";last_num="";break;
		 case 14:middle_num = "fourteen";last_num="";break;
		 case 15:middle_num = "fifteen";last_num="";break;
		 case 16:middle_num = "sixteen";last_num="";break;
		 case 17:middle_num = "seventeen";last_num="";break;
		 case 18:middle_num = "eightteen";last_num="";break;
		 case 19:middle_num = "nineteen";last_num="";break;
		 }
		 switch(num/100) {
		 case 1:first_num = "one hundred ";break;
		 case 2:first_num = "two hundred ";break;
		 case 3:first_num = "three hundred ";break;
		 case 4:first_num = "four hundred ";break;
		 case 5:first_num = "five hundred ";break;
		 case 6:first_num = "six hundred ";break;
		 case 7:first_num = "seven hundred ";break;
		 case 8:first_num = "eight hundred ";break;
		 case 9:first_num = "nine hundred ";break;
		 }
		 
		 return first_num.concat(middle_num).concat(last_num);
	 }
	 
	 public static String sha256(String base) {
		    try{
		        MessageDigest digest = MessageDigest.getInstance("SHA-256");
		        byte[] hash = digest.digest(base.getBytes("UTF-8"));
		        StringBuffer hexString = new StringBuffer();

		        for (int i = 0; i < hash.length; i++) {
		            String hex = Integer.toHexString(0xff & hash[i]);
		            if(hex.length() == 1) hexString.append('0');
		            hexString.append(hex);
		        }

		        return hexString.toString();
		    } catch(Exception ex){
		       throw new RuntimeException(ex);
		    }
		}
	 
	 public static String correctTitle(String st) {
		 st = st.toLowerCase();
		 String[] words = st.split(" ");
		 String compile="";
		 for(int i = 0;i<words.length;i++) {
			 
			 if((words[i].equals("and"))|(words[i].equals("in"))|(words[i].equals("of"))|(words[i].equals("the")))
				 compile=compile.concat(words[i]);
			 else
				 compile=compile.concat(words[i].replace(words[i].charAt(0), Character.toUpperCase(words[i].charAt(0))));
			 
			 compile = compile.concat(" ");
			 
		 }
		 return compile.trim();
	 }
	 
	 public static String hex(int num){
		 int start_side = 0;
		 int sum;
		 boolean match = false;
		 int curr_side;
		 int iter;
		 while (!match) {
			 start_side++;
			 sum = 0;
			 iter=0;
			 for(curr_side=start_side; iter<start_side-1; curr_side++) {
				 sum+=curr_side*2;
				 iter++;
			 }
			 sum+=start_side*2-1;
			 if(sum==num)
				 match = true;
			 else if(sum>num)
				 return "no";
			 
		 }
		 
		 String hex="";
		 int central_line = start_side*2-1;
		 iter = 0;
		 for(curr_side=start_side; iter<start_side-1;curr_side++) {
			 int spaces = ((central_line*2-1)-(curr_side*2-1))/2;
			 
			 hex = hex.concat(drawWhitespaces(spaces));
			 hex = hex.concat(drawStars(curr_side));
			 hex = hex.concat(drawWhitespaces(spaces));
			 hex = hex.concat("\n");
			 iter++;
		 }
		 hex = hex.concat(drawStars(central_line)).concat("\n");
		 iter = 0;
		 for(curr_side=central_line-1; iter<start_side-1;curr_side--) {
			 int spaces = ((central_line*2-1)-(curr_side*2-1))/2;
			 
			 hex = hex.concat(drawWhitespaces(spaces));
			 hex = hex.concat(drawStars(curr_side));
			 hex = hex.concat(drawWhitespaces(spaces));
			 hex = hex.concat("\n");
			 iter++;
		 }
		 return hex;
		 
	 }
	 
	 public static String drawStars(int num) {
		 String ret = "";
		 for (int i = 0; i<num; i++) {
			 ret = ret.concat("* ");
		 }
		 
		 return ret.substring(0, ret.length()-1);
	 }
	 
	 public static String drawWhitespaces(int num) {
		 String ret = "";
		 for (int i = 0; i<num; i++) {
			 ret = ret.concat(" ");
		 }
		 return ret.substring(0, ret.length());
	 }

}