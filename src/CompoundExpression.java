public abstract class CompoundExpression extends Expression {

    private Expression leftExpression;
    private Expression rightExpression;

    /**
     * Constructor.
     *
     * @param leftExpression  left expression of the compound expression
     * @param rightExpression right expression of the compound expression
     */
    public CompoundExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }
}
