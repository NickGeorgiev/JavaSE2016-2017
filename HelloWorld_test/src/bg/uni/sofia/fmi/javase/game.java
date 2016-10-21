package bg.uni.sofia.fmi.javase;
import java.util.Scanner;
import java.lang.String;
public class game {
	//private boolean isPlayed;
	private char[] board;
	private char player1Sign;
	private char player2Sign;
	Scanner scanner = new Scanner(System.in);
	public game()
	{
		board = new char[]{'1','2','3','4','5','6','7','8','9'};
	}
	public void showBoard()
	{
		for(int i=0;i<9;i++)
		{
			System.out.print(board[i]+" ");
			if((i+1)%3 == 0 ) System.out.println(" ");
		}
	}
	public boolean setPosition(int position,char sign)
	{
		if(board[position] == player1Sign || board[position] == player2Sign) return false;
		board[position] = sign;
		return true;
	}
	public boolean checkBoard()
	{
		for(int row=0;row<3;row++)
		{
			if(row == 0 && (board[row] == board[row+4] && board[row]==board[row+8])) return true;
			if(board[row] == board[row+1] && board[row]==board[row+2]) return true;
			if(board[row] == board[row+3] && board[row]==board[row+6]) return true;
			
		}
		return false;
	}
	public void set1Sign()
	{
		System.out.println("Моля първият играч да си въведе скапания символ! Чакам...");
		String input = scanner.nextLine();
		player1Sign = input.charAt(0);
	}
	public void set2Sign()
	{
		System.out.println("Моля вторият играч да си въведе скапания символ! Чакам...");
		String input = scanner.nextLine();
		player2Sign = input.charAt(0);

	}
	public void play()
	{
		System.out.println("Здрасти! Ето ти я дъската!!");
		showBoard();
		set1Sign();
		set2Sign();
		int i=0;
		while(i<9){
		System.out.println("Моля първият играч да си въведе позицията, на която ще пльока знака си! Чакам...");
		String input = scanner.nextLine();
		setPosition(Integer.parseInt(input), player1Sign);

		System.out.println("Моля другият играч да си въведе позицията, на която ще пльока знака си! Чакам...");
		String input1 = scanner.nextLine();
		setPosition(Integer.parseInt(input1), player1Sign);
		System.out.println(checkBoard());
		i++;
		}
		checkBoard();
	
	}
}