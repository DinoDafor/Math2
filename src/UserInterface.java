import java.util.Scanner;

public class UserInterface {
    Scanner in = new Scanner(System.in);

    public Object readFromUser(Calculation calculation) throws NumberFormatException {
        System.out.println("Выберите уравнение:");
        System.out.println("1. x^2");
        System.out.println("2. Cos(x)");
        System.out.println("3. Sin(x)");
        System.out.println("4. 1/x");
        calculation.setNumberOfFunction(Integer.parseInt(in.next().trim()));

        if (calculation.getNumberOfFunction() > 4 || calculation.getNumberOfFunction() < 1) {
            throw new IllegalArgumentException("Выберите только те функции, которые присутствуют на экране.");
        }

        System.out.println("Введите границы определенного интеграла");

        calculation.setLow(Double.parseDouble(in.next().trim().replace(",", ".")));
        calculation.setUp(Double.parseDouble(in.next().trim().replace(",", ".")));

        System.out.println("Введите точность вычислений");
        calculation.setAccuracy(Double.parseDouble(in.next().trim().replace(",", ".")));
        if (calculation.getAccuracy() < 0.00001) {
            throw new IllegalArgumentException("Извините, такая точность недопустима.");
        }

        System.out.println("Выберите метод:");
        System.out.println("1. Метод левых прямоугольников.");
        System.out.println("2. Метод средних.");
        System.out.println("3. Метод правых прямоугольников.");
        calculation.setNumberOfMethod(Integer.parseInt(in.next().trim()));
        if (calculation.getNumberOfMethod() > 3 || calculation.getNumberOfMethod() < 1) {
            throw new IllegalArgumentException("Выберите только те методы, которые присутствуют на экране.");
        }
        return calculation;
    }

    public void showResults(Calculation calculation) {
        switch (calculation.getNumberOfMethod()) {
            case 1:
                calculation.findLeftSteps();
                System.out.println("Значение интеграла: " + calculation.findLeftRectangle());
                break;
            case 2:
                calculation.findMidSteps();
                System.out.println("Значение интеграла: " + calculation.findMidRectangle());
                break;
            case 3:
                calculation.findRightSteps();
                System.out.println("Значение интеграла: " + calculation.findRightRectangle());
                break;
        }
        System.out.println("Количество разбиений, на которое пришлось разбить: " + calculation.getSteps());
        System.out.println("Полученная погрешность: " + calculation.getInaccuracy());

    }
}
