import java.io.*;

import java.util.Scanner;

public class home extends quote_server_connect{
	
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		String input =reader.nextLine();
		String quoteReturned = null;
		
		try {
			quoteReturned = getQuote(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(quoteReturned);
		reader.close();
	}
	
}