public class AdditionExpression extends CompoundExpression {

    /**
     * Constructor.
     *
     * @param leftExpression  left expression of the addition expression
     * @param rightExpression right expression of the addition expression
     */
    public AdditionExpression(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public double calculate() {
        double result = getLeftExpression().calculate() + this.getRightExpression().calculate();

        // Return a rounded value of up to two decimal numbers
        return Math.round(result * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return String.format("%s + %s", this.getLeftExpression(), this.getRightExpression());
    }
}
