package linkdein;

import java.util.function.Predicate;

public class ZigZag {

    public static String compute(String input, int numberOfRows) {
        if (numberOfRows == 1) {
            return input;
        }

        Predicate<Integer> isFirstOrLastCharacter = rowNumber -> rowNumber == 0 || rowNumber == (numberOfRows - 1);

        for (int i = 0; i < numberOfRows; i++) {
            if (isFirstOrLastCharacter.test(i)) {

            }
        }

    }

    public static void main(String[] args) {

    }
}
