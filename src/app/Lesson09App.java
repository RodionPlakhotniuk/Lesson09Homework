import java.util.Random;

public class Lesson09App {

    public static void main(String[] args) {
        Random random = new Random();
        int sumPaired = 0;
        int sumUnpaired = 0;
        long productPaired = 1;
        long productUnpaired = 1;

        int[][] number = new int[4][4];
        System.out.println("Матриця 4х4:");
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < number[i].length; j++) {
                number[i][j] = random.nextInt(50) + 1;
                System.out.print(number[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < number[i].length; j++) {
                if (i % 2 == 0) {
                    sumPaired += number[i][j];
                } else {
                    sumUnpaired += number[i][j];
                }
                if (j % 2 == 0) {
                    productPaired *= number[i][j];
                } else {
                    productUnpaired *= number[i][j];
                }

            }

        }


        System.out.printf("Сума елементів у парних рядках (рядок 0, 2): %d \n" +
                        "Сума елементів у непарних рядках (рядок 1, 3): %d \n" +
                        "Добуток елементів у парних стовпцях (стовпець 0, 2): %d \n" +
                        "Добуток елементів у непарних стовпцях (стовпець 1, 3): %d \n"
                , sumPaired, sumUnpaired, productPaired, productUnpaired);


        boolean isMagic = true;
        int magicSum = 0;


        for (int j = 0; j < number[0].length; j++) {
            magicSum += number[0][j];
        }


        for (int i = 1; i < number.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < number[i].length; j++) {
                rowSum += number[i][j];
            }
            if (rowSum != magicSum) {
                isMagic = false;
                break;
            }
        }


        for (int j = 0; j < number[0].length; j++) {
            int colSum = 0;
            for (int i = 0; i < number.length; i++) {
                colSum += number[i][j];
            }
            if (colSum != magicSum) {
                isMagic = false;
                break;
            }
        }


        int diagonal1Sum = 0;
        int diagonal2Sum = 0;
        for (int i = 0; i < number.length; i++) {
            diagonal1Sum += number[i][i];
            diagonal2Sum += number[i][number.length - 1 - i];
        }
        if (diagonal1Sum != magicSum || diagonal2Sum != magicSum) {
            isMagic = false;
        }


        if (isMagic) {
            System.out.println("Матриця є магічним квадратом.");
        } else {
            System.out.println("Матриця не є магічним квадратом.");
        }
    }
}
