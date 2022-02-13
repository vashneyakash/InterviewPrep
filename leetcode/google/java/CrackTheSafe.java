package google.java;

import java.util.*;

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
    private final int allPossiblePasswordCount;
    public CrackTheSafe(int passwordSize, int alphabetCount) {
        this.passwordSize = passwordSize;
        this.alphabetCount = alphabetCount;
        this.allPossiblePasswordCount = (int) Math.pow(alphabetCount, passwordSize);

    }

    public String generatePassword() {
        Set<String> visitedPasswords = new HashSet<>();
        String startingPassword = String.join("", Collections.nCopies(passwordSize, "0"));
        StringBuffer password = new StringBuffer();
        visitedPasswords.add(startingPassword);
        tryAllCombinations(password, visitedPasswords);
        return password.toString();
    }

    private boolean tryAllCombinations(StringBuffer currentPassword, Set<String> visitedPasswords) {
        if (visitedPasswords.size() == allPossiblePasswordCount) {
            return true;
        }
        StringBuilder lastPassword_N_MinusOneDigits = new StringBuilder(currentPassword.substring(currentPassword.length() - passwordSize + 1, currentPassword.length()));
        for (int alphabet = 0; alphabet < this.alphabetCount; alphabet++) {
            lastPassword_N_MinusOneDigits.append(alphabet);
            if (!visitedPasswords.contains(lastPassword_N_MinusOneDigits.toString())) {
                visitedPasswords.add(lastPassword_N_MinusOneDigits.toString());
                currentPassword.append(alphabet);
                if (tryAllCombinations(currentPassword, visitedPasswords)) {
                    return true;
                } else {
                    visitedPasswords.remove(lastPassword_N_MinusOneDigits.toString());
                    currentPassword.deleteCharAt(currentPassword.length() - 1);
                }
            }
            lastPassword_N_MinusOneDigits.deleteCharAt(passwordSize - 1);
        }
        return false;
    }
}
