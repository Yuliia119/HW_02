package ait.multi.task;

import java.util.Scanner;

public class TarakanRaceApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter quantity to Tarakans: ");
        int numTarakans = scanner.nextInt();
        System.out.println("Enter the number of steps: ");
        int distance = scanner.nextInt();

        Thread[] threads = new Thread[numTarakans];   // массив потоков
        for (int i = 0; i < numTarakans; i++) {       // создаём и запускаем потоки
            Tarakan tarakan = new Tarakan(i+1, distance);
            threads[i] = new Thread(tarakan);
            threads[i].start();
        }
        for (Thread t : threads) {    // перебираем потоки в массиве
            try {
                t.join();            // режим ожидания
            } catch (InterruptedException e) {
                e.printStackTrace();   //  если прервалось ожидание
            }
        }
        System.out.println("The race is over!");
        System.out.println("Congratulations to Tarakan #" + Tarakan.getWinnerNumber() + " (winner)!");
        scanner.close();

    }
}
