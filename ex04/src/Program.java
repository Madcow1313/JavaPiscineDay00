import java.util.Scanner;

public class Program {
    private static final int MAX_CHAR = 65535;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int[] intArray = new int[MAX_CHAR];
        char[] charArray = input.toCharArray();
        for (int i = 0; i < input.length(); i++){
            intArray[charArray[i]]++;
        }
        findTopTenAndPrint(intArray);
    }

    private static void findTopTenAndPrint(int[] intArray){
        char[] topTen = new char[10];
        int index;
        for (int i = 0; i < intArray.length; i++){
            if (intArray[i] != 0 &&
                    (index = findPositionToInsert(topTen, intArray, intArray[i])) != -1){
                    topTen = insertInCharArray(topTen, (char)i, index);
            }
        }
        for(int i = 0; i < topTen.length; i++){
            System.out.print(topTen[i] + " ");
            System.out.print(intArray[topTen[i]] + " ");
        }
        System.out.println();
        printStatistic(topTen, intArray);

    }

    private static int findPositionToInsert(char[] topTen, int[] intArray, int amount){
        for (int i = 0; i < topTen.length; i++){
            if (amount > intArray[topTen[i]]) {
                return i;
            }
        }
        return -1;
    }

    private static char[] insertInCharArray(char[] topTen, char c, int index){
        int i = 0;
        int j = index;
        char[] newTopTen = new char[10];

        while (i < index){
            newTopTen[i] = topTen[i];
            i++;
        }
        newTopTen[index] = c;
        i = index + 1;
        while (i < topTen.length){
            newTopTen[i] = topTen[j];
            j++;
            i++;
        }
        return newTopTen;
    }

    private static void printStatistic(char[] topTen, int[] intArray){
        int sum = 0;
        int[] percents = new int[10];
        double temp;
        int max = 10;
        for (int i = 0; i < topTen.length; i++){
            if (topTen[i] == 0){
                max = i;
                break ;
            }
            temp = ((float)intArray[topTen[i]] / intArray[topTen[0]]) * 10;
            percents[i] = (int)temp;
        }
        for (int i = 0; i < percents.length; i++)
            System.out.print(percents[i] + " ");
        for (int i = 12; i > 0; i--){
            for (int j = 0; j < percents.length; j++){
                if (percents[j] == i - 1 && intArray[topTen[j]] > 0){
                    if (intArray[topTen[j]] >= 10)
                        System.out.print(intArray[topTen[j]] + " ");
                    else
                        System.out.print(" " + intArray[topTen[j]] + " ");
                }
                else if (percents[j] >= i){
                    System.out.print(" " + "#" + " ");
                }
                else{
                    System.out.println();
                    break;
                }
            }
        }
        if (max == 10)
            System.out.println();
        System.out.print(' ');
        for (int i = 0; i < topTen.length; i++)
            System.out.print(topTen[i] + "  ");
    }
}
