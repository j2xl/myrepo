package homework;

import java.util.ArrayList;
import java.lang.Float;

import static org.junit.Assert.assertEquals;

import homework.BinarySearch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Assert;

/**
 * Tests for {@Link BinarySearch}.
 *
 * @author jason@weill.org (Jason Weill)
 */
public class BinarySearchTest {
    // Trivial cases: check an empty or a null array.
    @Test
    public void testEmptyArrayList() {
        ArrayList<Float> myList = new ArrayList<Float>();
        Float myFloat = new Float(1.0f);

        org.junit.Assert.assertFalse(
            "Failed to test empty array - search should return false",
            BinarySearch.listContainsItem(myList, myFloat)
        );
    }

    @Test
    public void testNullArrayList() {
        Float myFloat = new Float(1.0f);

        org.junit.Assert.assertFalse(
            "Failed to test null array - search should return false",
            BinarySearch.listContainsItem(null, myFloat)
        );
    }

    // Trivial cases: Test one-element lists with a value in or not in the list
    @Test
    public void testOneElementInArrayList() {
        ArrayList<Float> myList = new ArrayList<Float>();
        myList.add(new Float(1.0f));
        Float myFloat = new Float(1.0f);

        org.junit.Assert.assertTrue(
            "Failed to test one-element array - search should return true",
            BinarySearch.listContainsItem(myList, myFloat)
        );
    }

    @Test
    public void testOneElementNotInArrayList() {
        ArrayList<Float> myList = new ArrayList<Float>();
        myList.add(new Float(2.0f));
        Float myFloat = new Float(1.0f);

        org.junit.Assert.assertFalse(
            "Failed to test one-element array - search should return false",
            BinarySearch.listContainsItem(myList, myFloat)
        );
    }

    /* Given a multi-element list, look for values:
     * 1. Before the beginning of the list
     * 2. At the beginning of the list
     * 3. Between two elements of the list
     * 4. At the center of the list
     * 5. At the end of the list
     * 6. After the end of the list
     * 7. Which are null
     *
     * Searches 1, 3, 6, and 7 should fail. Searches 2, 4, and 5 should pass.
     */
    private ArrayList<Float> multiElementList() {
        ArrayList<Float> myList = new ArrayList<Float>();
        for (float f = 1.0f; f <= 7.0f; f += 1.0f) {
            myList.add(new Float(f));
        }

        return myList;
    }

    @Test
    public void testBeforeBeginningOfList() {
        ArrayList<Float> myList = multiElementList();
        Float myFloat = new Float(0.5f);

        org.junit.Assert.assertFalse(
            "Failed to test multi-element array by searching for element " 
          + "before beginning of list - search should return false",
            BinarySearch.listContainsItem(myList, myFloat)
        );
    }

    @Test
    public void testAtBeginningOfList() {
        ArrayList<Float> myList = multiElementList();
        Float myFloat = new Float(1.0f);

        org.junit.Assert.assertTrue(
            "Failed to test multi-element array by searching for element " 
          + "at beginning of list - search should return true",
            BinarySearch.listContainsItem(myList, myFloat)
        );
    }

    @Test
    public void testBetweenElementsOfList() {
        ArrayList<Float> myList = multiElementList();
        Float myFloat = new Float(2.5f);

        org.junit.Assert.assertFalse(
            "Failed to test multi-element array by searching for element " 
          + "between two elements of list - search should return false",
            BinarySearch.listContainsItem(myList, myFloat)
        );
    }

    @Test
    public void testAtCenterOfList() {
        ArrayList<Float> myList = multiElementList();
        Float myFloat = new Float(4.0f);

        org.junit.Assert.assertTrue(
            "Failed to test multi-element array by searching for element " 
          + "at center of list - search should return true",
            BinarySearch.listContainsItem(myList, myFloat)
        );
    }

    @Test
    public void testAtEndOfList() {
        ArrayList<Float> myList = multiElementList();
        Float myFloat = new Float(7.0f);

        org.junit.Assert.assertTrue(
            "Failed to test multi-element array by searching for element " 
          + "at end of list - search should return true",
            BinarySearch.listContainsItem(myList, myFloat)
        );
    }

    @Test
    public void testAfterEndOfList() {
        ArrayList<Float> myList = multiElementList();
        Float myFloat = new Float(9.7f);

        org.junit.Assert.assertFalse(
            "Failed to test multi-element array by searching for element " 
          + "after end of list - search should return false",
            BinarySearch.listContainsItem(myList, myFloat)
        );
    }

    @Test
    public void testNullValueInList() {
        ArrayList<Float> myList = multiElementList();

        org.junit.Assert.assertFalse(
            "Failed to test multi-element array by searching for null " 
          + "element - search should return false",
            BinarySearch.listContainsItem(myList, null)
        );
    }
}
