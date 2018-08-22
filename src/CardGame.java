import java.util.ArrayList;
import java.util.Collections;

public class CardGame {
	
	
	Deck newdeck = new Deck();
	ArrayList cards = newdeck.cards;
	BlackJackPlayer player = new BlackJackPlayer();
	boolean continueGame =true;
	public void shuffleDeck() {
		Collections.shuffle(this.cards);
	}
	
	public void Displaydeck() {
		Kaart cards;
		shuffleDeck();
		for(int i=0;i < this.cards.size();i++) {
			cards=(Kaart) this.cards.get(i);
			if ( i ==51) {
				
				System.out.print(cards.id);
				

			} else {
				System.out.print(cards.id+", ");


			}
			
			
		}
	}
	public void dealCards() {
		boolean ace=false;
		Kaart card = (Kaart) this.cards.get(0);
		this.player.cards.add(card);
		this.cards.remove(0);
		this.player.points+=card.waarde;
		System.out.println(card.id);

	
	}
	
	public void dealFirstrounds() {
		
		for(int i = 0;i<2;i++) {
			
			dealCards();
		}
		
	}
	
	public void processPlayerInput() {
		
		switch  (this.player.produceUserInput()) {
			case "p":
				
			break;
			case "q":
				this.continueGame=false;
			break;
			case "k":
				dealCards();
				break;
		}
		
	}
	
	public void startPlayingBlackJack() {
		int blackjack = 21;
		//play blackjack
		
		
	}
	

}

