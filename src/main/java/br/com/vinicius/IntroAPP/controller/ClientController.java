package br.com.vinicius.IntroAPP.controller;

import br.com.vinicius.IntroAPP.model.ClientModel;
import br.com.vinicius.IntroAPP.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
