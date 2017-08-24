import java.util.*;
public class TidyNumbers {
	public static String tidyUp(String str){
		if(str.length() < 2){
			if(str.equals("0"))
				return "";
			else
				return str;
		}
		else {
			for(int i=str.length()-1;i>0;i--){
				if(str.charAt(i) < str.charAt(i-1)){
					char c = str.charAt(i-1);
					c--;
					return tidyUp(str.substring(0,i-1)+c) +
						nines(str.length()-i);
				}
			}
		}
		return str;
	}
	public static String nines(int num){
		String temp = "";
		for(int i=0;i<num;i++)
			temp += "9";
		return temp;
	}
	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		input.nextLine();
		for(int i = 1;i <= testCases;i++){
			String number = input.nextLine();
			System.out.println.printf("Case #%d: %s\n",i,tidyUp(number));	
		}
	}
}
