import java.util.*;
import java.io.*;
public class TidyNumbers {
	public static final String INPUT_FILE = "B-large-practice.in.txt";
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
					return tidyUp(str.substring(0,i-1)+c)+nines(str.length()-i);
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
		File inputFile = new File(INPUT_FILE);
		Scanner input = new Scanner(inputFile);
		PrintWriter output = new PrintWriter("B-large-output.txt");
		int testCases = input.nextInt();
		input.nextLine();
		for(int i = 1;i <= testCases;i++){
			String number = input.nextLine();
			output.printf("Case #%d: %s\n",i,tidyUp(number));	
		}
		output.close();
	}
}
