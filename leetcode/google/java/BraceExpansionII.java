package google.java;

import java.util.ArrayList;
import java.util.List;

public class BraceExpansionII {
    /*
    * Question - https://leetcode.com/problems/brace-expansion-ii/
    * Approach 1:
    * 1. Recursively Divide expr into sub expr and store the operator also
    * 2. Start joining the expr together
    * 3. Output final result
    *
    * */

    public BraceExpansionII(String expression) {
    }

    List<String> evaluateExpr(String expression) {
        List<String> subExpr = getAllSubExpr(expression);
    }

    private List<String> getAllSubExpr(String expression) {
        if (canSeparateByComma(expression)) {
            return separateByComma(expression);
        } else {
            return separateByBracket(expression);
        }
    }

    private boolean canSeparateByComma(String expression) {
        int openBrackets = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '{') openBrackets++;
            else if (expression.charAt(i) == '}') openBrackets++;
            else if (expression.charAt(i) == ',' && openBrackets == 0) return true;
        }
        return false;
    }

    private List<String> separateByComma(String expression) {
        int openBrackets = 0;
        int expressionStart = 0;
        List<String> subExpressions = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '{') openBrackets++;
            else if (expression.charAt(i) == '}') openBrackets++;
            else if (expression.charAt(i) == ',' && openBrackets == 0) {
                subExpressions.add(expression.substring(expressionStart, i - 1));
                expressionStart = i + 1;
            }
        }
        subExpressions.add(expression.substring(expressionStart, expression.length() - 1));
        return subExpressions;
    }
}

    private List<String> separateByBracket(String expression) {
        int openBrackets = 0;
        int expressionStart = 0;
        List<String> subExpressions = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '{') {
                openBrackets++;
            } else if (expression.charAt(i) == '}') openBrackets++;
            else if (expression.charAt(i) == ',' && openBrackets == 0) {
                subExpressions.add(expression.substring(expressionStart, i - 1));
                expressionStart = i + 1;
            }
        }
        subExpressions.add(expression.substring(expressionStart, expression.length() - 1));
        return subExpressions;
    }
}
