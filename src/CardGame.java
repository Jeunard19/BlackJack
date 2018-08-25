import java.util.ArrayList;
import java.util.Collections;

public class CardGame {
	
	
	Deck newdeck = new Deck();
	ArrayList<Object> cards = newdeck.cards;
	BlackJackPlayer player = new BlackJackPlayer();
	boolean firsthand= false;
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
	
	public void showPlayershand() {
		System.out.println("Hand:");
		for(Kaart item:this.player.cards) {			
			System.out.println("-- "+item.id);
		}
	}
	
	public void dealCards() {
		boolean ace=false;
		Kaart card = (Kaart) this.cards.get(0);
		this.player.cards.add(card);
		this.cards.remove(0);
		this.player.points+=card.waarde;
		if(this.player.points>21) {
			if(card.id.contains("Ace")) {
				this.player.points-=10;
				card.waarde=1;
				showPlayershand();
				this.processPlayerInput();
			} else {
			showPlayershand();
			System.out.println("You've accumelated a score over 21 ("+this.player.points+"), you lose.");
		}}
		else if(this.player.points==21){
			System.out.println("Congrats, you win.");
		}
		
		else {
			if(this.firsthand==true) {	
				showPlayershand();
			this.processPlayerInput();
		} else {
			System.out.println("-- "+card.id);
		}	
		}
	}
	
	public void dealFirstrounds() {
		
		for(int i = 0;i<2;i++) {
			
			dealCards();
		}
		
	}
	
	public void processPlayerInput() {
		String input=this.player.produceUserInput();
		if(input!=null) {
		switch  (input) {
			case "p":
				System.out.println("You've decided too pass.\nYour score is "+this.player.points);
				System.out.println("\nStarting new game.\n");
				CardGame newgame =new CardGame();
				newgame.Displaydeck();
				newgame.dealFirstrounds();
				newgame.processPlayerInput();
			break;
			case "q":
				this.continueGame=false;
				System.exit(0);
			break;
			case "k":
				this.firsthand=true;
				dealCards();
				break;
		}} else {
			System.out.println("Hello");
		}
		
	}
	
	public void startPlayingBlackJack() {
		System.out.println("Hello there, you've started a new black jack game.\n");
		Deck newdeck = new Deck();		
		System.out.println("Here's the deck that will be used for this game:");
		Displaydeck();
		System.out.println("\n");
		System.out.println("Starting hand:");
		dealFirstrounds();
		processPlayerInput();
		System.out.println();
		
	}
	

}

