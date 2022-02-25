package google.java;

import java.util.*;

public class Game24 {
    /*
    * there can be only 3 operations between 4 elements
    * We are only allowed +, - , *, /. Hence total combinations 4 * 4 * 4 = 64 combinations
    * For each operation we can choose any 2 number and order matters
    * Hence for first selection 4P2 = 4!/2! = 12,
    * Second selection 3P2 = 3!/1! = 6,
    * Third Selection 2P2 = 2
    * Total combinations = 64 * 12 * 6 * 2 = 9K
    * */
    private final List<Integer> operands;
    private final List<List<Operators>> allPossibleOperations;
    public Game24(List<Integer> operands) {
        this.operands = operands;
        this.allPossibleOperations = new ArrayList<>();
    }

    public boolean isGame24Possible() {
        for (Operators firstOperator : Operators.values()) {
            for (Operators secondOperator : Operators.values()) {
                for (Operators thirdOperator : Operators.values()) {
                    for (Operators forthOperator : Operators.values()) {
                        allPossibleOperations.add(Arrays.asList(firstOperator, secondOperator, thirdOperator, forthOperator));
                    }
                }
            }
        }

        return false;
    }

    public enum Operators {
        plus, minus, divide, multiply
    }
}
