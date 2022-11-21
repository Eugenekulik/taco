package by.eugenekulik.taco.dao;

import by.eugenekulik.taco.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface JpaIngredientRepository extends CrudRepository<Ingredient, String> {

}
