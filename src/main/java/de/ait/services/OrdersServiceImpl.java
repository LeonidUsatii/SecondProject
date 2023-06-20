package de.ait.services;


import de.ait.models.Order;
import de.ait.models.Product;
import de.ait.models.User;
import de.ait.repositories.OrdersRepository;
import de.ait.repositories.ProductsRepository;
import de.ait.repositories.UsersRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public class OrdersServiceImpl implements OrdersService {

    private UsersRepository usersRepository;
    private ProductsRepository productsRepository;

    private OrdersRepository ordersRepository;

    public OrdersServiceImpl(UsersRepository usersRepository,
                             ProductsRepository goodsRepository,
                             OrdersRepository ordersRepository) {
        this.usersRepository = usersRepository;
        this.productsRepository = goodsRepository;
        this.ordersRepository = ordersRepository;
    }

    @Override
    public String makeOrder(String email, String title) {
        User user = usersRepository.findByEmail(email); // находим пользователя по email

        if (user == null) {
            throw new IllegalArgumentException("Пользователь не найден");
        }

        Product product = productsRepository.findByTitle(title); // находим товар по названию

        if (product == null) {
            throw new IllegalArgumentException("Товар не найден");
        }

        Order order = new Order(
                UUID.randomUUID().toString(), // сгенерировали идентификатор
                LocalDateTime.now(),
                product.getId(),
                user.getId()
        );

        ordersRepository.save(order);

        return "Квитанция № " + order.getId() + ", заказ был сделан на " + title + " в " + order.getDateTime();
    }
}
