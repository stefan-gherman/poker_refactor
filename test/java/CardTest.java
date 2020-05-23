import com.codecool.customexception.IllegalInputException;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CardTest {

    @Test
    public void testCardThrowsIllegalArgumentExceptionOnUnsuitableSymbol() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Card("I4");
        });
    }

    @Test
    public void testCardThrowsIllegalArgumentExceptionOnUnsuitableRankBiggerThanMax() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Card("S45");
        });
    }

    @Test
    public void testCardThrowsIllegalArgumentExceptionOnUnsuitableRankSmallerThanMin() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Card("S1");
        });
    }

    @Test
    public void testCardThrowsIllegalArgumentExceptionOnRankNotNumber() {
        assertThrows(NumberFormatException.class, () -> {
            new Card("H-");
        });
    }

    @Test
    public void testCardThrowsIllegalInputExceptionOnCardCodeLargerThanTwoChars() {
        assertThrows(IllegalInputException.class, () -> {
            new Card("H34353");
        });
    }

    @Test
    public void testCardThrowsIllegalArgumentExceptionOnEmptyRank() {
        assertThrows(IllegalInputException.class, () -> {
            new Card("H");
        });
    }

    @Test
    public void testCardThrowsIllegalArgumentExceptionOnEmptySymbol() {
        assertThrows(IllegalInputException.class, () -> {
            new Card("4");
        });
    }

    @Test
    public void testCardThrowsIllegalInputExceptionOnEmptyStringSpace() {
        assertThrows(IllegalInputException.class, () -> {
            new Card(" ");
        });
    }

    @Test
    public void testCardThrowsIllegalInputExceptionOnEmptyString() {
        assertThrows(IllegalInputException.class, () -> {
            new Card("");
        });
    }
}
