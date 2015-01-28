import java.io.*;
import java.sql.SQLException;
import java.util.Scanner;

import quoteServer.*;
import database.*;

public class main {

	public static void main(String[] args) {

		try {
			database_connect.connectToDatabase();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Get user input
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		reader.close();

		// get command type
		String[] parsed = input.split(",");

		switch (parsed[0].toString().toLowerCase()) {
		case "quote":
			try {
				System.out.println(quote_server_connect.getQuote(input));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

	}

}