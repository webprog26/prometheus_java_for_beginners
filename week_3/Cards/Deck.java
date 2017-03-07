/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thirdweektask.playing_cards;

import java.util.Random;

/**
 *
 * @author webpr
 */
public class Deck {
    
    private static final int TOTAL_COUNT = 36;// number of cards
    private int drawedCount = 0;// variable to store drawed cards
    private Card[] mCards = getCards();//array of cards
 
       
    public void shuffle(){
      Random rnd = new Random();
	for (int i = TOTAL_COUNT - 1; i > 0; i--) {
		int index = rnd.nextInt(i + 1);
		Card temp = new Card(mCards[index].getRank(), mCards[index].getSuit());
		mCards[index].setRank(mCards[i].getRank());
                mCards[index].setSuit(mCards[i].getSuit());
		mCards[i].setRank(temp.getRank());
                mCards[i].setSuit(temp.getSuit());
	}
    }
    
    public void order(){
         this.mCards = getCards();
    }
    
    public boolean hasNext(){
        return drawedCount < TOTAL_COUNT;
    }
    
    public Card drawOne(){
        if(!hasNext()){
            return null;
        }
        drawedCount++;
        return this.mCards[TOTAL_COUNT - drawedCount];
    } 
    
    private Card[] getCards(){
        Card[] cards = new Card[TOTAL_COUNT];
        int cardIndex = 0;
        for(int i = 0; i < Suit.values.length; i++){
            for(int j = 0; j < Rank.values.length; j++){
                cards[cardIndex] = new Card(Rank.values[j], Suit.values[i]);  
                cardIndex++;
            }
        }
        return cards;
    }
   
}
