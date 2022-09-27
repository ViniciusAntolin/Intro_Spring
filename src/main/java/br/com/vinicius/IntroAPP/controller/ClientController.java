package br.com.vinicius.IntroAPP.controller;

import br.com.vinicius.IntroAPP.model.ClientModel;
import br.com.vinicius.IntroAPP.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
=======
>>>>>>> 7c7c4ab3eb2b612ec5ff45a7547d56ceefac0b1a
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/{id}")
    public Optional<ClientModel> findById(@PathVariable("id") long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<ClientModel> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ClientModel save(@RequestBody ClientModel model) {
        return service.save(model);
    }

    @PutMapping
    public ClientModel update(@RequestBody ClientModel model){
        return service.update(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        Optional<ClientModel> found = service.findById(id);
        if (found.isPresent()){
            service.delete(id);
            return ResponseEntity.ok().build();
        }else {
            return null;
        }
    }
}
