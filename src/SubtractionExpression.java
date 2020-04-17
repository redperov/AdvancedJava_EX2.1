public class SubtractionExpression extends CompoundExpression {

    /**
     * Constructor.
     *
     * @param leftExpression  left expression of the subtraction expression
     * @param rightExpression right expression of the subtraction expression
     */
    public SubtractionExpression(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public double calculate() {
        double result = getLeftExpression().calculate() - this.getRightExpression().calculate();

        // Return a rounded value of up to two decimal numbers
        return Math.round(result * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.getLeftExpression(), this.getRightExpression());
    }
}
