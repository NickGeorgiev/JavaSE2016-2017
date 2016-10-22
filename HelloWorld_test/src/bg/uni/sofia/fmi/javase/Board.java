package bg.uni.sofia.fmi.javase;

public class Board {
	private char[][] board;
	private int rows;
	private int columns;
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		board = new char[this.rows][this.columns];
		char filler = '1';
		for(int i=0;i<this.rows;i++)
		{
			for(int j=0;j<this.columns;j++)
			{
				board[i][j]=filler;
				filler += 1; //the board can be max 2x3
			}
		}
	}
	public void showBoard()
	{
		for(int row=0;row<rows;row++)
		{
			for(int column=0;column<columns;column++)
			{
				if(column==(columns-1))System.out.println(board[row][column]);
				else System.out.print(board[row][column]+" | ");
			}
			if(row != (rows-1)) System.out.println("-   -   -   ");
		}
	}
	public boolean setPosition(int rowPos,int colPos,char sign,char checkSign1,char checkSign2)
	{
		if(board[rowPos][colPos] == checkSign1 || board[rowPos][colPos] == checkSign2) return false;
		board[rowPos][colPos] = sign;
		return true;
	}
	public boolean checkBoard(char checkSign1,char checkSign2)
	{
		
		boolean firstPlayerHasAMainDiag = true;
		boolean firstPlayerHasASecondDiag = true;
		boolean firstPlayerHasARow = true;
		boolean firstPlayerHasAColumn = true;
		
		boolean secondPlayerHasAMainDiag = true;
		boolean secondPlayerHasASecondDiag = true;
		boolean secondPlayerHasARow = true;
		boolean secondPlayerHasAColumn = true;
		
		//checking everything
		for(int row=0;row<3;row++)
		{
			//checking main diagonal
			if(board[row][row] != checkSign1) firstPlayerHasAMainDiag = false;
			if(board[row][row] != checkSign2) secondPlayerHasAMainDiag = false;
			
			//checking second diagonal
			if(board[row][2-row] != checkSign1) firstPlayerHasASecondDiag = false;
			if(board[row][2-row] != checkSign2) secondPlayerHasASecondDiag = false;
			
			for(int column=0;column<3;column++)
			{
				if(board[row][column] != checkSign1) firstPlayerHasARow = false;
				if(board[row][column] != checkSign2) secondPlayerHasARow = false;
				
				if(board[column][row] != checkSign1) firstPlayerHasAColumn =  false;
				if(board[column][row] != checkSign2) secondPlayerHasAColumn = false;
			}
			if( firstPlayerHasARow || secondPlayerHasARow || firstPlayerHasAColumn || secondPlayerHasAColumn )
			{
				return false;
			}

		}
		if( firstPlayerHasAMainDiag || secondPlayerHasAMainDiag || firstPlayerHasASecondDiag || secondPlayerHasASecondDiag )
		{
			return false;
		}
		return true;
	}
}
