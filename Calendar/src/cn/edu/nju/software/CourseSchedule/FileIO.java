package cn.edu.nju.software.CourseSchedule;

import java.io.*;

public class FileIO {
	private static final int day=5;
	private static final int maxCourse=11;
	File file=new File("d:/CourseSchedule.txt");
	
	public void showFile(){
		try{
			BufferedReader br=new BufferedReader(new FileReader("d:/CourseSchedule.txt"));
			String[][] courseList=new String[day][maxCourse];
			String temp=null;
		
			for(int i=0;i<day;i++)
				for(int j=0;j<maxCourse;j++)
					courseList[i][j]=null;
		
			while((temp=br.readLine())!=null){				
				new Course(temp,3);
				String s1=Course.getDay();
				String s2=Course.getTime();
				int len=Course.getTimeLenth();
				int[] t=WeekDay.numTime(s2,len);
			
				for(int i=0;i<=Course.getTimeLenth()-1;i++){
					if(t[i]!=-1){
						courseList[WeekDay.numDay(s1)][t[i]]=temp;
						break;
					}
				}
			}
			br.close();
		
			for(int i=0;i<day;i++)
				for(int j=0;j<maxCourse;j++)
					if(courseList[i][j]!=null)
						System.out.println(courseList[i][j]);
		}catch(Exception ex){
			
		}
	}
	
	public static void writeFile(String course){
		
		try{
			FileWriter fw=new FileWriter("d:/CourseSchedule.txt",true);
			PrintWriter writer=new PrintWriter(fw);
			writer.print(course);
			writer.println();
			System.out.println("已添加到文件中");
			writer.close();
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	public static String scanThroughCourse(String source1,String source2){
		String output="未找到课程";
		String s1=null,s2=null,temp=null,course=null;
		
		try{
			BufferedReader br=new BufferedReader(new FileReader("d:/CourseSchedule.txt"));
				 	 
			while((temp=br.readLine())!=null){
				new Course(temp,3);
				s1=Course.getDay();
				s2=Course.getTime();
				if(s1.equals(source1)&&s2.equals(source2)){   
					output=Course.getDetail();
					course=temp;
				}
			}
			br.close();	
			System.out.println(output);
						
		}catch(IOException e){
			e.printStackTrace();
		}
		return course;
	}
	
	public void recreateCourseList(String target){
		
		try{
			BufferedReader br=new BufferedReader(new FileReader("d:/CourseSchedule.txt"));
			StringBuffer strbuf=new StringBuffer();
			
			String temp=null;
		 	 
			while((temp=br.readLine())!=null){
				if(!temp.equals(target)){
					strbuf.append(temp).append("\r\n");
				}						
			}
			br.close();	
			file.delete();
			
			
			FileWriter fw=new FileWriter(new File("d:/CourseSchedule.txt"),false);
			PrintWriter writer=new PrintWriter(fw);
			writer.print(strbuf);
			writer.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void updateCourseList(String source1,String source2){
		 String course=scanThroughCourse(source1,source2);
		 recreateCourseList(course);
		 
		 try{
			 FileWriter fw=new FileWriter("d:/CourseSchedule.txt",true);
			 PrintWriter writer=new PrintWriter(fw);
			 writer.println(course);
			 writer.close();
			 System.out.println("已更新文件");
			 
		 }catch(IOException ex){
		 	ex.printStackTrace();
		 }
	}

}
