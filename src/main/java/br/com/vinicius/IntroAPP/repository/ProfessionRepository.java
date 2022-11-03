package br.com.vinicius.IntroAPP.repository;

import br.com.vinicius.IntroAPP.model.ProfessionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessionRepository extends JpaRepository<ProfessionModel, Long>{

    Optional<ProfessionModel> findById(long id);
}
