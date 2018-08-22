import java.util.*;

public class Deck {
	static int size=52;
	//public ArrayList kaarten = new ArrayList<String>();
	public ArrayList cards =  new ArrayList<Kaart>();
	
	
	public void createDeck() {
		Kaart card;

		String [] cardvalues = {"Jack", "Queen","King","Ace","2","3","4","5","6","7","8"
				,"9","10"};
		Integer [] cardRank = {10,10,10,11,2,3,4,5,6,7,8,9,10};
		String [] cardSymbols = {"Spades","Hearts","Diamonds","Clubs"};

		for(String i:cardvalues) {	
			for(String x:cardSymbols) {
				//this.kaarten.add(i+" of "+x);
				card=new Kaart();
				card.id=i+" of "+x;
				Arrays.asList(cardvalues).indexOf(i);
				card.waarde=Arrays.asList(cardRank).get(Arrays.
						asList(cardvalues).indexOf(i));
				this.cards.add(card);
				
				
				
			}
		}
		
	}
	public Deck() {
		this.createDeck();
	}

}
