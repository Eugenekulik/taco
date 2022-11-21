package by.eugenekulik.taco.controller;


import by.eugenekulik.taco.dao.JpaIngredientRepository;
import by.eugenekulik.taco.domain.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ingredient", produces = "application/json")
@CrossOrigin("*")
public class IngredientController {

    @Autowired
    private JpaIngredientRepository ingredientRepository;

    @GetMapping
    public Iterable<Ingredient> getAllIngredients(){
        return ingredientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable("id") String id){
        return new ResponseEntity<>(ingredientRepository.findById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTaco(@PathVariable String id){
        ingredientRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient){
        if((ingredient = ingredientRepository.save(ingredient))!=null){
            return new ResponseEntity<>(ingredient,HttpStatus.OK);
        } else return new ResponseEntity<>(ingredient, HttpStatus.BAD_REQUEST);
    }
}
