package id.koneko096.swagger.data.repositories;

import id.koneko096.swagger.data.model.Citizen;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CitizenRepository extends CrudRepository<Citizen, Long> {
    @Override
    List<Citizen> findAll();
}
