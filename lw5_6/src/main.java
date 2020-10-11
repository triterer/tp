import java.util.ArrayList;
import java.util.Arrays;
public class main {
	
	public static void main(String[] args) {
		int[] crypt = encrypt("Hello");
		System.out.println("cypted^ "+ Arrays.toString(crypt));
		System.out.println("decrypted^ "+ decrypt(crypt));
		System.out.println("chess "+ chess("rook", "A8", "H8"));
		System.out.println("bleatifull: " + cancomplite("butl", "beautiful"));
		System.out.println("nums to one: "+ sumDigProd(1, 2, 3, 4, 5, 6));
		System.out.println("vows "+sameVowelGroup("hoops", "chuff", "bot", "bottom").toString());
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
		 ArrayList<String> strarr = new ArrayList();
		 ArrayList<String> strarr1 = new ArrayList();
		 int iter=0;
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
}