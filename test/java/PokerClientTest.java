import com.codecool.customexception.IllegalInputException;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PokerClientTest {

    @Test
    public void testPokerClientThrowsIllegalInputException() {
        assertThrows(IllegalInputException.class, () -> {
           new PokerClient("s3 s3 s123 s2 hj");
        });
    }

    @Test
    public void testPokerClientThrowsINumberFormatException() {
        assertThrows(NumberFormatException.class, () -> {
            new PokerClient("s3 s3 s- s2 hj");
        });
    }

    @Test
    public void testPokerClientThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PokerClient("s3 s3 l3 s2 hj");
        });
    }

    @Test
    public void testPokerClientThrowsIllegalInputExceptionOnNullString() {
        assertThrows(IllegalInputException.class, () -> {
            new PokerClient("");
        });
    }

    @Test
    public void testPokerClientThrowsIllegalInputExceptiononSpaceString() {
        assertThrows(IllegalInputException.class, () -> {
            new PokerClient(" ");
        });
    }

    @Test
    public void testHighestCardIsMineThrowsIllegalInputException() {
        assertThrows(IllegalInputException.class, () -> {
            PokerClient pokerClient = new PokerClient("s3 s3 s3 s2 s2");
            pokerClient.highestCardIsMine("s3 s3 s123 s2 hj");
        });
    }

    @Test
    public void testHighestCardIsMineThrowsINumberFormatException() {
        assertThrows(NumberFormatException.class, () -> {
            PokerClient pokerClient = new PokerClient("s3 s3 s3 s2 s2");
            pokerClient.highestCardIsMine("s3 s3 s- s2 hj");
        });
    }

    @Test
    public void testHighestCardIsMineThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            PokerClient pokerClient = new PokerClient("s3 s3 s3 s2 s2");
            pokerClient.highestCardIsMine("s3 s3 l3 s2 hj");
        });
    }

    @Test
    public void testHighestCardIsMineThrowsIllegalInputExceptionOnNullString() {
        assertThrows(IllegalInputException.class, () -> {
            PokerClient pokerClient = new PokerClient("s3 s3 s3 s2 s2");
            pokerClient.highestCardIsMine("");
        });
    }

    @Test
    public void testHighestCardIsMineThrowsIllegalInputExceptiononSpaceString() {
        assertThrows(IllegalInputException.class, () -> {
            PokerClient pokerClient = new PokerClient("s3 s3 s3 s2 s2");
            pokerClient.highestCardIsMine(" ");
        });
    }

    @Test
    public void testHighestCardGivesCorrectResultAssertion1() throws IllegalInputException {
        boolean expectedResult = true;
        PokerClient pokerClient = new PokerClient("h3 d2  s3 s4 cq");

        assertEquals(expectedResult, pokerClient.highestCardIsMine("s3 h4 s5 d6 sj"));
    }

    @Test
    public void testHighestCardGivesCorrectResultAssertion2() throws IllegalInputException {
        boolean expectedResult = false;
        PokerClient pokerClient = new PokerClient("h3 d2  s3 s4 cq");

        assertEquals(expectedResult,  pokerClient.highestCardIsMine("s3 h4 s5 d6 sk"));
    }
}
