package cn.edu.nju.software.CourseSchedule;

public class Course {
	private static String day;
	private static String time;
	private static String detail;
	
	public Course(String s){		
		String[] split=s.split("\\£»",2);
		
		day=split[0];
		time=split[1];
	}
	
	public Course(String s,int n){
		String[] split=s.split("£»", 3);

			day=split[0];
			time=split[1];
			detail=split[2];	
	}
	
    public static String getDay(){
    	return day;
    }
    
    public static String getTime(){
    	return time;
    }
    
    public static String getDetail(){
    	return detail;
    }
    
	public static int getTimeLenth(){
		return time.length();
	}
	
}
