package google.java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        getAllPossibleOperatorCombinations();



        return false;
    }

    private void getAllPossibleOperatorCombinations() {
        for (Operators firstOperator : Operators.values()) {
            for (Operators secondOperator : Operators.values()) {
                for (Operators thirdOperator : Operators.values()) {
                    for (Operators forthOperator : Operators.values()) {
                        allPossibleOperations.add(Arrays.asList(firstOperator, secondOperator, thirdOperator, forthOperator));
                    }
                }
            }
        }
    }

    private void evaluateAllOperations(List<Integer> arguments, List<Operators> operators, int operationIndex) {
        for (int i=0; i<arguments.size(); i++) {
            for (int j=0; j<arguments.size(); j++) {
                if (i!=j) {
                    int ans = calOperation(arguments.get(i), arguments.get(j), operators.get(operationIndex));
                    evaluateAllOperations(IntStream
                            .range(0, arguments.size())
                            .filter(index -> index != i && index != j)
                            .map(arguments::get)
                            .collect(Collectors.toList()), operators, operationIndex++);
);
                }
            }
        }
    }

    int calOperation(int a, int b, Operators operator) {
        switch (operator) {
            case plus -> {
                return a + b;
            }
            case minus -> {
                return a - b;
            }
            case multiply -> {
                return a * b;
            }
            case divide -> {
                return a / b;
            }
        }
        return 0;
    }

    public enum Operators {
        plus, minus, divide, multiply
    }
}
