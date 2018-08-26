import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BlackJackPlayer {
	public ArrayList<Card> cards;

	public int points;
	
	public String produceUserInput() {
		
		System.out.println("\n");
		System.out.print("Input: ");
		Scanner scanner = new Scanner(System.in);
		String input=scanner.nextLine();
		return input;	
	}
	
	
	public BlackJackPlayer() {
		this.cards= new ArrayList();
	}
}
