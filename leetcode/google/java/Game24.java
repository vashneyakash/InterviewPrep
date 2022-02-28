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

        for (List<Operators> operators : this.allPossibleOperations) {
            if (evaluateAllOperations(new ArrayList<>(operands), operators, 0)) {
                return true;
            }
        }
        return false;
    }

    private void getAllPossibleOperatorCombinations() {
        for (Operators firstOperator : Operators.values()) {
            for (Operators secondOperator : Operators.values()) {
                for (Operators thirdOperator : Operators.values()) {
                        allPossibleOperations.add(Arrays.asList(firstOperator, secondOperator, thirdOperator));
                }
            }
        }
    }

    private boolean evaluateAllOperations(List<Integer> arguments, List<Operators> operators, int operationIndex) {
        if (operationIndex > 2) return false;

//        System.out.println("arguments = " + arguments + ", operators = " + operators + ", operationIndex = " + operationIndex);
        for (int i=0; i < arguments.size(); i++) {
            for (int j=0; j<arguments.size(); j++) {
                if (i!=j) {
                    int ans = calOperation(arguments.get(i), arguments.get(j), operators.get(operationIndex));
                    int finalJ = j;
                    int finalI = i;
                    boolean res = evaluateAllOperations(IntStream
                            .range(0, arguments.size() + 1)
                            .filter(index -> index != finalI && index != finalJ)
                            .map(index -> index == arguments.size() ? ans : arguments.get(index))
                            .boxed()
                            .collect(Collectors.toList()), operators, operationIndex + 1);

                    if (res) return res;
                    if (operationIndex == 2 && (ans == 24)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    int calOperation(int a, int b, Operators operator) {
        switch (operator) {
            case plus:
                return a + b;
            case minus:
                return a - b;
            case multiply:
                return a * b;
            case divide:
                if (b == 0) {
                    return -1000;
                }
                return a / b;
            default:
                return 0;
        }
    }

    public enum Operators {
        plus, minus, divide, multiply
    }


    public static void main(String[] args) {
        Game24 game24 = new Game24(Arrays.asList(8, 1, 6, 6));
        System.out.println(game24.isGame24Possible());
    }
}
