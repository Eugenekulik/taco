package by.eugenekulik.taco.dao;

import by.eugenekulik.taco.domain.Taco;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;

public interface JpaTacoRepository extends CrudRepository<Taco, Long> {
}
