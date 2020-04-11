public class SubtractionExpression extends CompoundExpression {

    public SubtractionExpression(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public double calculate() {
        return this.leftExpression.calculate() - this.rightExpression.calculate();
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.leftExpression, this.rightExpression);
    }
}
