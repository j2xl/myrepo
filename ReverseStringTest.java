package homework;

import static org.junit.Assert.assertEquals;

import homework.ReverseString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Tests for {@Link ReverseString}.
 *
 * @author jason@weill.org (Jason Weill)
 */
public class ReverseStringTest {
    @Test
    public void testEmptyString() {
        String empty = new String("");
        String reversedEmpty = homework.ReverseString.reverse(empty);
        org.junit.Assert.assertEquals(
            "Failed to reverse empty string", 
            empty,
            reversedEmpty
        );
    }

    @Test
    public void testOneCharacterString() {
        String oneCharacterString = new String("c");
        String reversedString = 
            homework.ReverseString.reverse(oneCharacterString);

        // Expect that a one-character string will be identical after being
        // reversed.
        org.junit.Assert.assertEquals(
            "Failed to reverse one-character string", 
            oneCharacterString,
            reversedString
        );
    }

    @Test
    public void testEvenSizeString() {
        String evenSizeString = new String("abcd");
        String reversedEvenSizeString = new String("dcba");
        String reversedString = 
            homework.ReverseString.reverse(evenSizeString);

        org.junit.Assert.assertEquals(
            "Failed to reverse even-size string", 
            reversedEvenSizeString,
            reversedString
        );
    }

    @Test
    public void testOddSizeString() {
        String oddSizeString = new String("March");
        String reversedOddSizeString = new String("hcraM");
        String reversedString = 
            homework.ReverseString.reverse(oddSizeString);

        org.junit.Assert.assertEquals(
            "Failed to reverse odd-size string", 
            reversedOddSizeString,
            reversedString
        );
    }
}
