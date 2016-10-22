package bg.uni.sofia.fmi.javase;
import java.util.Scanner;
import bg.uni.sofia.fmi.javase.Board;
import java.lang.String;
public class SeaChess {
	private char player1Sign;
	private char player2Sign;
	Scanner scanner = new Scanner(System.in);
	private Board board;
	public SeaChess()
	{
		board=new Board(3,3);
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
		System.out.println("Здрасти! Това е дъската, на която ще играете: ");
		board.showBoard();
		
		set1Sign();
		set2Sign();
		
		int i=0;
		while(i<8){
			
		board.showBoard();
		
		System.out.println("Моля първият играч да си въведе позицията, на която ще постави знака си! Чакам...");
		
		String input = scanner.nextLine();
		int pos = Integer.parseInt(input);
		
		if(pos == 3|| pos==6 || pos ==9){
			board.setPosition(pos/3-1,2, player1Sign,player1Sign,player2Sign);
		}
		else {
			board.setPosition(pos/3,pos-(pos/3)*3-1, player1Sign,player1Sign,player2Sign);
		}
		if(!board.checkBoard(player1Sign,player2Sign)){
			board.showBoard();
			System.out.println("Първият играч печели!");
			break;
		}
		
		board.showBoard();
		
		System.out.println("Моля другият играч да си въведе позицията, на която ще постави знака си! Чакам...");
		
		input = scanner.nextLine();
		pos = Integer.parseInt(input);
		
		if(pos == 3|| pos==6 || pos ==9){
			board.setPosition(pos/3-1,2, player2Sign,player1Sign,player2Sign);
		}
		else {
			board.setPosition(pos/3,pos-(pos/3)*3-1, player2Sign,player1Sign,player2Sign);
		}
		
		if(!board.checkBoard(player1Sign,player2Sign)){
			board.showBoard();
			System.out.println("Вторият играч печели!");
			break;
		}
		
		i+=2;
		}
		if(board.checkBoard(player1Sign,player2Sign)){
		board.showBoard();
		System.out.println("Никой не печели!");
		}
	
	}
}
