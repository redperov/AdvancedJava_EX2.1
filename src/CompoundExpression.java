public abstract class CompoundExpression extends Expression {

    protected Expression leftExpression;
    protected Expression rightExpression;

    public CompoundExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
}
