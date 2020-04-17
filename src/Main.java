import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    // TODO should it generate fractions? otherwise what's the point of having a double?

    // Max number of generated expressions
    private static final int MAX_NUM_OF_EXPRESSIONS = 100;

    // Max number of generated operands
    private static final int MAX_NUM_OF_OPERANDS = 4;

    // Max value an atomic expression can have
    private static final int MAX_RANDOM_VALUE = 9;

    // Number of random operators
    private static final int RANDOM_OPERATORS = 2;

    // Value used to divide a number to get a fraction
    private static final int FRACTION_DIVIDER = 10;

    public static void main(String[] args) {

        // Holds a list of random expressions
        List<Expression> expressions = new ArrayList<>();

        // Choose the number of generated expressions
        Random random = new Random();
        int numOfExpressions = random.nextInt(MAX_NUM_OF_EXPRESSIONS) + 1;

        // Fill the list with random expressions
        generateExpressions(expressions, random, numOfExpressions);

        // Print the expressions
        printExpressions(expressions);
    }

    /**
     * Prints the given expressions with their results and equal expressions.
     *
     * @param expressions expressions to print
     */
    private static void printExpressions(List<Expression> expressions) {
        for (int i = 0; i < expressions.size(); i++) {
            double expressionResult = expressions.get(i).calculate();
            System.out.println(String.format("Expression: %s\nResult: %s", expressions.get(i), expressionResult));
            printEqualExpressions(i, expressions);
            System.out.println();
        }
    }

    /**
     * Goes over the given expressions and looks for an equal expression to the given one's index.
     *
     * @param expressionIndex expression index to compare other to
     * @param expressions     expressions to search through
     */
    private static void printEqualExpressions(int expressionIndex, List<Expression> expressions) {
        Expression expression = expressions.get(expressionIndex);
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Equal expressions: [ ");

        for (int i = 0; i < expressions.size(); i++) {

            if (i != expressionIndex && expressions.get(i).equals(expression)) {
                stringBuilder.append(String.format(" %s,", expressions.get(i)));
            }
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        stringBuilder.append(" ]");
        System.out.println(stringBuilder.toString());
    }

    /**
     * Generates random expressions into the given list.
     *
     * @param expressions      list to fill with expressions
     * @param random           random generator
     * @param numOfExpressions number of expressions to generate
     */
    private static void generateExpressions(List<Expression> expressions,
                                            Random random, int numOfExpressions) {
        for (int i = 0; i < numOfExpressions; i++) {
            Expression newExpression = generateExpression(random);
            expressions.add(newExpression);
        }
    }

    /**
     * Generates a random expression.
     *
     * @param random random values generator
     * @return random expression
     */
    private static Expression generateExpression(Random random) {
        Expression initialExpression = new AtomicExpression(random.nextInt(MAX_RANDOM_VALUE) + 1);
        CompoundExpression compoundExpression = null;
        int numOfOperands = random.nextInt(MAX_NUM_OF_OPERANDS) + 2;
        double value;

        for (int i = 0; i < numOfOperands - 1; i++) {
            value = generateRandomValue(random);

            if (compoundExpression == null) {
                compoundExpression = createCompoundExpression(initialExpression,
                        new AtomicExpression(value), random);
            } else {
                compoundExpression = createCompoundExpression(compoundExpression, new AtomicExpression(value),
                        random);
            }
        }

        return compoundExpression;
    }

    /**
     * Generates a random value with up to two decimal numbers.
     *
     * @param random random generator
     * @return random value
     */
    private static double generateRandomValue(Random random) {
        double number = random.nextInt(MAX_RANDOM_VALUE) + 1;
        double fraction = (double) random.nextInt(MAX_RANDOM_VALUE + 1) / FRACTION_DIVIDER;

        return number + fraction;
    }

    /**
     * Creates a random compound expression.
     *
     * @param leftExpression  left expression of the compound expression
     * @param rightExpression right expression of the compound expression
     * @param random          random generator
     * @return random compound expression
     */
    private static CompoundExpression createCompoundExpression(Expression leftExpression, Expression rightExpression, Random random) {
        int operator = random.nextInt(RANDOM_OPERATORS);

        if (operator == 0) {
            return new AdditionExpression(leftExpression, rightExpression);
        }
        return new SubtractionExpression(leftExpression, rightExpression);
    }
}
