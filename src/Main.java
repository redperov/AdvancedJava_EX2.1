import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Holds a list of random expressions
        List<Expression> expressions = new ArrayList<>();

        // Holds a hash of expression results with a mapping to their expressions
        Map<Double, List<Expression>> resultsToExpressions = new HashMap<>();

        Random random = new Random();
        int numOfExpressions = random.nextInt(10) + 1;

        for (int i = 0; i < numOfExpressions; i++) {
            Expression newExpression = generateExpression(random);
            double expressionResult = newExpression.calculate();

            expressions.add(newExpression);
            saveExpression(resultsToExpressions, expressionResult, newExpression);
        }
    }

    /**
     * Saves a new expression and its corresponding result to a hash.
     * @param resultsToExpressions hash containing a mapping between expression results and their expressions
     * @param result expression result
     * @param expression expression
     */
    private static void saveExpression(Map<Double, List<Expression>> resultsToExpressions,
                                      Double result, Expression expression) {
        if (!resultsToExpressions.containsKey(result)) {
            List<Expression> newList = new ArrayList<>();
            newList.add(expression);
            resultsToExpressions.put(result, newList);
        }
        else {
            List<Expression> existingList = resultsToExpressions.get(result);
            existingList.add(expression);
        }
    }

    /**
     * Generates a random expression.
     * @param random random values generator
     * @return random expression
     */
    private static Expression generateExpression(Random random) {
        int numOfOperands = random.nextInt(4) + 1;
        int operator;

        for (int i = 0; i < numOfOperands; i++) {
            operator = random.nextInt(2);

        }

        return null;
    }
}
