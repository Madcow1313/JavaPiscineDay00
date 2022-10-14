import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int week = 1;
        long summarizedGrades = 0;

        while (!input.equals("42") && week <= 18){
            if (!input.equals("Week " + week)){
                System.out.println("Illegal Argument");
                System.exit(-1);
            }
            summarizedGrades = insertMinGrade(scanner, summarizedGrades);
            input = scanner.nextLine();
            week++;
        }
        printGrades(summarizedGrades);
    }

    private static long insertMinGrade(Scanner scanner, long summarizedGrades){
        int min = scanner.nextInt();
        int temp;
        for (int i = 0; i < 4 && scanner.hasNextInt(); i++){
            temp = scanner.nextInt();
            if (temp < min)
                min = temp;
        }
        scanner.nextLine();
        summarizedGrades = summarizedGrades * 10 + min;
        return summarizedGrades;
    }

    private static void printGrades(long summarizedGrades){
        long results;
        int week = 1;
        summarizedGrades = reverseGrades(summarizedGrades);
        while (summarizedGrades > 0){
            results = summarizedGrades % 10;
            summarizedGrades /= 10;
            System.out.print("Week " + week + " ");
            for (int i = 0; i < results; i++)
                System.out.print("=");
            System.out.println(">");
            week++;
        }
    }

    private static long reverseGrades(long summarizedGrades){
        long result = 0;
        while (summarizedGrades > 0){
            result = summarizedGrades % 10 + result * 10;
            summarizedGrades /= 10;
        }
        return  result;
    }
}
