import com.codecool.customexception.IllegalInputException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {

    String cardCode;
    private final int MAX_LENGTH = 3;
    private final int MIN_LENGTH = 2;

    /**
     * Enum containing all the possible symbols
     */
    private enum Symbol {
        S,
        C,
        D,
        H
    }


    /**
     * Map with all the values of cards that are letters.
     */
    private Map<String, Integer> alphabeticCardValue = Stream.of( new Object[][] {
        {"J", 11},{"Q", 12},{"K", 13},{"A", 14},
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));


    public Card(String cardCode) throws IllegalArgumentException, IllegalInputException {
        this.cardCode = cardCode.strip();
        int symbolCheck = 0;
        if(this.cardCode.length() > MAX_LENGTH || this.cardCode.length() < MIN_LENGTH) {
            throw new IllegalInputException("Input is unsuitable for this operation, max length is 2.");
        }

        String cardColor = this.cardCode.substring(0, 1).toUpperCase();

        /**
         * Removing If statement and iterating through enum values
         */
       for (Symbol symbol : Symbol.values()) {
           if(symbol.name().equals(cardColor)) {
               break;
           } else{
               symbolCheck += 1;
           }
       }
       if(symbolCheck >= Symbol.values().length) {
           throw new IllegalArgumentException();
       }

        String cardValue;
       try
       {
           cardValue = cardCode.substring(1).toUpperCase();
       } catch (IndexOutOfBoundsException e){
           throw new IndexOutOfBoundsException();
       }
        int intCardValue;



        if (alphabeticCardValue.get(cardCode.substring(1).toUpperCase()) == null) {
            // raises exception if cardValue is a letter, but not J/Q/K/A
            try {
                intCardValue = Integer.parseInt(cardValue);
                if (intCardValue > 10) {
                    throw new IllegalArgumentException("card number isn't valid: " + intCardValue);
                }
                if (intCardValue < 2) {
                    throw new IllegalArgumentException("card number isn't valid: " + intCardValue);
                }
            } catch (NumberFormatException e) {
                throw new NumberFormatException();
            }

        }
    }

    public int getValue() {
        String cardValue = cardCode.substring(1).toUpperCase();
        int intCardValue;

        if (alphabeticCardValue.get(cardValue) == null) {
            intCardValue = Integer.parseInt(cardValue);
        } else {
            intCardValue = alphabeticCardValue.get(cardValue);
        }

        return intCardValue;
    }
}
