package advanced;

public class DoubleCalculator extends ACalculator {
    public DoubleCalculator(double state) {
        this.state = state;
    }

    @Override
    protected void init() {
        this.state = 0.0;
    }

    public DoubleCalculator add(double val) {
        this.state = (Double) this.state + val;
        return this;
    }

    public DoubleCalculator subtract(double val) {
        this.state = (Double) this.state - val;
        return this;
    }

    public DoubleCalculator multiply(double val) {
        this.state = (Double) this.state * val;
        return this;
    }
}