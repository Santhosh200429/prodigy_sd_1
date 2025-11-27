import java.util.InputMismatchException;
import java.util.Scanner;

// ---------------------------------------------------------------
//  Temperature Class (OOP)
// ---------------------------------------------------------------
class Temperature {
    private double value;
    private char unit;

    public Temperature(double value, char unit) {
        this.value = value;
        this.unit = Character.toUpperCase(unit);
    }

    public double toCelsius() {
        switch (unit) {
            case 'C': return value;
            case 'F': return (value - 32) * 5/9;
            case 'K': return value - 273.15;
            default: return Double.NaN;
        }
    }

    public double toFahrenheit() {
        return (toCelsius() * 9/5) + 32;
    }

    public double toKelvin() {
        return toCelsius() + 273.15;
    }

    public void display() {
        System.out.printf("\nConverted Temperatures:\n");
        System.out.printf("Celsius    : %.2f °C\n", toCelsius());
        System.out.printf("Fahrenheit : %.2f °F\n", toFahrenheit());
        System.out.printf("Kelvin     : %.2f K\n", toKelvin());
    }
}

// ---------------------------------------------------------------
//  Main Program (Menu + Loop + Validation + OOP + Clean Output)
// ---------------------------------------------------------------
public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("\n==============================");
            System.out.println("   TEMPERATURE CONVERTER");
            System.out.println("==============================");
            System.out.println("1. Convert from Celsius");
            System.out.println("2. Convert from Fahrenheit");
            System.out.println("3. Convert from Kelvin");
            System.out.println("4. Exit");
            System.out.print("\nChoose an option: ");

            try {
                choice = sc.nextInt();

                if (choice == 4) {
                    System.out.println("Exiting... Goodbye!");
                    break;
                }

                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid option. Try again.");
                    continue;
                }

                System.out.print("Enter temperature value: ");
                double value = sc.nextDouble();

                char unit = (choice == 1) ? 'C' :
                            (choice == 2) ? 'F' : 'K';

                // OOP: Use Temperature object
                Temperature temp = new Temperature(value, unit);
                temp.display();

            } catch (InputMismatchException e) {
                System.out.println("\nError: Please enter a valid number!");
                sc.nextLine(); // clear invalid input
            }
        }
    }
}
