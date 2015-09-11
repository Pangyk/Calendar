package cn.edu.nju.software.CourseSchedule;

public class WeekDay {
	
	public static int numDay(String s){
		int weekDay=0;
		
		switch(s){
		case "����һ":
			weekDay=0;
			break;
		case "���ڶ�":
			weekDay=1;
			break;
		case "������":
			weekDay=2;
			break;
		case "������":
			weekDay=3;
			break;
		case "������":
			weekDay=4;
			break;
		}		
		return weekDay;
	}
	
	public static int[] numTime(String s,int len){		
		
		char[] t=s.toCharArray();		
		int[] time=new int[len-1];
		
		for(int j=0;j<len-1;j++)
			time[j]=-1;
		
		for(int i=0;i<len-1;i++){
			int n=transfer(t[i],t[i+1]);
			time[i]=n;		
		}	
		return time;
	}
	
	private static int transfer(char a,char b){
		int num=-1;
		switch(a){
		case 'һ':
			num=0;
			break;
		case '��':
			num=1;
			break;
		case '��':
			num=2;
			break;
		case '��':
			num=3;
			break;
		case '��':
			num=4;
			break;
		case '��':
			num=5;
			break;
		case '��':
			num=6;
			break;
		case '��':
			num=7;
			break;
		case '��':
			num=8;
			break;
		case 'ʮ':
			if(b!='һ')
				num=10;
			else
				num=11;
			break;
		default:
			break;
		}
		
		return num;
	}
	
}
