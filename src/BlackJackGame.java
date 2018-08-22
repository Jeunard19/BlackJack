import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BlackJackGame {
	public static void main(String [] args) {
		//String d= new String(Character.toChars("\xE2\x99\xA0"));
		Deck newdeck = new Deck();
		CardGame newgame =new CardGame();
		newgame.Displaydeck();
		System.out.println();
		newgame.dealFirstrounds();
	}
	

}
