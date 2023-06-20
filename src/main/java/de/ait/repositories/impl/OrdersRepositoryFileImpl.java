package de.ait.repositories.impl;


import de.ait.models.Order;
import de.ait.repositories.OrdersRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OrdersRepositoryFileImpl implements OrdersRepository {

    private String fileName;

    public OrdersRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            writer.write(order.getId() + "|" +
                    order.getDateTime().toString() + "|" +
                    order.getGoodId() + "|" +
                    order.getUserId());
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalStateException("Проблемы с файлом");
        }
    }

    @Override
    public Order findById(String id) {
        return null;
    }
}
