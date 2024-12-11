package org.example;

import java.util.Random;

public class GasStation {
    public static void main(String[] args) {
        Pump[] pumps = {new Pump(1), new Pump(2), new Pump(3)};
        Cashier cashier = new Cashier(pumps);
        Random rand = new Random();

        Thread[] customers = new Thread[7];
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Thread(new Customer(cashier, rand.nextInt(50) + 1));
            customers[i].start();
        }

        for (Thread customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Все покупатели закончили");
    }
}
