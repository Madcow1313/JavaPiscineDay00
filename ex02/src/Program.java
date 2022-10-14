import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;
        int number;
        int counter = 0;
        boolean isPrime = true;
        while ((input = scanner.nextInt()) != 42) {
            number = input % 10;
            while (input > 0) {
                input /= 10;
                number += input % 10;
            }
            System.out.println("Number is " + number);
            if (number != 2 && number != 3) {
                if (number % 2 == 0) {
                    isPrime = false;
                } else {
                    for (int i = 3; i * i <= number; i += 2) {
                        if (number % i == 0) {
                            isPrime = false;
                            break ;
                        }
                    }
                }
            }
            if (isPrime != false)
                counter += 1;
            isPrime = true;
        }
        System.out.println("Count of coffee-request - " + counter);
    }
}
