package cn.edu.nju.software.CourseSchedule;

public class Methods {
	
	public void addCourse(String s){
		FileIO.writeFile(s);

		System.out.println("-------------------------------------"+"\n");
	}
	
	public void removeCourse(String s){
		FileIO app=new FileIO();	
		app.recreateCourseList(s);
		System.out.println("已从文件删除");

		System.out.println("-------------------------------------"+"\n");
	}
	
	public void updateCourse(String s){
		FileIO app=new FileIO();
		new Course(s);
		app.updateCourseList(Course.getDay(),Course.getTime());
		
		System.out.println("-------------------------------------"+"\n");
	}
	
	public void findCourse(String s){
		new Course(s);
		FileIO.scanThroughCourse(Course.getDay(), Course.getTime());
		
		System.out.println("-------------------------------------"+"\n");
	}
	
	public void showCourse(){
		FileIO app=new FileIO();
		app.showFile();
		
		System.out.println("-------------------------------------"+"\n");
	}
	
	

}
