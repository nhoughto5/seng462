import java.io.*;
import java.util.Scanner;

import quoteServer.*;

public class main{
	
	public static void main(String[] args){
		
		//Get user input
		Scanner reader = new Scanner(System.in);
		String input =reader.nextLine();
		reader.close();
		
		//get command type
		String[] parsed = input.split(",");
		
		switch(parsed[0].toString().toLowerCase()){
		case "quote":
			System.out.println("QUOTE");
			break;
		case "add":
			System.out.println("ADD");
			break;
		case "buy":
			System.out.println("BUY");
			break;
		case "sell":
			System.out.println("SELL");
			break;
		}
		
		/*
		 * String quoteReturned = null;
		try {
			quoteReturned = quote_server_connect.getQuote(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(quoteReturned);
		*/
		
		
	}
	
}