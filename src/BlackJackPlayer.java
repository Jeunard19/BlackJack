import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BlackJackPlayer {
	public int chips;
	public ArrayList<Kaart> cards;
	public String [] inputoptions ={"p","q","k"};
	public int points;
	
	public String produceUserInput() {
		
		Scanner input = new Scanner(System.in);
		 if (Arrays.asList(this.inputoptions).contains(input)) {
		return input.nextLine().toLowerCase();
	} else {
		 System.out.println(input + " is not allowed to be given as an answer.");
		 return null;
	}
		
	}
	public BlackJackPlayer() {
		this.cards= new ArrayList();

	}
	


}
