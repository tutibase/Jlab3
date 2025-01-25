package org.example;

import java.util.Random;

public class GasStation {
    public static void main(String[] args) {
        Pump[] pumps = {new Pump(1), new Pump(2), new Pump(3)};
        Cashier cashier = new Cashier(pumps);
        Random rand = new Random();

        // Создаем поток клиентов
        Thread customerThread = new Thread(() -> {
            while (true) {
                int fuelAmount = rand.nextInt(5) + 1;
                Customer customer = new Customer(cashier, fuelAmount);
                new Thread(customer).start();

                try {
                    Thread.sleep(rand.nextInt(300) + 100); // Интервал между приходом клиентов
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        customerThread.start();
    }
}