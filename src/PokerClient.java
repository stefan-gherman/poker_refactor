import com.codecool.customexception.IllegalInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokerClient {

    private final int HAND_SIZE = 5;
    private Card[] cardsInHand = new Card[HAND_SIZE];

    public PokerClient(String cards) throws IllegalInputException {
        if(cards.length() == 0) {
            throw new IllegalInputException("Invalid Empty String");
        }

        String[] cardsSplitFromInput = cards.split("\\s+");

        if(cardsSplitFromInput.length != HAND_SIZE) {
            throw new IllegalInputException(String.format("Unsuitable number of cards number must be equal to {}", HAND_SIZE));
        }
        for( int counter = 0 ; counter < HAND_SIZE; counter ++) {
            cardsInHand[counter] = new Card(cardsSplitFromInput[counter]);
        }
    }


    public boolean highestCardIsMine(String opponentHand) throws IllegalInputException {

        if (opponentHand.length() == 0) {
            throw new IllegalInputException("Invalid Empty String");
        }
        String[] opponentCardsFromSplit = opponentHand.split("\\s+");

        if(opponentCardsFromSplit.length != HAND_SIZE) {
            throw new IllegalInputException(String.format("Unsuitable number of cards number must be equal to {}", HAND_SIZE));
        }
        List<Card> opponentCards = new ArrayList();
        List<Card> myCards = new ArrayList();
        for(int counter =0 ;counter < HAND_SIZE; counter ++) {
            opponentCards.add(new Card(opponentCardsFromSplit[counter]));
        }
        myCards.addAll(Arrays.asList(cardsInHand));
        Card highestCard=myCards.get(0);

        for (int counter = 0; counter < HAND_SIZE; counter++) {
            if(myCards.get(counter).getValue() > opponentCards.get(counter).getValue()) {
               if(highestCard.getValue() < myCards.get(counter).getValue()) {
                   highestCard = myCards.get(counter);
               }
            } else {
                if(highestCard.getValue() < myCards.get(counter).getValue()) {
                    highestCard = opponentCards.get(counter);
                }
            }

        }

        return myCards.contains(highestCard);
    }

}