package by.eugenekulik.taco.controller;

import by.eugenekulik.taco.dao.JPAImpl.JpaIngredientRepository;
import by.eugenekulik.taco.dao.JPAImpl.JpaTacoRepository;
import by.eugenekulik.taco.domain.Ingredient;
import by.eugenekulik.taco.domain.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping(value = "/design")
@SessionAttributes("tacoList")
public class TacoController {
    private final JpaIngredientRepository ingredientRepo;
    private final JpaTacoRepository tacoRepository;

    @ModelAttribute(name="tacoList")
    public List<Taco> order(){
        return new ArrayList<>();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @Autowired
    public TacoController(JpaIngredientRepository ingredientRepo,
                          JpaTacoRepository tacoRepository) {
        this.ingredientRepo = ingredientRepo;
        this.tacoRepository = tacoRepository;
    }
    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    ingredients.stream()
                            .filter(Ingredient -> Ingredient.getType().equals(type)).collect(Collectors.toList()));
        }
        model.addAttribute("taco", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco taco, Errors errors, Model model, @ModelAttribute List<Taco> tacoList) {
        if(errors.hasErrors()){
            List<Ingredient> ingredients = new ArrayList<>();
            ingredientRepo.findAll().forEach(i -> ingredients.add(i));
            Ingredient.Type[] types = Ingredient.Type.values();
            for (Ingredient.Type type : types) {
                model.addAttribute(type.toString().toLowerCase(),
                        ingredients.stream()
                                .filter(Ingredient -> {return Ingredient.getType().equals(type);}).collect(Collectors.toList()));
            }
            return "design";
        }
        Taco saved = tacoRepository.save(taco);
        tacoList.add(saved);
        return "redirect:/orders/current";
    }
}
