package javax;

import debug.UsefulPrinting;

import java.util.Collections;

public class string {
    public static void main(String[] args) {
        // create n copies of a string or char
        System.out.println(Collections.nCopies(10, "India"));
        System.out.println(Collections.nCopies(20, "I"));

        // Concatenate multiple strings
        System.out.println(String.join(":", Collections.nCopies(10, "India")));
        System.out.println(String.join("", Collections.nCopies(20, "I")));

        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f'};
        System.out.println(new String(arr));
        StringBuilder a1 = new StringBuilder("i am string builder");
        System.out.println(new String(a1));

        String s = new String(arr);
        System.out.println("s.charAt(1) = " + s.charAt(1));
        System.out.println("s.contains(\"cde\") = " + s.contains("cde"));
        System.out.println("s.contains(\"ade\") = " + s.contains("ade"));
        System.out.println("s.compareToIgnoreCase(\"ABCDEF\") = " + s.compareToIgnoreCase("ABCDEF"));

        System.out.println("s.contentEquals(\"abcdef\") = " + s.contentEquals("abcdef"));
        System.out.println("s.contentEquals(new StringBuilder(\"abcdef\")) = " + s.contentEquals(new StringBuilder("abcdef")));
        s = "abcdefabcdefabcdef";
        System.out.println("s = " + s);
        System.out.println("s.indexOf('c') = " + s.indexOf('c'));
        System.out.println("s.indexOf('c', 3) = " + s.indexOf('c', 3));
        System.out.println("s.indexOf(\"abc\") = " + s.indexOf("abc"));
        System.out.println("s.indexOf(\"abc\", 3) = " + s.indexOf("abc", 3));
        System.out.println("s.isEmpty() = " + s.isEmpty());
        System.out.println("s.lastIndexOf('a') = " + s.lastIndexOf('a'));
        System.out.println("s.lastIndexOf('a', 3) = " + s.lastIndexOf('a', 3));
        System.out.println("s.lastIndexOf(\"abc\") = " + s.lastIndexOf("abc"));
        System.out.println("s.lastIndexOf(\"abc\", 3) = " + s.lastIndexOf("abc", 3));
        System.out.println("s.length() = " + s.length());

        System.out.println("------------------");
        System.out.println("------Match and replace methods------------");
        System.out.println("s = " + s);
        System.out.println("s.matches('^a') = " + s.matches("^a"));
        System.out.println("s.replace(\"abc\", \"xyz\") = " + s.replace("abc", "xyz"));
        System.out.println("s.replaceAll(\"abc\", \"xyz\") = " + s.replaceAll("abc", "xyz"));
        System.out.println("s.replaceFirst(\"abc\", \"xyz\") = " + s.replaceFirst("abc", "xyz"));

        UsefulPrinting.print1DArray(s.split("b"));
        System.out.println("s.startsWith(\"abc\") = " + s.startsWith("abc"));
        System.out.println("s.substring(1, 6) = " + s.substring(1, 6));
        System.out.println("s.toUpperCase() = " + s.toUpperCase());

        System.out.println("String.valueOf(10) = " + String.valueOf(10));
        System.out.println("String.valueOf(10.56) = " + String.valueOf(10.56));
        System.out.println("String.valueOf('c') = " + String.valueOf('c'));

    }
}
