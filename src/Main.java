import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculation calculation = new Calculation();
        UserInterface userInterface = new UserInterface();
        while (true) {
            try {
                userInterface.readFromUser(calculation);
                userInterface.showResults(calculation);
            }
            catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите валидные данные!");
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            catch (ArithmeticException e) {
                System.out.println("Неустранимый разрыв второго рода в области интегрирования.");
            }
        }


    }

}