public class AtomicExpression extends Expression {

    private double expression;

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
