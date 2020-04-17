public abstract class Expression {

    /**
     * Calculates the value of the expression.
     *
     * @return expression result
     */
    public abstract double calculate();

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Expression)) {
            return false;
        }
        Expression otherExpression = (Expression) obj;

        return this.calculate() == otherExpression.calculate();
    }
}
