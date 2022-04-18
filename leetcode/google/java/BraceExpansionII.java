package google.java;

import java.util.*;
import java.util.stream.Collectors;

public class BraceExpansionII {
    /*
    * Question - https://leetcode.com/problems/brace-expansion-ii/
    * Approach 1:
    * 1. Recursively Divide expr into sub expr and store the operator also
    * 2. Start joining the expr together
    * 3. Output final result
    *
    * */

    public BraceExpansionII() {
    }

    List<String> evaluateExpr(String expression) {
        if (isAtomicExpression(expression)) {
            return Arrays.asList(expression);
        }
        List<Expression> subExpr = getAllSubExpr(expression);

        List<SubExpressions> subSubExpressions = new ArrayList<>();
        for(Expression expr: subExpr) {
            List<String> subSubExpr = evaluateExpr(expr.expr());
            subSubExpressions.add(new SubExpressions(subSubExpr, expr.operator()));
        }

        return subSubExpressions.stream().reduce((a,b) -> {
            List<String> result  = new ArrayList<>();
            if (Operator.cartesian.equals(a.operator())) {
                for (String e1: a.subExpr()) {
                    for (String e2: b.subExpr()) {
                        result.add(e1 + e2);
                    }
                }
            } else {
                result.addAll(a.subExpr());
                result.addAll(b.subExpr());
            }
            return new SubExpressions(result, b.operator());
        }).orElseThrow(() -> new RuntimeException("Invalid expression"))
                .subExpr();
    }

    private List<Expression> getAllSubExpr(String expression) {
        if (canSeparateByComma(expression)) {
            return separateByComma(expression);
        } else {
            return separateByBracket(expression);
        }
    }

    boolean isAtomicExpression(String expression) {
        return !(expression.contains(",") || expression.contains("{"));
    }

    private boolean canSeparateByComma(String expression) {
        int openBrackets = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '{') openBrackets++;
            else if (expression.charAt(i) == '}') openBrackets--;
            else if (expression.charAt(i) == ',' && openBrackets == 0) return true;
        }
        return false;
    }

    private List<Expression> separateByComma(String expression) {
        int openBrackets = 0;
        int expressionStart = 0;
        List<Expression> subExpressions = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '{') openBrackets++;
            else if (expression.charAt(i) == '}') openBrackets--;
            else if (expression.charAt(i) == ',' && openBrackets == 0) {
                subExpressions.add(new Expression(expression.substring(expressionStart, i), Operator.union));
                expressionStart = i + 1;
            }
        }
        if (expressionStart != expression.length()) {
            subExpressions.add(new Expression(expression.substring(expressionStart, expression.length()), Operator.union));
        }
        return subExpressions;
    }

    private List<Expression> separateByBracket(String expression) {
        if (hasWrapperBraces(expression)) {
            return Arrays.asList(new Expression(expression.substring(1, expression.length() - 1), Operator.cartesian));
        }
        int openBrackets = 0;
        int expressionStart = 0;
        List<Expression> subExpressions = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '{') {
                openBrackets++;
                if (expressionStart != i && openBrackets == 1) {
                    subExpressions.add(new Expression(expression.substring(expressionStart, i), Operator.cartesian));
                    expressionStart = i;
                }
            } else if (expression.charAt(i) == '}') {
                openBrackets--;
                if (openBrackets == 0) {
                    subExpressions.add(new Expression(expression.substring(expressionStart, i + 1), Operator.cartesian));
                    expressionStart = i + 1;
                }
            }
        }
        if (expressionStart != expression.length()) {
            subExpressions.add(new Expression(expression.substring(expressionStart, expression.length()), Operator.cartesian));
        }
        return subExpressions;
    }

    private boolean hasWrapperBraces(String expression) {
        Stack<Character> braces = new Stack<>();
        for (int i = 1; i < expression.length() -1; i++) {
            if (expression.charAt(i) == '{') braces.add('{');
            else if (expression.charAt(i) == '}') {
                if (!braces.isEmpty() && braces.peek() == '{') {
                    braces.pop();
                } else {
                    return false;
                }
            }
        }
        return expression.charAt(0) == '{' && expression.charAt(expression.length() - 1) == '}' && braces.isEmpty();
    }

    public static class Expression {
        private final String expr;
        private final Operator operator;

        public Expression(String expr, Operator operator) {
            this.expr = expr;
            this.operator = operator;
        }

        public String expr() {
            return expr;
        }

        public Operator operator() {
            return operator;
        }

        @Override
        public String toString() {
            return String.format("{ expr=%s, operator=%s }", this.expr, this.operator);
        }
    }

    public static class SubExpressions {
        private final List<String> expr;
        private final Operator operator;

        public SubExpressions(List<String> expr, Operator operator) {
            this.expr = expr;
            this.operator = operator;
        }

        public List<String> subExpr() {
            return expr;
        }

        public Operator operator() {
            return operator;
        }
    }

    public enum Operator {
        union, cartesian
    }

    public static void main(String[] args) {
        System.out.println(new BraceExpansionII().evaluateExpr("{a,b}{c,{d,e}}").stream().distinct().sorted().collect(Collectors.toList()));
        System.out.println(new BraceExpansionII().evaluateExpr("{{a,z},a{b,c},{ab,z}}").stream().distinct().sorted().collect(Collectors.toList()));
    }
}
