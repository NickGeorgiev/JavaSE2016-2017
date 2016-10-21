package bg.uni.sofia.fmi.javase;
import java.util.Scanner;
import java.lang.String;
public class game {
	private char[][] board;
	private char player1Sign;
	private char player2Sign;
	Scanner scanner = new Scanner(System.in);
	public game()
	{
		board = new char[][]{
			{'1','2','3'},
			{'4','5','6'},
			{'7','8','9'}
		};
	}
	public void showBoard()
	{
		for(int row=0;row<3;row++)
		{
			for(int column=0;column<3;column++)
			{
				if(column==2)System.out.println(board[row][column]);
				else System.out.print(board[row][column]+" | ");
			}
			if(row != 2) System.out.println("-   -   -   ");
		}
	}
	public boolean setPosition(int rowPos,int colPos,char sign)
	{
		if(board[rowPos][colPos] == player1Sign || board[rowPos][colPos] == player2Sign) return false;
		board[rowPos][colPos] = sign;
		return true;
	}
	public boolean checkBoard()
	{
		//checking main diagonal
		boolean firstPlayerWins = true;
		boolean secondPlayerWins = true;
		for(int row=0;row<3;row++)
		{
					if(board[row][row] != player1Sign) firstPlayerWins = false;
					if(board[row][row] != player1Sign) secondPlayerWins = false;
		}
		if(firstPlayerWins)
		{
			System.out.println("Първият играч печели!");
			return false;
		}
		if(secondPlayerWins)
		{
			System.out.println("Вторият играч печели!");
			return false;
		}
		
		//checking second diagonal
		firstPlayerWins = true;
		secondPlayerWins = true;
		for(int row=0;row<3;row++)
		{
					if(board[row][2-row] != player1Sign) firstPlayerWins = false;
					if(board[row][2-row] != player1Sign) secondPlayerWins = false;
		}
		if(firstPlayerWins)
		{
			System.out.println("Първият играч печели!");
			return false;
		}
		if(secondPlayerWins)
		{
			System.out.println("Вторият играч печели!");
			return false;
		}
		//checking row and column
		firstPlayerWins = true;
		secondPlayerWins = true;
		for(int row=0;row<3;row++)
		{
			for(int column=row;column<3;column++)
			{
					if(board[row][column] != player1Sign) firstPlayerWins = false;
					if(board[row][column] != player1Sign) secondPlayerWins = false;
					if(board[column][row] != player1Sign) firstPlayerWins = false;
					if(board[column][row] != player1Sign) secondPlayerWins = false;
			}
		}
		if(firstPlayerWins)
		{
			System.out.println("Първият играч печели!");
			return false;
		}
		if(secondPlayerWins)
		{
			System.out.println("Вторият играч печели!");
			return false;
		}
		return true;
	}
	public void set1Sign()
	{
		System.out.println("Моля първият играч да си въведе пльоканката! Чакам...");
		String input = scanner.nextLine();
		player1Sign = input.charAt(0);
	}
	public void set2Sign()
	{
		System.out.println("Моля вторият играч да си въведе пльоканката! Чакам...");
		String input = scanner.nextLine();
		player2Sign = input.charAt(0);

	}
	public void play()
	{
		System.out.println("Здрастии! Ето ти я дъската!!");
		showBoard();
		set1Sign();
		set2Sign();
		int i=0;
		while(i<8){
		showBoard();
		System.out.println("Моля първият играч да си въведе позицията, на която ще пльока знака си! Чакам...");
		String input = scanner.nextLine();
		int pos = Integer.parseInt(input);
		if(pos == 3|| pos==6 || pos ==9){
			setPosition(pos/3-1,2, player1Sign);
		}
		else {
			setPosition(pos/3,pos-(pos/3)*3-1, player1Sign);
		}
		if(!checkBoard()){
			showBoard();
			break;
		}
		showBoard();
		System.out.println("Моля другият играч да си въведе позицията, на която ще пльока знака си! Чакам...");
		input = scanner.nextLine();
		pos = Integer.parseInt(input);
		if(pos == 3|| pos==6 || pos ==9){
			setPosition(pos/3-1,2, player2Sign);
		}
		else {
			setPosition(pos/3,pos-(pos/3)*3-1, player2Sign);
		}
		if(!checkBoard()){
			showBoard();
			break;
		}
		i+=2;
		}
		showBoard();
		System.out.println("Никой не печели!");
	
	}
}