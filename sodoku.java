
import java.io.*;
import java.util.Scanner;

public class IV_SUDOKU{

	static int size=9;

	public static void main(String[] args){

	int[][] board = new int[size][size];
	int row =size;
	int column = size;
        System.out.println("hi");
        readpuzzle(board);
        print(board);
	solve(board);
        System.out.println("solved:");
        print(board);

	}

	public static boolean solve(int[][] board){

	   return solveNQueens(board,0,0);
	}
	public static boolean solveNQueens(int[][]board, int row , int column){
		if(row==9){//base case
			return true;

		}


		
		if(board[row][column]!=0){ //saying if something is not there
			if(column == board.length-1){
				return solveNQueens(board,row+1,0);
		
			}
			else{
				return solveNQueens(board,row,column+1);
			}
		}
		if (row<9){
			for(int i =1;i<10;i++){
				if(canPlace(board,row,column,i)==true){
					board[row][column]=i;
					if(column<board.length-1){
						if(solveNQueens(board,row,column+1)){
							 return true;
						}
						else{
							board[row][column]=0;
						}
					}
					if(column==board.length-1){
						if(solveNQueens(board,row+1,0)){
							return true;
						}

					
						else{
							board[row][column]= 0;
						}
					}	
				}
			}




		}
		return false;

	
	}

	public static boolean canPlace(int[][]board,int row, int column, int count){
		for(int i=0; i<board.length;i++){//checking rows
			if(board[row][i]  == count){
				return false;
			}

		}

		for(int i=0; i<board.length;i++){//checking columns
			if(board[i][column] == count){
				return false;
			}
		}
	//check da boxes
		//for(int i =0;)
		int newRow =(row/3)*3;
		int newColumn = (column/3)*3;

		for(int i = newRow;i<newRow+3;i++){
			for(int k =newColumn;k<newColumn+3;k++){
				if(board[i][k]==count){
					return false;
				}
			}
		}

		return true; 
	}


	

    public static void readpuzzle(int[][] board){
		Scanner s = new Scanner(System.in);
        for (int i=0; i<size; i++) {
        	String line = s.nextLine();
        	for (int j=0; j<size; j++) {
            	char c = line.charAt(j);
            	if(c!=' '){
                	board[i][j]=Integer.valueOf(c+"");
                }
            }
        }
        
	}
    


	public static int[][] copy(int[][] input){

		int[][] output = new int[input[0].length][input[0].length];
		for(int i=0; i<input[0].length; i++){
			for(int j=0; j<input[0].length; j++){
				output[i][j]=input[i][j];
			}
		}
		return output;
	}


	public static void print(int[][] input){
		for(int i=0; i<input[0].length; i++){
			for(int j=0; j<input[0].length; j++){
				System.out.print(input[i][j]+" ");
			}
			System.out.println("");
		}
	}

}