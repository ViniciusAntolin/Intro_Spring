package br.com.vinicius.IntroAPP.service;

import br.com.vinicius.IntroAPP.model.ClientModel;
import br.com.vinicius.IntroAPP.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Optional<ClientModel> findById(long id) {
        return repository.findById(id);
    }

    public List<ClientModel> findAll() {
        return repository.findAll();
    }

    public ClientModel save(ClientModel model) {
        return repository.save(model);
    }

    public ClientModel update(ClientModel model) {
        var found = repository.findById(model.getId());
        if (found.isPresent()) {
            found.get().setName(model.getName());
            found.get().setGender(model.getGender());
            found.get().setCity(model.getCity());
            return repository.save(found.get());
        } else {
            return null;
        }
    }

    public void delete(long id) {
        var found = repository.findById(id);
        if (found.isPresent()) {
            repository.delete(found.get());
        }
    }
}
