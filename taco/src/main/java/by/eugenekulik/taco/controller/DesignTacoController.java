package by.eugenekulik.taco.controller;


import by.eugenekulik.taco.dao.JPAImpl.JpaTacoRepository;
import by.eugenekulik.taco.domain.Taco;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "designs", produces = "application/json")
public class DesignTacoController {
    private JpaTacoRepository tacoRepository;

    public DesignTacoController(JpaTacoRepository tacoRepository){
        this.tacoRepository = tacoRepository;
    }

    @GetMapping("/recent")
    public Iterable<Taco> getAllTacos(){
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        return tacoRepository.findAll();
    }
}
