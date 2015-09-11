//естф©Э
//2015/7/16
package edu.nju.sudoku;

//contents
//Reuse instructions                                                                                             
//Modification instructions
//Compilation instructions

//Sudoku class

public class Sudoku {

	private int[][] sudoku={{0,0,0,0,0,0,2,0,0},
			                {0,0,0,0,0,0,0,5,0},
			                {0,4,0,0,3,0,0,0,0},
			                {0,0,0,0,0,9,0,0,4},
			                {0,3,0,0,0,0,0,0,7},
			                {0,0,0,7,0,5,0,0,0},
			                {5,0,2,8,0,0,0,0,0},
			                {0,0,9,0,0,0,0,0,0},
			                {0,0,0,0,7,0,1,0,6}};
	private int[] row=new int[81];
	private int[] column=new int[81];
	int count=0;
	
//count method
	
	public void count(){
		
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(isBlank(i,j)){
					row[count]=i;
					column[count]=j;
					count++;
				}
			}
		}
		
		next(0);
		print();
	}
//end
	
//next method
	
	public boolean next(int lc){
		int i=row[lc];
		int j=column[lc];
		if(lc>=count){
			return true;
		}
		
		for(int m=sudoku[i][j]+1;m<=9;m++){
			set(m,i,j);
			if(!isOccupied(m,i,j)){
				if(next(lc+1)){
					return true;
				}
			}
		}

		remove(row[lc],column[lc]);
		
		return false;
	}
//end
	
//set method
	
	public void set(int num,int x,int y){
		sudoku[x][y]=num;
	}
//end
	
//remove method
	
	public void remove(int x,int y){
		sudoku[x][y]=0;
	}
//end
	
//print method
	
	public void print(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(sudoku[i][j]+" ");
			}
			System.out.println();
		}
	}
//end
	
//isOccupied method
	
	public boolean isOccupied(int num,int i,int j){
		
		for(int k=0;k<9;k++){
			if(sudoku[i][k]==num&&k!=j||sudoku[k][j]==num&&k!=i){
				return true;
			}
		}
		
		int block1=i%3;
		int block2=j%3;
		for(int k=i-block1;k<i-block1+3;k++){
			for(int m=j-block2;m<j-block2+3;m++){
				if(sudoku[k][m]==num&&k!=i&&m!=j){
					return true;
				}
			}
		}
		return false;
	}
//end
	
//isBlank method
	
	public boolean isBlank(int x,int y){
		if(sudoku[x][y]==0)
			return true;
		else
			return false;
	}
//end
	
//main method
	
	public static void main(String[] args){
		Sudoku solve=new Sudoku();
		solve.count();
	}
//end
}
