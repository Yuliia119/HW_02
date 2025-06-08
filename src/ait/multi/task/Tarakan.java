package ait.multi.task;
import java.util.Random;

public class Tarakan implements Runnable {
    private int number;
    private int steps;
    private Random random = new Random();
    private static volatile boolean winnerFound = false; // только один победитель

    public Tarakan(int number, int steps) {
        this.number = number;
        this.steps = steps;
    }

    @Override
    public void run() {
        System.out.println(number + " Tarakan started");
        for (int i = 1; i < steps; i++) {
            System.out.println("Tarakan " + number + ", steps = " + i);
            try {
                int sleepTime = 2 + random.nextInt(4); // ожидание от 2 до 5 мсек.
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (!winnerFound) {
            winnerFound = true;
            System.out.println("Congratulations to Tarakan #" + number + " (winner)!");
        }
        System.out.println(number + " Tarakan finished");
    }
}
