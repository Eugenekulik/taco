package by.eugenekulik.taco.dao;

import by.eugenekulik.taco.domain.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Ingredient findOne(long id);
    Ingredient save(Ingredient ingredient);
}
