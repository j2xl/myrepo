import java.util.ArrayList;
import java.lang.Float;

class BinarySearch {
    public static void main(String[] args) {
        try {
            ArrayList<Float> sortedList = new ArrayList<Float>();
            String[] rawList = args[0].split(",");
            for (String rawItem : rawList) {
                sortedList.add(Float.parseFloat(rawItem));
            }
            Float target = Float.parseFloat(args[1]);
            if(listContainsItem(sortedList, target)) {
                System.out.println(
                    "Found " + target + " in list " + args[0]
                );
            }
            else {
                System.out.println(
                    "Did not find " + target + " in list " + args[0]
                );
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
    public static boolean listContainsItem(
        ArrayList<Float> sortedList, 
        Float target
    ) {
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
