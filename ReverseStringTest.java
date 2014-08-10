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
        String reversedEmpty = homework.ReverseString.reverseString(empty);
        org.junit.Assert.assertEquals(
            "Failed to reverse empty string", 
            empty,
            reversedEmpty
        );
    }
}
