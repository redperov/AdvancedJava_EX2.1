public class AtomicExpression extends Expression {

    /**
     * Holds the value of the atomic expression.
     */
    private double expression;

    /**
     * Constructor.
     *
     * @param expression atomic expression
     */
    public AtomicExpression(double expression) {
        this.expression = expression;
    }

    @Override
    public double calculate() {
        return this.expression;
    }

    @Override
    public String toString() {
        return String.valueOf(this.expression);
    }
}
