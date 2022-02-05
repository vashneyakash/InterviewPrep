package google.java;

import java.util.ArrayList;
import java.util.List;

public class CrackTheSafe {
    /*
    * Possible solution:
    * 1. generate all possible codes of length n using k digits (Constraints ensure k*n <= 10^4)
    * 2. Generate 2 copies of the sequence with indices
    *   2.1 First copy should be sorted using prefix number and its length
    *   2.2 Second copy should be sorted using suffix and its length
    * 3. Retrieve sequences 1 by 1 from both the seq and merge them and delete them from seq
    * */

    private final int passwordSize;
    private final int alphabetCount;
    private final List<String> allPossibleSequences;
    public CrackTheSafe(int passwordSize, int alphabetCount) {
        this.passwordSize = passwordSize;
        this.alphabetCount = alphabetCount;
        this.allPossibleSequences = new ArrayList<>();
        generateAllPossibleSequences(new StringBuffer());
    }

    private void generateAllPossibleSequences(StringBuffer sequence) {
        if (sequence.length() == this.passwordSize) {
            allPossibleSequences.add(sequence.toString());
        } else {
            for (int alphabet = 0; alphabet < this.alphabetCount; alphabet++) {
               sequence.append(alphabet);
               generateAllPossibleSequences(sequence);
               sequence.deleteCharAt(sequence.length() - 1);
            }
        }
    }
}
