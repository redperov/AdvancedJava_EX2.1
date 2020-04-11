public class CompoundExpression extends Expression {

    protected Expression leftExpression;
    protected Expression rightExpression;

    public CompoundExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public double calculate() {
        return this.leftExpression.calculate() + this.rightExpression.calculate();
    }
}
