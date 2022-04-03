package google.java;

public class StringTransformsIntoAnotherString {
    /*
    * if the input string has all 26 letters then answer will be no as we cannot transform letters without side effect
    * Eg: aabbcc to ccbbaa and we can use only a,b,c
    * Then if (a -> c and c -> a) we can never produce the correct output string
    *
    * Alternate, create a directed graph for transformations from input to output string
    * If the graph contains a cycle then no solution exists
    * */
}
