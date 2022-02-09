package javax;

import java.util.Collections;

public class string {
    public static void main(String[] args) {
        // create n copies of a string or char
        System.out.println(Collections.nCopies(10, "India"));
        System.out.println(Collections.nCopies(20, "I"));

        // Concatenate multiple strings
        System.out.println(String.join(":", Collections.nCopies(10, "India")));
        System.out.println(String.join("", Collections.nCopies(20, "I")));
    }
}
