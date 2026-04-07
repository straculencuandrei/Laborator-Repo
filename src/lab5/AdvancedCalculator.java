package lab5;

public class AdvancedCalculator extends IntCalculator {

    public AdvancedCalculator(int state) {
        super(state);
    }

    @Override
    public AdvancedCalculator add(int value) {
        super.add(value);
        return this;
    }

    @Override
    public AdvancedCalculator subtract(int value) {
        super.subtract(value);
        return this;
    }

    @Override
    public AdvancedCalculator multiply(int value) {
        super.multiply(value);
        return this;
    }

    public AdvancedCalculator divide(int value) {
        if (value != 0) {
            this.state /= value;
        }
        return this;
    }

    public AdvancedCalculator power(int value) {
        this.state = (int) Math.pow(this.state, value);
        return this;
    }

    public AdvancedCalculator root(int value) {
        if (value != 0) {
            this.state = (int) Math.pow(this.state, 1.0 / value);
        }
        return this;
    }

    @Override
    public void clear() {
        super.clear();
    }
}