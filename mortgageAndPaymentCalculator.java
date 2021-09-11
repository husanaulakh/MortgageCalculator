package MortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class mortgageAndPaymentCalculator {

	final static byte MONTHS_IN_YEAR = 12;
	final static byte PERCENT = 100;
	
	public static void main(String[] args) {	
		int principal = (int) readNumber("Principal ($1K - $1M): ", 1000, 1000000);
		double annualInterest = readNumber("Annual Interest Rate: ", 0, 30);		
		int years = (int) readNumber("Period (Years): ", 1, 30);

		printMortgage(principal, annualInterest, years);
		printPaymentSchedule(principal, annualInterest, years);	
	}

	private static void printMortgage(int principal, double annualInterest, int years) {
		double mortgage = calculateMortgage(principal, annualInterest, years);
		String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println();
		System.out.println("MORTGAGE");
		System.out.println("--------");
		System.out.println("Monthly Payments: " + formattedMortgage);
	}

	private static void printPaymentSchedule(int principal, double annualInterest, int years) {
		System.out.println();
		System.out.println("PAYMENT SCHEDULE");
		System.out.println("----------------");
		for(int month = 1; month <= years * MONTHS_IN_YEAR; month++) {
			double balance = calculateBalance(principal, annualInterest, years, month);
			System.out.println(NumberFormat.getCurrencyInstance().format(balance));
		}
	}
	
	public static double calculateBalance(
			double principal, 
			double annualInterest,
			int years,
			int numberOfPaymentsMade) {
		
		int numberOfPayments = years * MONTHS_IN_YEAR;
		double monthlyInterest = annualInterest / MONTHS_IN_YEAR/ PERCENT;
		
		double balance = principal
				* (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
				/ (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
		
		return balance;
	}
	
	public static double readNumber(String prompt, double min, double max) {
		Scanner scanner = new Scanner(System.in);
		double value;
		while(true) {
			System.out.print(prompt);
			value = scanner.nextDouble();
			if(value >= min && value <= max) {
				break;
			}
			System.out.println("Enter a value between " + min + " and " + max);
		}
		return value;
	}
	
	public static double calculateMortgage(double principal, double annualInterest, int years) {
		
		int numberOfPayments = years * MONTHS_IN_YEAR;
		double monthlyInterest = annualInterest / MONTHS_IN_YEAR/ PERCENT;
		
		double mortgage = principal * 
				(monthlyInterest * Math.pow(1+monthlyInterest, numberOfPayments))
				/ (Math.pow(1 + monthlyInterest, numberOfPayments)-1);
		return mortgage;
	}

	
}
