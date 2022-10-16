import java.util.Scanner;

public class Program {
    private static final int MAX = 10;
    private static final int HOURS = 7;
    private static final int DAYS = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] students = new String[MAX];
        String[][] classes = new String[DAYS][HOURS];

        students = readStudentsName(students, scanner);
        classes = readClasses(classes, scanner);
        for (int i = 0; i < classes.length; i++){
            for (int j = 0; j < classes[i].length; j++){
                if (classes[i][j] != null)
                    System.out.print(classes[i][j]);
            }
        }
    }

    private static String[] readStudentsName(String[] students, Scanner scanner){
        int counter = 0;
        String input;
        while (!(input = scanner.nextLine()).equals(".")) {
            if (counter >= MAX){
                System.err.println("Too many students!");
                System.exit(-1);
            }
            students[counter] = input;
            counter++;
        }
        return students;
    }

    private static String[][] readClasses(String[][] classes, Scanner scanner){
        int counter = 0;
        int temp;
        String hours;
        String day;

        while (true){
            if (counter >= MAX){
                System.err.println("Too many classes!");
                System.exit(-1);
            }
            hours = scanner.next();
            if (hours.equals("."))
                break ;
            day = scanner.next();
            if ((temp = compareDay(day)) != -1){
                classes[temp][0] += hours;
            }
            else{
                System.err.println("Day of week doesn't exist!");
                System.exit(-1);
            }
            counter++;
        }


        return classes;
    }

    private static int compareDay(String day){
        String[] days = {"SU", "MO", "TU", "WE", "TH", "FR", "SA"};
        int i = 0;
        while (i < DAYS){
            if (day.equals(days[i]))
                return i;
            i++;
        }
        return -1;

    }
}