import java.util.Scanner;

public class LAB_2 {
    private static final int MAX_SIZE = 20;
    private static final int RANDOM_MIN = 1;
    private static final int RANDOM_MAX = 100;

    private int[][] matrix;
    private int rows;
    private int columns;

    public static void main(String[] args) {
        LAB_2 program = new LAB_2();
        program.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість рядків матриці (не більше " + MAX_SIZE + "): ");
        rows = readInput(scanner);
        System.out.print("Введіть кількість стовпців матриці (не більше " + MAX_SIZE + "): ");
        columns = readInput(scanner);

        matrix = new int[rows][columns];

        System.out.println("Оберіть спосіб заповнення матриці:");
        System.out.println("1. З клавіатури");
        System.out.println("2. Випадковими числами");
        int choice = readInput(scanner);

        switch (choice) {
            case 1:
                fillMatrixFromKeyboard(scanner);
                break;
            case 2:
                fillMatrixRandomly();
                break;
            default:
                System.out.println("Некоректний вибір.");
                return;
        }

        System.out.println("Матриця:");
        printMatrix();

        int min = findMinimumElement();
        int max = findMaximumElement();
        double average = calculateArithmeticAverage();
        double geometricAverage = calculateGeometricAverage();

        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.println("Середнє арифметичне: " + average);
        System.out.println("Середнє геометричне: " + geometricAverage);
    }

    private int readInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Некоректне значення. Будь ласка, спробуйте ще раз.");
            }
        }
    }

    private void fillMatrixFromKeyboard(Scanner scanner) {
        System.out.println("Введіть елементи матриці:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Елемент [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = readInput(scanner);
            }
        }
    }

    private void fillMatrixRandomly() {
        System.out.println("Матриця заповнюється випадковими числами...");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = getRandomNumber();
            }
        }
    }

    private int getRandomNumber() {
        return (int) (Math.random() * (RANDOM_MAX - RANDOM_MIN + 1) + RANDOM_MIN);
    }

    private void printMatrix() {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

    private int findMinimumElement() {
        int min = matrix[0][0];

        for (int[] row : matrix) {
            for (int element : row) {
                if (element < min) {
                    min = element;
                }
            }
        }

        return min;
    }

    private int findMaximumElement() {
        int max = matrix[0][0];

        for (int[] row : matrix) {
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }

        return max;
    }

    private double calculateArithmeticAverage() {
        int sum = 0;
        int count = rows * columns;

        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
            }
        }

        return (double) sum / count;
    }

    private double calculateGeometricAverage() {
        long product = 1;
        int count = rows * columns;

        for (int[] row : matrix) {
            for (int element : row) {
                product *= element;
            }
        }

        return Math.pow(product, 1.0 / count);
    }
}