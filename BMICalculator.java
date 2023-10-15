import java.util.*;
import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("BMI Calculator");
        System.out.print("Enter your weight in kilograms: ");
        double weight = input.nextDouble();

        System.out.print("Enter your height in meters: ");
        double height = input.nextDouble();

        double bmi = calculateBMI(weight, height);
        String category = BMI(bmi);

        System.out.println("Your BMI is: " + bmi);
        System.out.println("BMI Category: " + category);

        input.close();
    }

    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    public static String BMI(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal Weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
