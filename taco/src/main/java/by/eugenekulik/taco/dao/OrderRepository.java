package by.eugenekulik.taco.dao;

import by.eugenekulik.taco.domain.Order;

public interface OrderRepository {
    Order save(Order order);
}
