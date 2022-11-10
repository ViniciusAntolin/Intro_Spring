package br.com.vinicius.IntroAPP.repository;

import br.com.vinicius.IntroAPP.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long>{

    Optional<ClientModel>findById(long id);

    List<ClientModel> findByNameContainsIgnoreCaseOrderByName(String name);

    //New methods of V2
    List<ClientModel> findByEmailStartsWithIgnoreCase(String email);
}