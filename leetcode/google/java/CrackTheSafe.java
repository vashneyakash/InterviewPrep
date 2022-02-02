package google.java;

public class CrackTheSafe {
    /*
    * Possible solution:
    * 1. generate all possible codes of length n using k digits (Constraints ensure k*n <= 10^4)
    * 2. Generate 2 copies of the sequence with indices
    *   2.1 First copy should be sorted using prefix number and its length
    *   2.2 Second copy should be sorted using suffix and its length
    * 3. Retrieve sequences 1 by 1 from both the seq and merge them and delete them from seq
    * */
}
