import  java.util.Scanner;

public class Program {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int steps = 0;
        if (input <= 1)
            System.err.println("Illegal Argument");
        else if (input == 2 || input == 3)
            System.out.println(true + " " + 1);
        else if(input % 2 == 0)
            System.out.println(false + " " + 1);
        else
        {
            for (int i = 3; i * i <= input; i += 2) {
                steps++;
                if (input % i == 0) {
                    System.out.println(false + " " + steps);
                    return;
                }
            }
            System.out.println(true + " " + steps);
        }
    }
}
