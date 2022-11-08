package br.com.vinicius.IntroAPP.controller;

import br.com.vinicius.IntroAPP.model.ClientModel;
import br.com.vinicius.IntroAPP.service.ClientServiceV1;
import br.com.vinicius.IntroAPP.service.ClientServiceV2;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients/v2")
public class ClientControllerV2 {

    @Autowired
    private ClientServiceV2 service;

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Returns a Client by IO")
    public Optional<ClientModel> findById(
            @ApiParam(name = "id", value = "A valid integer value", required = true)
            @PathVariable("id") long id) {
        return service.findById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public List<ClientModel> findAll() {
        return service.findAll();
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ClientModel save(@RequestBody ClientModel model) {
        return service.save(model);
    }

    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
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

    @GetMapping("/find/email/{email}")
    public List<ClientModel> findByEmail(@PathVariable("email") String email){
        return service.findByEmail(email);
    }
}
