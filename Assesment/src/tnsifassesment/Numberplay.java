package tnsifassesment;
import java.util.Scanner;

public class Numberplay {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a two-digit integer: ");
        int number = scanner.nextInt();

        NumberPuzzle numberPuzzle = new NumberPuzzle();

        if (numberPuzzle.isValidNumber(number)) {
            int result = numberPuzzle.solvePuzzle(number);
            System.out.println("Result: " + result);
        } else {
            System.out.println("Invalid number");
        }

        scanner.close();
    }
}

class NumberPuzzle {

    public boolean isValidNumber(int number) {
        return number >= 10 && number <= 99;
    }

    public int solvePuzzle(int number) {
        if (number > 50) {
            return findDifferenceBetweenDigits(number);
        } else {
            return findDifferenceInReversedDigits(number);
        }
    }

    private int findDifferenceBetweenDigits(int number) {
        int tensDigit = number / 10;
        int onesDigit = number % 10;
        return Math.abs(tensDigit - onesDigit);
    }

    private int findDifferenceInReversedDigits(int number) {
        int reversedNumber = reverseDigits(number);
        return findDifferenceBetweenDigits(reversedNumber);
    }

    private int reverseDigits(int number) {
        int tensDigit = number / 10;
        int onesDigit = number % 10;
        return onesDigit * 10 + tensDigit;
    }
}
