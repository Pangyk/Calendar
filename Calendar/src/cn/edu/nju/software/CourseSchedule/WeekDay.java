package cn.edu.nju.software.CourseSchedule;

public class WeekDay {
	
	public static int numDay(String s){
		int weekDay=0;
		
		switch(s){
		case "星期一":
			weekDay=0;
			break;
		case "星期二":
			weekDay=1;
			break;
		case "星期三":
			weekDay=2;
			break;
		case "星期四":
			weekDay=3;
			break;
		case "星期五":
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
		case '一':
			num=0;
			break;
		case '二':
			num=1;
			break;
		case '三':
			num=2;
			break;
		case '四':
			num=3;
			break;
		case '五':
			num=4;
			break;
		case '六':
			num=5;
			break;
		case '七':
			num=6;
			break;
		case '八':
			num=7;
			break;
		case '九':
			num=8;
			break;
		case '十':
			if(b!='一')
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
