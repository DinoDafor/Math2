public class Calculation {
    private int numberOfFunction;
    private int numberOfMethod;
    private double result;
    private double up;
    private double low;
    private double h;
    private double accuracy;
    private double steps;
    private double inaccuracy;

    public Calculation() {
    }

    public double findRightRectangle() {
        h = (up - low) / steps;
        result = 0;

        switch (this.numberOfFunction) {
            case 1:
                for (int i = 1; i < steps + 1; i++) {
                    result = result + calculateFirstFunction(low + h * i);
                }
                result = result * h;
                break;
            case 2:
                for (int i = 1; i < steps + 1; i++) {
                    result = result + calculateSecondFunction(low + h * i);
                }
                result = result * h;
                break;
            case 3:
                for (int i = 1; i < steps + 1; i++) {
                    result = result + calculateThirdFunction(low + h * i);
                }
                result = result * h;
                break;

            case 4:
                for (int i = 1; i < steps + 1; i++) {
                    result = result + calculateFourthFunction(low + h * i);
                }
                result = result * h;
                break;

        }
        return result;

    }

    public double findLeftRectangle() {

        h = (up - low) / steps;
        result = 0;

        switch (this.numberOfFunction) {
            case 1:
                for (int i = 0; i < steps; i++) {
                    result = result + calculateFirstFunction(low + h * i);
                }
                result = result * h;
                break;
            case 2:
                for (int i = 0; i < steps; i++) {
                    result = result + calculateSecondFunction(low + h * i);
                }
                result = result * h;
                break;
            case 3:
                for (int i = 0; i < steps; i++) {
                    result = result + calculateThirdFunction(low + h * i);
                }
                result = result * h;
                break;

            case 4:
                for (int i = 0; i < steps; i++) {
                    result = result + calculateFourthFunction(low + h * i);
                }
                result = result * h;
                break;

        }
        return result;

    }

    public double findMidRectangle() {

        h = (up - low) / steps;
        result = 0;

        switch (this.numberOfFunction) {
            case 1: // i change on 1    
                for (int i = 0; i < steps; i++) {
                    result = result + calculateFirstFunction(low + h * i + h / 2);
                }
                result = result * h;
                break;
            case 2:
                for (int i = 0; i < steps; i++) {
                    result = result + calculateSecondFunction(low + h * i + h / 2);
                }
                result = result * h;
                break;
            case 3:
                for (int i = 0; i < steps; i++) {
                    result = result + calculateThirdFunction(low + h * i + h / 2);
                }
                result = result * h;
                break;

            case 4:
                for (int i = 0; i < steps; i++) {// второго рода в 0
                    result = result + calculateFourthFunction(low + h * i + h / 2);
                }
                result = result * h;
                break;


        }
        return result;

    }

    public void findRightSteps() {
        double rightSteps = 5;
        while (true) {
            this.steps = rightSteps;
            double result1 = findRightRectangle();
            this.steps = rightSteps * 2;
            double result2 = findRightRectangle();
            if (Math.abs(result1 - result2) / 3 <= this.accuracy) {
                this.inaccuracy = (java.lang.Math.abs(result1 - result2)) / 3;
                break;
            } else rightSteps = rightSteps * 2;

        }
        this.steps = rightSteps;


    }

    public void findLeftSteps() {
        double leftSteps = 5;
        while (true) {
            this.steps = leftSteps;
            double result1 = findLeftRectangle();
            this.steps = leftSteps * 2;
            double result2 = findLeftRectangle();
            if (Math.abs(result1 - result2) / 3 <= this.accuracy) {
                this.inaccuracy = (java.lang.Math.abs(result1 - result2)) / 3;
                break;
            } else leftSteps = leftSteps * 2;

        }
        this.steps = leftSteps;
    }

    public void findMidSteps() {
        double midSteps = 5;
        while (true) {
            this.steps = midSteps;
            double result1 = findMidRectangle();
            this.steps = midSteps * 2;
            double result2 = findMidRectangle();
            if (Math.abs(result1 - result2) / 3 <= this.accuracy) {
                this.inaccuracy = (java.lang.Math.abs(result1 - result2)) / 3;
                break;
            } else midSteps = midSteps * 2;

        }
        this.steps = midSteps;

    }

    private double calculateFirstFunction(double x) {
        return x * x;
    }

    private double calculateSecondFunction(double x) {
        return Math.cos(x);
    }

    private double calculateThirdFunction(double x) {
        return Math.sin(x);
    }

    private double calculateFourthFunction(double x) {
        return 1 / x;
    }

    public int getNumberOfFunction() {
        return numberOfFunction;
    }

    public void setNumberOfFunction(int numberOfFunction) {
        this.numberOfFunction = numberOfFunction;
    }

    public int getNumberOfMethod() {
        return numberOfMethod;
    }

    public void setNumberOfMethod(int numberOfMethod) {
        this.numberOfMethod = numberOfMethod;
    }

    public double getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public double getUp() {
        return up;
    }

    public void setUp(double up) {
        this.up = up;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public double getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setSteps(double steps) {
        this.steps = steps;
    }

    public double getInaccuracy() {
        return inaccuracy;
    }

    public void setInaccuracy(double inaccuracy) {
        this.inaccuracy = inaccuracy;
    }
}
