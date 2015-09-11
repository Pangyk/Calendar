package cn.edu.nju.software.Calendar;
/*This application program calculates the number of days from a certain date to today
 * Additionally it can help to calculate the number of days from 1995.5.23 to today*/

import javax.swing.JOptionPane;

// this is the version 1.1.2



public class CalculatingDate{
	public static void main(String[] args){
        System.out.println("this is the version of 1.1.2");
        
		int option=JOptionPane.showConfirmDialog(null, 
				"Would you like to provide a certain date that have passed?" );
//Choose which one of the two functions to calculate number of days
		switch(option){
		case JOptionPane.YES_OPTION:
			String input="Please enter the ";
			int pastYear=getThisYear(input+"year");
			int pastMonth=getThisMonth(input+"month");
			int pastDate=getThisDate(input+"date");
			calculateCertainDate(pastYear,pastMonth,pastDate);		
			break;
		case JOptionPane.NO_OPTION:
			calculateJavaDate();
			break;
		default:
			System.exit(0);
		}
	}
		
		public static void calculateCertainDate(int oldYear,int oldMonth,int oldDate){
			int numberOfDays=calculateTotalNumberOfDays(oldYear,oldMonth,oldDate);
			String output="The number of days is"+numberOfDays;
			printNumberOfDays(output);
		}//Calculating the number of days from a certain date to today
		
		public static void calculateJavaDate(){
			int numberOfDays=calculateTotalNumberOfDays(1995,5,23);
			String output="The number of days is"+numberOfDays+"days";
			printNumberOfDays(output);
		}//Calculating the number of days from 1995.5.23 to today
		
		public static int calculateTotalNumberOfDays(int year,int month,int date){
			String input="Please enter the ";
			int thisYear=getThisYear(input+"year of this year");
			int thisMonth=getThisMonth(input+"month of this month");
			int thisDate=getThisDate(input+"date of today");
			int daysInMonth=0,totalNumberOfDays=0;
			
			if(year<=thisYear){
				for(int i=year;i<=thisYear-1;i++){
					if(isLeapYear(i))
						totalNumberOfDays+=366;
					else
						totalNumberOfDays+=365;
				}	
				for(int i=1;i<=month-1;i++){
					daysInMonth=getNumberOfDaysInMonth(year,i);
					totalNumberOfDays-=daysInMonth;
				}
				for(int i=1;i<thisMonth;i++){
					daysInMonth=getNumberOfDaysInMonth(thisYear,i);
					totalNumberOfDays+=daysInMonth;
				}			
			    return totalNumberOfDays-date+thisDate;
			}
			
			else{
				JOptionPane.showMessageDialog(null,"Invalid,enter the date again!");
				return calculateTotalNumberOfDays(year,month,date);
			}
		}//Calculating the number of days
		
		public static int getNumberOfDaysInMonth(int year,int month){
			if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
				return 31;
			else if(month==4||month==6||month==9||month==11)
				return 30;
			else if(month==2&&isLeapYear(year))
				return 29;
			else
				return 28;
		}
		
		public static boolean isLeapYear(int year){
			return year%400==0||(year%4==0&&year%100!=0);
		}
		
		
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
