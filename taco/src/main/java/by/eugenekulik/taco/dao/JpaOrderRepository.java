package by.eugenekulik.taco.dao;

import by.eugenekulik.taco.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface JpaOrderRepository extends CrudRepository<Order, Long> {
}
