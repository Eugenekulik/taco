package by.eugenekulik.taco.controller;


import by.eugenekulik.taco.dao.JpaTacoRepository;
import by.eugenekulik.taco.domain.Taco;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/taco", produces = "application/json")
public class TacoController {
    private JpaTacoRepository tacoRepository;

    public TacoController(JpaTacoRepository tacoRepository){
        this.tacoRepository = tacoRepository;
    }

    @GetMapping
    public @ResponseBody Iterable<Taco> getAllTacos(){
        return tacoRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteTaco(@PathVariable long id){
        tacoRepository.deleteById(id);
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Taco> createTaco(@RequestBody Taco taco){
        if((taco = tacoRepository.save(taco))!=null)return new ResponseEntity<>(taco,HttpStatus.CREATED);
        else return new ResponseEntity<Taco>(taco,HttpStatus.BAD_REQUEST);
    }
}
