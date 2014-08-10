import java.util.ArrayList;
import java.lang.Float;

class BinarySearch {
    public static void main(String[] args) {
        try {
            ArrayList<Float> a = new ArrayList<Float>();
            a.add(new Float(1.1f));
            a.add(new Float(2.1f));
            a.add(new Float(3.1f));
            a.add(new Float(4.1f));
            a.add(new Float(5.1f));
            a.add(new Float(6.1f));
            a.add(new Float(7.1f));

            ArrayList<Float> toCheck = new ArrayList<Float>(a);
            // Negative test cases
            toCheck.add(new Float(0.5f));
            toCheck.add(new Float(2.0f));
            toCheck.add(new Float(1.5f));
            toCheck.add(new Float(6.5f));
            toCheck.add(new Float(7.5f));

            for (Float f : toCheck) {
                if (search(a, f)) {
                    System.out.println(f + " is in the list.");
                }
                else {
                    System.out.println(f + " is not in the list.");
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(
                "Pass a comma-delimited list of floats and a single float."
            );
        }
    }

    /**
     * Given a sorted array of floating-point numbers and a single 
     * floating-point number, returns whether the single number is present in 
     * the array.
     *
     * @param sortedList Ascending-order sorted list of floating-point numbers
     * @param target     Single integer to look for
     * @return           True if target is in sortedList; false otherwise
     */
    public static boolean search(ArrayList<Float> sortedList, Float target) {
        // Sanity check: if the sortedList is null or empty, assume the worst
        if (sortedList == null || sortedList.size() == 0) {
            return false;
        }

        // Otherwise, put two pointers at either end of the list. Move them 
        // as we search through the list.
        int beginIndex = 0;
        int endIndex = sortedList.size() - 1; // Last index

        // Stop when the two indices cross over - no results found.
        while (beginIndex <= endIndex) {
            // Find the item in the middle.
            int midIndex = (beginIndex + endIndex) / 2;
            if (target < sortedList.get(midIndex)) {
                // Smaller than midpoint; move the endIndex to midpoint - 1
                // (as we know it's not equal to the middle item)
                endIndex = midIndex - 1;
            }
            else if (target > sortedList.get(midIndex)) {
                // Greater than midpoint; move the beginIndex to midpoint + 1
                beginIndex = midIndex + 1;
            }
            else {
                // Must be equal to midpoint
                return true;
            }
        }

        // If the indices have crossed over, we know this item isn't found
        return false; 
    }
}
