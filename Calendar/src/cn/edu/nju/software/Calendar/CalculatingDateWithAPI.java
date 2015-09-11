package cn.edu.nju.software.Calendar;
/**/

import javax.swing.JOptionPane;
import java.util.Calendar;

public class CalculatingDateWithAPI {
	public static void main(String[] args){
		int option=JOptionPane.showConfirmDialog(null, 
				"Would you like to provide a certain date that have passed?" );
//Choose which one of the two functions to calculate number of days
		switch(option){
		case JOptionPane.YES_OPTION:
			String input="Please enter the";
			int pastYear=getThisYear(input+"year");
			int pastMonth=getThisMonth(input+"month");
			int pastDate=getThisDate(input+"date");
			getCertainDateWithAPI(pastYear,pastMonth,pastDate);	
			break;
		case JOptionPane.NO_OPTION:
			getJavaDateWithAPI();
			break;
		default:
			System.exit(0);
		}
	}
	
	public static void getCertainDateWithAPI(int year,int month,int date){
		int numberOfDays=getDateWithAPI(year,month,date);
		String output="The total number of days is"+numberOfDays+"days";
		printNumberOfDays(output);
	}
	
	public static void getJavaDateWithAPI(){
		int numberOfDays=getDateWithAPI(1995,5,23);
		String output="The total number of days is"+numberOfDays+"days";
		printNumberOfDays(output);
	}
	
	public static int getDateWithAPI(int year,int month,int date){	
		Calendar calendar=Calendar.getInstance();
	    long today=calendar.getTimeInMillis();
	    calendar.set(year,month-1,date);//The real month=month+1
	    long day=calendar.getTimeInMillis();
		
	    int number=(int)((today-day)/(1000*3600*24));
	    return number;
	}//Calculating the number of days
	
	public static int getThisYear(String input){
		String getYear=JOptionPane.showInputDialog(null,input);
		return Integer.parseInt(getYear);
	}
	
	public static int getThisMonth(String input){
		String getMonth=JOptionPane.showInputDialog(null,input);
		return Integer.parseInt(getMonth);
	}
	
	public static int getThisDate(String input){
		String getDate=JOptionPane.showInputDialog(null,input);
		return Integer.parseInt(getDate);
	}
	
	public static void printNumberOfDays(String output){
		JOptionPane.showMessageDialog(null, output);
	}
}
