package cn.edu.nju.software.CourseSchedule;

import java.util.*;

public class Option {
	public static void main(String[] args){	
		while(true){
			System.out.println("ÇëÊäÈë²Ù×÷ÃüÁî:");
			getCourse();	
		}
	}
	
	private static void getCourse(){

		Scanner input=new Scanner(System.in);
		String command=input.nextLine();		
		String option=null;
		String course=null;
		int index=command.indexOf("ÐÇ");
		
		if(index>0){
			option=command.substring(0, index);
			course=command.substring(index);		
			char s=course.charAt(3);
			char[] c=new char[course.length()];
		
			for(int i=0;i<course.length();i++){			
				char t=course.charAt(i);
				if(s==t)
					c[i]='£»';
				else
					c[i]=t;
			}	
			String output=String.valueOf(c);
			System.out.println(output);
			switchOption(option,output,new Methods());
		}
		
		else{
			option=command;
			switchOption(option,course,new Methods());
		}	
	}
	
	public static void switchOption(String option,String course,Methods app){
		switch(option){
		case "Add":
			app.addCourse(course);
			break;
		case "Remove":
			app.removeCourse(course);
			break;
		case "Update":
			app.updateCourse(course);
			break;
		case "Find":
			app.findCourse(course);
			break;
		case "Show":
			app.showCourse();
			break;
		case "End":
			System.exit(0);
			break;
		default:
			System.out.println("ÇëÖØÐÂÊäÈëÃüÁî");
		}		
	}
}
