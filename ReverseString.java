/**
 * Given a string, reverses the string and prints the reverse.
 * For example, "Hello" becomes "olleH".
 */
import java.lang.String;

class ReverseString {
    public static void main(String[] args) {
        try {
            System.out.println(reverseString(args[0]));
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Pass a single parameter: a string to reverse.");
        }
    }

    /**
     * Given a string, return another string with the characters reversed.
     * For example, "Hello" becomes "olleH".
     * 
     * @param s The string to be reversed.
     * @return  The string with characters reversed.
     */
    private static String reverseString(String s) {
        // If we are working on a null string, we don't need to do anything.
        if (s == null) {
            return s; // Reversing null is null
        }

        /* Reverse pairs of characters at opposite ends of the input string.
         * For example, in "Hello", first reverse the 'H' and 'o', then the 
         * 'e' and the second 'l'.
         */
        int stringLength = s.length();
        // If we are working on an empty or one-character string, we don't
        // need to do anything.
        if (stringLength <= 1) {
            return s;
        }

        // Operate on the characters in the string.
        char[] charArray = s.toCharArray();

        // Go halfway into the string. If there's an odd number of characters, 
        // leave the one in the middle unchanged.
        for (int i = 0; i < stringLength / 2; i++) {
            // Swap the character at this point with the one an equal number 
            // of characters away from the center on the other side.
            char firstChar = charArray[i];
            charArray[i] = charArray[stringLength - i - 1];
            charArray[stringLength - i - 1] = firstChar;
        }

        // Convert the charArray to a String; return it.
        return new String(charArray);
    }
}
