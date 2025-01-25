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
                int fuelAmount = rand.nextInt(50) + 1;
                Customer customer = new Customer(cashier, fuelAmount);
                new Thread(customer).start();

            }
        });
        customerThread.start();
    }
}