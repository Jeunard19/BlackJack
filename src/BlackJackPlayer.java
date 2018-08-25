import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BlackJackPlayer {
	public int chips;
	public ArrayList<Kaart> cards;
	public String [] inputoptions ={"p","q","k"};
	public int points;
	
	public String produceUserInput() {
		
		System.out.println("\n");
		System.out.print("Input: ");
		Scanner scanner = new Scanner(System.in);
		String input=scanner.nextLine();
		 if (Arrays.asList(this.inputoptions).contains(input)) {
		return input
				.toLowerCase();
	} else {
		 System.out.println(input + " is not a valid input.\nTry again. (Valid inputs are: q - quit game, k - startgame/keep playing"
		 		+ " and p - pass.)");
		 return "q";
	}
		
	}
	public BlackJackPlayer() {
		this.cards= new ArrayList();
		

	}
	


}
