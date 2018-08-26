import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class CardGame {
	Deck newdeck = new Deck();
	ArrayList<Object> cards = newdeck.cards;
	ArrayList<String> aceslist = new ArrayList();
	BlackJackPlayer player = new BlackJackPlayer();
	boolean firsthand= false;
	boolean continueGame =true;
	int seconds = LocalDateTime.now().getSecond();
	public void shuffleDeck() {
		Collections.shuffle(this.cards);
	}
	
	public void Displaydeck() {
		Card cards;
		shuffleDeck();
		for(int i=0;i < this.cards.size();i++) {
			cards=(Card) this.cards.get(i);
			if ( i ==51) {			
				System.out.print(cards.id);
			} else {
				System.out.print(cards.id+", ");
			}			
		}
	}
	
	public void showPlayershand() {
		System.out.println("Hand:");
		for(Card item:this.player.cards) {			
			System.out.println("-- "+item.id);
		}
	}
	
	public void dealCards() {
		Card card = (Card) this.cards.get(0);
		this.player.cards.add(card);
		this.cards.remove(0);
		this.player.points+=card.value;
		if(this.player.points>21) {
			boolean Ace=false;
				if(card.id.contains("Ace")&!this.aceslist.contains(card.id)) {
					card.value=1;
					Ace = true;
					this.aceslist.add(card.id);
					}
			
			if(Ace==false) {
			showPlayershand();
			System.out.println("You've accumulated a score over 21 ("+this.player.points+"), you lose.");
			System.exit(0);
			} else {
				this.player.points-=10;
				Ace=false;
			;
			    System.out.println("\nNew card: ");
				System.out.println("-- "+card.id);
				System.out.println("\nScore: "+this.player.points);
				processPlayerInput();
			}
			
			}
		else if(this.player.points==21){
			if(this.firsthand==false) {
				System.out.println("-- "+card.id);
				System.out.println("Congrats, you win.");
				System.out.println("\nScore: "+this.player.points);
				System.exit(0);
			} else {
			showPlayershand();
			System.out.println("\nScore: "+this.player.points);
			System.out.println("Congrats, you win.");
			System.exit(0);
			}
		}
		
		else {
			if(this.firsthand==true) {	
				System.out.println("\nNew card: ");
				System.out.println("-- "+card.id);
				System.out.println("\nScore: "+this.player.points);
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
		System.out.println("\nScore: "+this.player.points);
	}
	
	public void processPlayerInput() {
		String input=this.player.produceUserInput();
		if( LocalDateTime.now().getSecond()>this.seconds+10) {
			System.out.println("You have been kicked for idling.");
			System.exit(0);
		}
	

		switch  (input.toLowerCase()) {
			default:
				 System.out.println("This is not a valid input.\nTry again. (Valid inputs are: q - quit game, k - startgame/keep playing"
					 		+ " and p - pass.)");
				 this.seconds=LocalDateTime.now().getSecond();
				processPlayerInput();
				break;
			case "p":
				System.out.println("You've decided too pass.\nYour score is "+this.player.points);

				showPlayershand();
			break;
			case "q":
				this.continueGame=false;
				System.out.println("\nGoodbye");
				System.exit(0);
			break;
			case "k":
				this.firsthand=true;
				this.seconds=LocalDateTime.now().getSecond();
				dealCards();
				 
				break;
		}} 
		
	
	
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

