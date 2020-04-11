public class AdditionExpression extends CompoundExpression {

    public AdditionExpression(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public String toString() {
       return String.format("%s + %s", this.leftExpression, this.rightExpression);
    }
}
